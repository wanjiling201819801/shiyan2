package shiyan2_v1_1.test;

import org.junit.Before;
import org.junit.Test;
import shiyan2_v1_1.code.AdditionExercise;

public class AddExerciseTest {
    AdditionExercise ex;
    @Before
    public void init() throws Exception{
        ex = new AdditionExercise();
    }
    @Test
    void testGenerateExercise(){
        ex.generateExercise();
        ex.printExercise();
    }
}