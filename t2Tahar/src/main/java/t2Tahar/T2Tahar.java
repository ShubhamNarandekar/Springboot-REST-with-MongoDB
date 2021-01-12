package t2Tahar;

import core.Grade;
import core.StudentInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class T2Tahar {
    private Map<String, Grade> grades = new HashMap<>();

    @RequestMapping(value="/grades",method= RequestMethod.POST)
    public ResponseEntity<Grade> createGrade(@RequestBody StudentInfo info) throws URISyntaxException {
        System.out.println("Creating Grade");
        Grade grade = generateGrade(info);
        grades.put(grade.getId(), grade);
        String path = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()+ "/grades/"+grade.getId();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(path));
        return new ResponseEntity<>(grade, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/grade/{id}",method=RequestMethod.GET)
    public Grade getResource(@PathVariable("id") String id) {
        Grade grade = grades.get(id);
        if (grade == null) throw new NoSuchGradeException();
        return grade;
    }

    public Grade generateGrade(StudentInfo info) {
        Random random = new Random();
        double percentage;

        percentage = 25+(double) random.nextInt(75);

        return new Grade(info.getName(),info.getStudentNumber(),percentage);
    }
}
