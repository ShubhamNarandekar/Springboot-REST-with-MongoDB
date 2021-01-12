package examoffice.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "classrecord")
public class ClassDoc {
    @Id
    //private Integer id;
    private String Classname;
    private double AverageGrade;


    public String getClassname() {
        return Classname;
    }

    public double getAverageGrade() {
        return AverageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.AverageGrade = averageGrade;
    }

    public void setClassname(String classname) {
        this.Classname = classname;
    }
}
