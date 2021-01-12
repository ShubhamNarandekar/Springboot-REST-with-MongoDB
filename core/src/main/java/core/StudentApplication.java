package core;

import java.util.LinkedList;

public class StudentApplication {
    private StudentInfo info = new StudentInfo();
    private int applicationNumber;
    private LinkedList<Grade> grades = new LinkedList<Grade>();

    public StudentApplication(StudentInfo student, int appNo, LinkedList grade) {
        info = student;
        applicationNumber = appNo;
        grades = grade;
    }

    public StudentApplication() {}

    public StudentInfo getInfo() {
        return info;
    }

    public void setInfo(StudentInfo info) {
        this.info = info;
    }

    public int getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(int applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public LinkedList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(LinkedList<Grade> grades) {
        this.grades = grades;
    }
}
