package shiyan2_v1_1.test;

import org.junit.Before;
import org.junit.Test;
import shiyan2_v1_1.code.BinaryExercise;

public class BinaryExerciseTest {
    BinaryExercise ex;
    @Before
    public void init() throws Exception{
        ex = new BinaryExercise();
    }
    @Test
    public void testGenerateExercise() {
        ex.generateExercise();
        ex.printExercise();
    }
}
