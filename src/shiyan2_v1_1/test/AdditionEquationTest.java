package shiyan2_v1_1.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shiyan2_v1_1.code.AdditionEquation;
import shiyan2_v1_1.code.Equation_v1_1;

public class AdditionEquationTest {
    Equation_v1_1 addEqu;
    @Before
    public void init(){
        addEqu = new AdditionEquation();
    }

    /**
     * 测试计算答案是否正确
     */
    @Test
    public void testCalculateAnswer() {
        addEqu.construct(100,2,'+');
        Assert.assertEquals(102,addEqu.calculateAnswer());

        addEqu.construct(0,100,'+');
        Assert.assertEquals(100,addEqu.calculateAnswer());
    }

    /**
     * 测试减法算式是否合格
     * 直到遇到符合和小于等于100的两个数才生成一个新的加法算式
     */
    @Test
    public void testNewAdditionEquation(){
        int[] left = new int[]{100,11,99,2};
        int[] right = new int[]{11,91,1,11};
        int i=-1;
        do{
            i++;
            addEqu.construct(left[i],right[i],'+');
            System.out.println(addEqu.equString());
        }while(addEqu.checkEquation(left[i], right[i]));
        Assert.assertEquals(2,i);
    }

    /**
     *   测试CheckEquation()函数
     *   能否有效检测算式和大于100
     */
    @Test
    public void testCheckEquation(){
        int[] left = new int[]{99,1,100,100};
        int[] right = new int[]{11,99,1,0};
        Assert.assertEquals(true,addEqu.checkEquation(left[0],right[0]));
        Assert.assertEquals(false,addEqu.checkEquation(left[1],right[1]));
        Assert.assertEquals(true,addEqu.checkEquation(left[2],right[2]));
        Assert.assertEquals(false,addEqu.checkEquation(left[3],right[3]));
    }

}
