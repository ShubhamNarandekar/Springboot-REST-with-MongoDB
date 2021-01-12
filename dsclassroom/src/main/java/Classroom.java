
import core.*;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;

public class Classroom {
    private static String className = Constants.DSCLASS;

    public static void main(String[] args) throws InterruptedException {
        int studentCount = 0;
        double studentCalculation = 0;

        for (StudentInfo student: students) {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<StudentInfo> request = new HttpEntity<>(student);    // 18-20 create object, POST's object to /applications. Received by ExamOffice line 35
            System.out.println("classname = " + className);
            StudentApplication studentApp = restTemplate.postForObject("http://localhost:8080/applications",request, StudentApplication.class); // change localhost to examoffice
            LinkedList<Grade> grades = studentApp.getGrades();                                                                                 //after dockerizing

            displayStudentRecord(student);

            for(Grade grade: grades) {
                studentCalculation += grade.getGrade();
                studentCount++;
                displayResults(grade);

                if(studentCount == students.length) {
                    double avg = studentCalculation/students.length;
                    Average classAverage = new Average(avg,className);
                    restTemplate.postForObject("http://localhost:8080/applications/average",classAverage, Average.class);
                }
            }
        }
    }

    public static void displayResults(Grade results) {
        System.out.println(
                "| Grade: " + String.format("%1$-26s", results.getGrade()) +
                        " | Letter Grade: " + String.format("%1$-24s", results.getLetter()));
        System.out.println("|=================================================================================================================|");
    }

    public static void displayStudentRecord(StudentInfo info) {
        System.out.println("|=================================================================================================================|");
        System.out.println("|                                     |                                     |                                     |");
        System.out.println(
                "| Name: " + String.format("%1$-29s", info.getName()) +
                        " | Gender: " + String.format("%1$-27s", (info.getGender()==StudentInfo.MALE?"Male":"Female")) +
                        " | Age: " + String.format("%1$-30s", info.getAge())+" |");
        System.out.println(
                "| Student Number: " + String.format("%1$-19s", info.getStudentNumber()) +
                        " | GPA: " + String.format("%1$-19s", info.getGpa())+"            |");
        System.out.println("|                                     |                                     |                                     |");
        System.out.println("|=================================================================================================================|");

    }

    public static final StudentInfo[] students = { //just needed examples so filling in randomly
            new StudentInfo(className,"Colm Tang",StudentInfo.MALE,27,4.0,"16760705"),
            new StudentInfo(className,"Shubham Narandekar",StudentInfo.MALE,23,3.9,"20200132"),
            new StudentInfo(className,"Yassr Shaar",StudentInfo.MALE,23,4.1,"14328571"),
            new StudentInfo(className,"Student 4",StudentInfo.MALE,27,3.2,"16760008"),
            new StudentInfo(className,"Student 5",StudentInfo.MALE,25,2.1,"16760007"),
            new StudentInfo(className,"Student 6",StudentInfo.MALE,27,3.4,"16760006"),
            new StudentInfo(className,"Student 7",StudentInfo.MALE,20,1.5,"16760005"),
    };
}