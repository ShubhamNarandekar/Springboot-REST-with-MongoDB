package core;

/* Same as quotation, identify each grade for a student */

public class Grade {

    public Grade(String name, String studentNumber, double grade_percentage) {
        this.name = name;
        this.id = studentNumber;
        this.grade = grade_percentage;
    }

    public Grade() {}

    private String name;
    private String id;
    private double grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getLetter() {
        double percentage = this.getGrade();
        if(percentage >= 95) {return "A+";}  // was thinking of shortening this by using
        else if(percentage >= 90) {return "A";} // arrays but too tired to do it at the moment
        else if(percentage >= 85) {return "A-";}
        else if(percentage >= 80) {return "B+";}
        else if(percentage >= 75) {return "B";}
        else if(percentage >= 70) {return "B-";}
        else if(percentage >= 65) {return "C+";}
        else if(percentage >= 60) {return "C";}
        else if(percentage >= 55) {return "C-";}
        else if(percentage >= 50) {return "D+";}
        else if(percentage >= 45) {return "D";}
        else if(percentage >= 40) {return "D-";}
        else if(percentage >= 35) {return "E+";}
        else if(percentage >= 30) {return "E";}
        else if(percentage >= 25) {return "E-";}
        else if(percentage >= 20) {return "F+";}
        else if(percentage >= 15) {return "F";}
        else if(percentage >= 10) {return "F-";}
        else {return "NG";}
    }
}
