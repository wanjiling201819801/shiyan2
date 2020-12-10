package shiyan2_v1_1.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import shiyan2_v1_1.code.*;

public class Exercise_v1_1Test {
    Exercise_v1_1 ex;
    @Before
    public void init() throws Exception{
        ex = new BinaryExercise();
    }

    /**
    * Method: occurIn(Equation_v1_1 equ)
    */
    @Test
    public void testOccurIn() throws Exception {
        Equation_v1_1 toExEqu = new AdditionEquation();
        toExEqu.construct(11,22,'+');

        Equation_v1_1 equ1 = new SubstractEquation();
        equ1.construct(22,11,'-');
        ex.equsList.add(equ1);
        Assert.assertEquals(false,ex.occurIn(toExEqu));

        Equation_v1_1 equ2 = new AdditionEquation();
        equ2.construct(11,33,'+');
        ex.equsList.add(equ2);
        Assert.assertEquals(false,ex.occurIn(toExEqu));

        Equation_v1_1 equ3 = new AdditionEquation();
        equ3.construct(22,11,'+');
        ex.equsList.add(equ3);
        Assert.assertEquals(true,ex.occurIn(toExEqu));
    }

    /**
    * Method: printExercise()
    */
    @Test
    public void testPrintExercise() throws Exception {
        ex.generateExercise();
        ex.printExercise();
    }

    /**
    * Method: showStandardAnswer()
    */
    @Test
    public void testShowStandardAnswer() throws Exception {
        ex.generateExercise();
        ex.showStandardAnswer();
    }
} 
