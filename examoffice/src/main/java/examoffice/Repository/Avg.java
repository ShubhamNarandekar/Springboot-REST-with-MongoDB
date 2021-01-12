package examoffice.Repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import examoffice.Document.ClassDoc;

public class Avg {

    //variable used in classrecord function below
    public double avgds;
    public double avgcc;
    public double avgml;

    @Autowired
    private ClassRepository classrepo;
   
    //private StudentDoc sd = new StudentDoc();
    public ClassDoc cd = new ClassDoc();
    

    //Storing average grades into the document and then to database
    //@RequestMapping(value="/applications",method=RequestMethod.POST)
    public void classrecord(ArrayList<Double> ds, ArrayList<Double> cc, ArrayList<Double> ml){
   
    
        for(int i=0; i<=6; i++)
        {
            avgds += ds.get(i);
            avgcc += cc.get(i);
            avgml += ml.get(i);
        }

        avgds = avgds / ds.size();
        avgcc = avgcc / cc.size();
        avgml = avgml / ml.size();

        //Stroing in the Document
        cd.setClassname("DSClassroom");
        cd.setAverageGrade(avgds);
        cd.setClassname("CCClassroom");
        cd.setAverageGrade(avgcc);
        cd.setClassname("MLClassroom");
        cd.setAverageGrade(avgml);

        classrepo.save(cd);
    }
}
