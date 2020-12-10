package shiyan2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shiyan2.code.Equation;

public class EquationTest {
    Equation equation;
    @Before
    public void init(){
        equation = new Equation();
    }

    /**
     * 测试得到的操作数是否在0-100之间
     * 这里随机生产成100个数进行检验
     */
    @Test
    public void testGetOperand(){
        boolean result = true;
        for (int i = 0; i < 100; i++) {
            int operand = equation.getOperand();
            System.out.print(operand+" ");
            if(operand<0&&operand>100){
                result = false;
            }
        }
        Assert.assertEquals(true,result);
    }

    @Test
    public void testConstruction(){
        Assert.assertEquals(102,equation.construct(100,2,'+'));
        Assert.assertEquals(98,equation.construct(100,2,'-'));
    }

    @Test
    public void testCheckAdditionEquation(){
        int[] left = new int[]{10,11,99,100};
        int[] right = new int[]{11,91,1,1};
        Assert.assertEquals(true,equation.checkAdditionEquation(left[0],right[0]));
        Assert.assertEquals(false,equation.checkAdditionEquation(left[1],right[1]));
        Assert.assertEquals(true,equation.checkAdditionEquation(left[2],right[2]));
        Assert.assertEquals(false,equation.checkAdditionEquation(left[3],right[3]));
    }

    @Test
    public void testCheckSubstractEquation(){
        int[] left = new int[]{10,0,99,100};
        int[] right = new int[]{1,1,100,1};
        Assert.assertEquals(true,equation.checkSubstractEquation(left[0],right[0]));
        Assert.assertEquals(false,equation.checkSubstractEquation(left[1],right[1]));
        Assert.assertEquals(false,equation.checkSubstractEquation(left[2],right[2]));
        Assert.assertEquals(true,equation.checkSubstractEquation(left[3],right[3]));
    }

    @Test
    public void testIsEqual(){
        Equation testedEx1 = new Equation();
        Equation testedEx2 = new Equation();
        Equation testedEx3 = new Equation();
        testedEx1.construct(10,11,'+');
        testedEx2.construct(22,11,'-');
        testedEx3.construct(11,22,'+');
        equation.construct(22,11,'+');
        Assert.assertEquals(false,equation.isEqual(testedEx1));
        Assert.assertEquals(false,equation.isEqual(testedEx2));
        Assert.assertEquals(true,equation.isEqual(testedEx3));
    }

    @Test
    public void testNewAdditionEquation(){
        int[] left = new int[]{100,11,99,2};
        int[] right = new int[]{11,91,1,11};
        int i=-1;
        do{
            i++;
            equation.construct(left[i],right[i],'+');
            System.out.println(equation.equString());
        }while(!equation.checkAdditionEquation(left[i], right[i]));
        Assert.assertEquals(2,i);
    }

    @Test
    public void testNewSubstractionEquation(){
        int[] left = new int[]{10,11,99,2};
        int[] right = new int[]{11,91,1,11};
        int i=-1;
        do{
            i++;
            equation.construct(left[i],right[i],'-');
            System.out.println(equation.equString());
        }while(!equation.checkSubstractEquation(left[i], right[i]));
        Assert.assertEquals(2,i);
    }

    @Test
    public void testNewBinaryEquation(){
        int[] sign = new int[]{0,0,1,1,0,1};
        for (int i = 0; i < sign.length; i++) {
            if(0 == sign[i]){
                System.out.println("生成减法");
            }else {
                System.out.println("生成加法");
            }
        }
    }
}
