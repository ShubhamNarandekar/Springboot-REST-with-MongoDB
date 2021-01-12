package examoffice;

import core.Average;
import core.StudentApplication;
import core.StudentInfo;
import examoffice.Document.ClassDoc;
import examoffice.Document.StudentDoc;
import examoffice.Repository.ClassRepository;
import examoffice.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import core.Grade;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ExamOffice {

    //Creating repository object for database
    @Autowired
    private StudentRepository repository;
    @Autowired
    private ClassRepository classrepo;
   
    private StudentDoc sd = new StudentDoc();
    private ClassDoc cd = new ClassDoc();
    
    //Arraylists for storing the grades
    static ArrayList<Double> ds = new ArrayList<Double>(7);
    static ArrayList<Double> cc = new ArrayList<Double>(7);
    static ArrayList<Double> ml = new ArrayList<Double>(7);

    //variable used in classrecord function below
    public double avgds;
    public double avgcc;
    public double avgml;
    
    private HashMap<Integer,StudentApplication> studentApplications = new HashMap<>();
    private int applicationNumber = 0;

    public LinkedList<Grade> getResults(StudentInfo info) {
        LinkedList<Grade> received = new LinkedList<Grade>();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<StudentInfo> request = new HttpEntity<>(info);   // Creates object and POST's object to /grades.
        System.out.println("classname = " + info.getClassName());
        if(info.getClassName().equals("DSClassroom")) {
            System.out.println("Entered DS");
            Grade dsclassGrade = restTemplate.postForObject("http://localhost:8081/grades", request, Grade.class);
            received.add(dsclassGrade);

            //Storing the grades for ds to calculate average
            ds.add(dsclassGrade.getGrade());
            sd.setGrade(dsclassGrade.getLetter());
        }
        else if(info.getClassName().equals("CCClassroom")) {
            System.out.println("Entered CC");
            Grade ccclassGrade = restTemplate.postForObject("http://localhost:8082/grades", request, Grade.class);
            received.add(ccclassGrade);

            //Storing the grades for cc to calculate average
            cc.add(ccclassGrade.getGrade());
            sd.setGrade(ccclassGrade.getLetter());
        }
        else if(info.getClassName().equals("MLClassroom")) {
            System.out.println("Entered ML");
            Grade mlclassGrade = restTemplate.postForObject("http://localhost:8083/grades", request, Grade.class);
            received.add(mlclassGrade);

            //Storing the grades for ml to calculate average
            ml.add(mlclassGrade.getGrade());
            sd.setGrade(mlclassGrade.getLetter());
        }
        return received;
    }

    @RequestMapping(value="/applications",method=RequestMethod.POST)   // This is the line for listening for a POST to /applications (from Classroom line 20)
    public ResponseEntity<StudentApplication> returnGrades(@RequestBody StudentInfo info) throws URISyntaxException {
        LinkedList<Grade> grades = getResults(info);
        StudentApplication studentApp = new StudentApplication(info,applicationNumber,grades);
        studentApplications.put(applicationNumber++,studentApp);

        //Storing into the document for database
        sd.setId(applicationNumber);
        sd.setName(info.getName());
        sd.setStudentnumber(info.getStudentNumber());
        sd.setClassroom(info.getClassName());
       
        
        //Storing the document into the database
        repository.save(sd);

        String path = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()+ "/applications/"+studentApp.getApplicationNumber();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(path));
        return new ResponseEntity<>(studentApp, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/applications/{application-number}",method=RequestMethod.GET)
    public StudentApplication getStudentApplication(@PathVariable("application-number") int studentAppNum) {
        return studentApplications.get(studentAppNum);
    }

    @RequestMapping(value="/applications/average",method=RequestMethod.POST)
    public Average averageML(@RequestBody Average classAverage) throws URISyntaxException {
        cd.setAverageGrade(classAverage.getAverage());
        cd.setClassname(classAverage.getClassName());
        classrepo.save(cd);
        return classAverage;
    }

    @RequestMapping(value="/applications",method = RequestMethod.GET)
    public HashMap<Integer,StudentApplication> getAllApplications() { return studentApplications; }

    @RequestMapping(value="/applications/average",method = RequestMethod.GET)
    public List<ClassDoc> getAllAverages() { return classrepo.findAll(); }

}
