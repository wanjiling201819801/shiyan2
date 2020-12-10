package shiyan2_v1_1.test;

import org.junit.Before;
import org.junit.Test;
import shiyan2_v1_1.code.SubstractExercise;

public class SubstractExerciseTest {
    SubstractExercise ex;
    @Before
    public void init() throws Exception{
        ex = new SubstractExercise();
    }
    @Test
    public void testGenerateExercise() {
        ex.generateExercise();
        ex.printExercise();
    }
}
