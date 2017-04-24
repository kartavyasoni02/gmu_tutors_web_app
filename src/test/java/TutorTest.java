import org.junit.Test;
import transfer.dto.Tutor;

import static org.junit.Assert.assertTrue;

/**
 * Created by Andrew on 4/22/2017.
 */
public class TutorTest {
    @Test
    public void constructor(){
        Tutor tutor = new Tutor();
        assertTrue(tutor != null);
    }
}
