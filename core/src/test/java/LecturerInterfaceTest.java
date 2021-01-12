
import core.LecturerInterface;
import org.junit.Test;

import static org.junit.Assert.*;

public class LecturerInterfaceTest {

    @Test
    public void TypeTest(){
        //Checks that the class LecturerInterface is an interface
        assertTrue(LecturerInterface.class.isInterface());
    }
}
