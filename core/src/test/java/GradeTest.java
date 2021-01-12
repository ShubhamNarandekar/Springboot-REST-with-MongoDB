import static org.junit.Assert.*;
import core.Grade;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GradeTest {

    private static Grade myGrade;

    @BeforeClass
    public static void setup() {
        // Intalisate grade
        myGrade = new Grade("student", "0", 0);
    }

    @Test
    public void getLetterTest(){
        assertNotNull(myGrade);

        // Set grade for Letter test
        myGrade.setGrade(90);
        assertEquals(myGrade.getLetter(), "A");
        myGrade.setGrade(75);
        assertEquals(myGrade.getLetter(), "B");
        myGrade.setGrade(60);
        assertEquals(myGrade.getLetter(), "C");
        myGrade.setGrade(45);
        assertEquals(myGrade.getLetter(), "D");
        myGrade.setGrade(30);
        assertEquals(myGrade.getLetter(), "E");
        myGrade.setGrade(15);
        assertEquals(myGrade.getLetter(), "F");


        // Ensures that a GridPane is returned
        assertTrue(myGrade instanceof Grade);
    }

    @Test
    public void IdTest(){
        myGrade.setId("120998");
        assertEquals(myGrade.getId(), "120998");
    }

    @Test
    public void NameTest(){
        myGrade.setName("Rohan");
        assertEquals(myGrade.getName(), "Rohan");

    }
}
