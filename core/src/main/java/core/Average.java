package core;

public class Average {
    private double average;
    private String className;

    public Average(double avg, String name){
        this.average = avg;
        this.className = name;
    }

    public Average() {}

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
