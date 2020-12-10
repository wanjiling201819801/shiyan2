package shiyan2_v1_1.code;

import java.util.Random;

public abstract class Equation_v1_1 {
    private static final int MAX_OPERAND = 100;
    private static final int MIN_OPERAND = 0;
    private static final int EQUATION_SPACING = 13;

    char operator;
    int leftOperand;
    int rightOperand;
    int standardAnswer;

    //抽象方法，将在子类中重写
    public abstract Boolean checkEquation(int left,int right);  //算式和、差的约束条件不一样
    public abstract int getOperator();                          //算式的操作符不一样
    public abstract int calculateAnswer();                      //计算答案的方法不一样
    public abstract Equation_v1_1 newEquation();                //生成算式不一样

    //生成在[0,100]区间的操作数
    public int getOperand(){
        Random random = new Random();
        int operand = random.nextInt(MAX_OPERAND+1);
        return operand;
    }

    //赋值 并 计算参考答案
    public void construct(int left, int right, char op){
        operator = op;
        leftOperand = left;
        rightOperand = right;
        standardAnswer = calculateAnswer();
    }

    //判断两个算式是否相等
    public Boolean isEqual(Equation_v1_1 equation){
        return this.operator==equation.operator&&
                ((this.leftOperand==equation.leftOperand&&this.rightOperand==equation.rightOperand)
                        ||(this.rightOperand==equation.leftOperand&&this.leftOperand==equation.rightOperand));
    }

    //将算式转化成字符串输出
    public String equString(){
        String string = " "+leftOperand+operator+rightOperand+"=";
        while(string.length()<=EQUATION_SPACING){
            string += " ";
        }
        return string;
    }

    //将算式及答案转化成字符串输出
    public String equAnsString(){
        String string = " "+leftOperand+operator+rightOperand+"="+standardAnswer;
        while(string.length()<=EQUATION_SPACING){
            string += " ";
        }
        return string;
    }

}
