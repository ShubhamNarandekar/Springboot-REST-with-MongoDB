import core.Grade;
import core.StudentInfo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import t3Deepak.T3Deepak;

import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class T3DeepakTest {

    private static Grade myGrade;

    double percentage;

    @BeforeClass
    public static void setup() {
        myGrade = new Grade("student", "0", 0);
    }

    @Test
    public void PercentageTest(){
        Random random = new Random();
        assertNotNull(myGrade);
        assertTrue(myGrade instanceof Grade);
    }

    @Test
    public void generateGradeTest() {
        T3Deepak testTeacher = new T3Deepak();
        StudentInfo testBoy = new StudentInfo("MLClassroom", "student", 'M', 18, 2.9, "123456789");
        Grade testGrade = testTeacher.generateGrade(testBoy);
        assertTrue(testGrade.getGrade() >= 10);
    }
}
