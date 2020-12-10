package shiyan2_v1_1.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shiyan2_v1_1.code.AdditionEquation;
import shiyan2_v1_1.code.Equation_v1_1;
import shiyan2_v1_1.code.SubstractEquation;

public class EquationTest_v1_1 {
    Equation_v1_1 equationV11;
    @Before
    public void init(){
        equationV11 = new AdditionEquation();
    }
    /**
     * 测试得到的操作数是否在0-100之间
     * 这里随机生产成100个数进行检验
     */
    @Test
    public void testGetOperand(){
        boolean result = true;
        for (int i = 0; i < 100; i++) {
            int operand = equationV11.getOperand();
            System.out.print(operand+" ");
            if(operand<0 && operand>100){
                result = false;
            }
        }
        Assert.assertEquals(true,result);
    }

    @Test
    public void testConstruction(){
        equationV11.construct(100,2,'+');
        System.out.println(equationV11.equString());
        equationV11.construct(100,2,'-');
        System.out.println(equationV11.equString());
    }

    @Test
    public void testIsEqual(){
        Equation_v1_1 testedEx1 = new AdditionEquation();
        Equation_v1_1 testedEx2 = new SubstractEquation();
        Equation_v1_1 testedEx3 = new AdditionEquation();

        testedEx1.construct(10,11,'+');
        testedEx2.construct(22,11,'-');
        testedEx3.construct(11,22,'+');
        equationV11.construct(22,11,'+');

        Assert.assertEquals(false, equationV11.isEqual(testedEx1));
        Assert.assertEquals(false, equationV11.isEqual(testedEx2));
        Assert.assertEquals(true, equationV11.isEqual(testedEx3));
    }
}
