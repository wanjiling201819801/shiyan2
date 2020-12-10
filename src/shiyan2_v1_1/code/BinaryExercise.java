package shiyan2_v1_1.code;

import java.util.Random;

public class BinaryExercise extends Exercise_v1_1{
    @Override
    public void generateExercise() {
        //随机生成加减混合算式
        //这里后期改成一定数目的加法算式和一定数目的减法算式
        //将生成算式和加入题集分开写
        Equation_v1_1 binEqu;
        for (int i = 0; i < getEquationsNum(); i++) {
            Random random = new Random();
            int sign = random.nextInt(getOperatorNum()+1);
            if(0 == sign){
                binEqu = new AdditionEquation().newEquation();
            }else {
                binEqu = new SubstractEquation().newEquation();
            }
            equsList.add(binEqu);
        }
    }
}
