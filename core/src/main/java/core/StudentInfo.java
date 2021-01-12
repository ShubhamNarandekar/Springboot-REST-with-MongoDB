package core;

public class StudentInfo extends AbstractStudent {
    public static final char MALE = 'M';
    public static final char FEMALE = 'F';

    public StudentInfo(String className, String name, char gender, int age, double gpa, String studentNumber) {
        this.className = className;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.gpa = gpa;
        this.studentNumber = studentNumber;
    }

    public StudentInfo() {}

    private String className;
    private String name;
    private char gender;
    private int age;
    private double gpa;
    private String studentNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
