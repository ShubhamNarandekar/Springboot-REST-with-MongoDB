import core.Grade;
import core.LecturerInterface;
import core.StudentInfo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import t1Rem.T1Rem;

import java.util.Random;

import static org.junit.Assert.*;

public class T1RemTest {

    //private static T1Rem rem = new T1Rem();
    //private static StudentInfo studentInfo = new StudentInfo("class", "student name", 'M', 100, 2, "001");


    private static Grade myGrade;

    double percentage;

    @BeforeClass
    public static void setup() {
        StudentInfo testBoy = new StudentInfo("DSClassroom", "student", 'M', 18, 3.0, "123456789");
        myGrade = new Grade("student", "0", 0);
    }

    @Test
    public void gradeTest(){
        Random random = new Random();
        assertNotNull(myGrade);
        assertTrue(myGrade instanceof Grade);
    }

    @Test
    public void generateGradeTest() {
        T1Rem testTeacher = new T1Rem();
        StudentInfo testBoy = new StudentInfo("DSClassroom", "student", 'M', 18, 2.9, "123456789");
        Grade testGrade = testTeacher.generateGrade(testBoy);
        assertTrue(testGrade.getGrade() >= 25);
    }
}
