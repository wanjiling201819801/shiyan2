package shiyan2.code;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private static final int EQUS_NUM = 50;     //习题集包含50道算式
    private static final int COLNUM_NUM = 5;         //一行输出5个算式
    public List<Equation> equsList = new ArrayList<Equation>();
    //分别生成加、减、混合的习题集
    public static void main(String[] args) {

        Exercise anAddExercise = new Exercise();
        Exercise anSubExercise = new Exercise();
        Exercise anBinExercise = new Exercise();

        System.out.println("屏幕显示50道加法题集：");
       anAddExercise.generateAdditionExercise();
       anAddExercise.printExercise();

        System.out.println("屏幕显示50道减法题集：");
        anSubExercise.generateSubtractExercise();
        anSubExercise.printExercise();

        System.out.println("屏幕显示50道加减法混合题集：");
        anBinExercise.generateBinaryExercise();
        anBinExercise.printExercise();

    }
    //三个生成加、减、混合题集的方法，将不重复的算式加紧题集中
    //生成加法题集
    public void generateAdditionExercise(){
        Equation equ = new Equation();
        Equation toExEqu;
        for(int i = 0; i< EQUS_NUM; i++){
            toExEqu = equ.newAdditionEquation();
            if(!occurIn(toExEqu)){
                equsList.add(toExEqu);
            }else {
                i--;
            }
        }
    }

    //生成减法题集
    public void generateSubtractExercise(){
        Equation equ = new Equation();
        Equation toExEqu;
        for(int i = 0; i< EQUS_NUM; i++){
            toExEqu = equ.newSubstractionEquation();
            if(!occurIn(toExEqu)){
                equsList.add(toExEqu);
            }else {
                i--;
            }
        }
    }

    //生成混合题集
    public void generateBinaryExercise(){
        Equation equ = new Equation();
        Equation toExEqu;
        for(int i = 0; i< EQUS_NUM; i++){
            toExEqu = equ.newBinaryEquation();
            if(!occurIn(toExEqu)){
                equsList.add(toExEqu);
            }else {
                i--;
            }
        }
    }

    //判断算式在题集中是否存在 存在 true 不存在 false
    public boolean occurIn(Equation equ){
        for (Equation equObj: equsList) {
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
        for (int i = 0; i < EQUS_NUM; i++) {
            System.out.print(equsList.get(i).equString());
            if((i+1)% COLNUM_NUM ==0){
                System.out.println();
            }
        }
    }

    //显示参考答案
    public void showStandardAnswer(){
        System.out.println("*******************************习题答案********************************");
        for (int i = 0; i < EQUS_NUM; i++) {
            System.out.print(equsList.get(i).fullString());
            if((i+1)% COLNUM_NUM ==0){
                System.out.println();
            }
        }
    }
}
