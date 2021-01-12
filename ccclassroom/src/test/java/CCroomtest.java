import core.StudentInfo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class CCroomtest {

    private static StudentInfo studentInfo;

    @BeforeClass
    public static void setup(){
        studentInfo = new StudentInfo();
    }

    @Test
    public void testGetName() {
        studentInfo.setName("Colm");
        assertEquals(studentInfo.getName(),"Colm");
    }


    @Test
    public void testAge(){
        studentInfo.setAge(27);
        assertEquals(studentInfo.getAge(),27);
    }


}
