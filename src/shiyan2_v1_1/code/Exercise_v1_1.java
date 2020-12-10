package shiyan2_v1_1.code;

import shiyan2_v1_1.code.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Exercise_v1_1 {
    private static final int EQUATIONS_NUMBER = 50;
    private static final int COLNUM_NUMBER = 5;
    private static final int OPERATOR_NUMBER = 2;
    public List<Equation_v1_1> equsList = new ArrayList<Equation_v1_1>();

    Exercise_v1_1(){};
    //分别生成加、减、混合的习题集
    public static void main(String[] args) {

        Exercise_v1_1 anAddExercise = new AdditionExercise();
        Exercise_v1_1 anSubExercise = new SubstractExercise();
        Exercise_v1_1 anBinExercise = new BinaryExercise();

        System.out.println("屏幕显示50道加法题集：");
        anAddExercise.generateExercise();
        anAddExercise.printExercise();

        System.out.println("屏幕显示50道减法题集：");
        anSubExercise.generateExercise();
        anSubExercise.printExercise();

        System.out.println("屏幕显示50道加减法混合题集：");
        anBinExercise.generateExercise();
        anBinExercise.printExercise();

    }

    //生成题集
    public abstract void generateExercise();

    //判断生成算式在题集中是否存在 存在 true 不存在 false
    public boolean occurIn(Equation_v1_1 equ){
        for (Equation_v1_1 equObj: equsList) {
            if(equ.isEqual( equObj)){
                return  true;
            }
        }
        return false;
    }

    //打印习题集
    public void printExercise(){
        //按一定要求打印
        System.out.println("*********************************习题*********************************");
        for (int i = 0; i < EQUATIONS_NUMBER; i++) {
            System.out.print(equsList.get(i).equString());
            if((i+1)%COLNUM_NUMBER==0){
                System.out.println();
            }
        }
    }

    //显示参考答案
    public void showStandardAnswer(){
        System.out.println("*******************************习题答案********************************");
        for (int i = 0; i < EQUATIONS_NUMBER; i++) {
            System.out.print(equsList.get(i).equAnsString());
            if((i+1)%COLNUM_NUMBER==0){
                System.out.println();
            }
        }
    }
    public int getEquationsNum(){
        return EQUATIONS_NUMBER;
    }
    public int getColnumNum(){
        return COLNUM_NUMBER;
    }
    public int getOperatorNum(){
        return OPERATOR_NUMBER;
    }
}
