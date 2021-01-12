import core.Grade;
import core.StudentInfo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import t2Tahar.T2Tahar;

import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class T2TaharTest {

    private static Grade myGrade;

    double percentage;

    @BeforeClass
    public static void setup() {
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
        T2Tahar testTeacher = new T2Tahar();
        StudentInfo testBoy = new StudentInfo("CCClassroom", "student", 'M', 18, 2.9, "123456789");
        Grade testGrade = testTeacher.generateGrade(testBoy);
        assertTrue(testGrade.getGrade() >= 25);
    }

}
