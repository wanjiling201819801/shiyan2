package shiyan2_v1_1.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shiyan2_v1_1.code.Equation_v1_1;
import shiyan2_v1_1.code.SubstractEquation;

public class SubstractEquationTest {
    Equation_v1_1 subEqu;
    @Before
    public void init(){
        subEqu = new SubstractEquation();
    }

    @Test
    public void testCalculateAnswer() {
        subEqu.construct(100,2,'-');
        Assert.assertEquals(98, subEqu.calculateAnswer());

        subEqu.construct(11,111,'-');
        Assert.assertEquals(-100, subEqu.calculateAnswer());
    }

    /**
     * 测试减法算式是否合格
     * 直到遇到符合差大于等于0的两个数
     * 生成减法算式
     */
    @Test
    public void testNewSubstractEquation(){
        int[] left = new int[]{100,99,99,2};
        int[] right = new int[]{111,100,1,11};
        int i=-1;
        do{
            i++;
            subEqu.construct(left[i],right[i],'+');
            System.out.println(subEqu.equString());
        }while(subEqu.checkEquation(left[i], right[i]));
        Assert.assertEquals(2,i);
    }
    /**
     * 测试减法算式的约束条件是否符合要求
     */
    @Test
    public void testCheckEquation(){
        int[] left = new int[]{99,1,100,100};
        int[] right = new int[]{11,99,1,0};
        Assert.assertEquals(false, subEqu.checkEquation(left[0],right[0]));
        Assert.assertEquals(true, subEqu.checkEquation(left[1],right[1]));
        Assert.assertEquals(false, subEqu.checkEquation(left[2],right[2]));
        Assert.assertEquals(false, subEqu.checkEquation(left[3],right[3]));
    }

}
