package shiyan2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shiyan2.code.Equation;
import shiyan2.code.Exercise;

public class test {
    Exercise ex;
    @Before
    public void init(){
        ex = new Exercise();
    }

    @Test
    public void testOccurIn(){
        Equation toExEqu = new Equation();
        toExEqu.construct(11,22,'+');

        Equation equ1 = new Equation();
        equ1.construct(22,11,'-');
        ex.equsList.add(equ1);
        Assert.assertEquals(false,ex.occurIn(toExEqu));

        Equation equ2 = new Equation();
        equ2.construct(11,33,'+');
        ex.equsList.add(equ2);
        Assert.assertEquals(false,ex.occurIn(toExEqu));

        Equation equ3 = new Equation();
        equ3.construct(22,11,'+');
        ex.equsList.add(equ3);
        Assert.assertEquals(true,ex.occurIn(toExEqu));
    }

    @Test
    public void testGenerateAdditionExercise(){
        ex.generateAdditionExercise();
        ex.printExercise();
    }

    @Test
    public void testGenerateSubtractionExercise(){
        ex.generateSubtractExercise();
        ex.printExercise();
    }
    @Test
    public void testGenerateBinaryExercise(){
        ex.generateBinaryExercise();
        ex.printExercise();
    }
    @Test
    public void testPrintExercise(){
        ex.generateBinaryExercise();
        ex.printExercise();
    }
    @Test
    public void testShowStandardAnswer(){
        ex.generateBinaryExercise();
        ex.showStandardAnswer();
    }
}
