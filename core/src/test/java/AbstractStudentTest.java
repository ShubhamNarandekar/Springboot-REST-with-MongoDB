import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import core.AbstractStudent;
import core.testAbstractStudent;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


@SpringBootTest
public class AbstractStudentTest {

    private static testAbstractStudent abstractStudent;

    @BeforeClass
    public static void setup() {
        abstractStudent = new testAbstractStudent();
    }

    @Test
    public void generateIDTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String s = abstractStudent.generateID();
        String s2 = abstractStudent.generateID();


        assertEquals("00001000", s);
        assertEquals("00001001", s2);
    }

}