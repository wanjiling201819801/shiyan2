package shiyan2.code;

import java.util.Random;

public class Equation {
    private static final int MAX_OPERAND = 100;
    private static final int MIN_OPERAND = 0;
    public static final int EQUATION_SPACING = 13;
    public static final int OPERATOR_NUMBER = 2;

    private char operator;
    private int leftOperand;
    private int rightOperand;
    private int standardAnswer;

    //构造方法
    public Equation(){
        operator = '+';
        leftOperand = 0;
        rightOperand = 0;
        standardAnswer = 0;
    }

    //三种算式表示 加、减、加减随机生成
    //生成加法算式
    public Equation newAdditionEquation(){
        Equation newAddEqu = new Equation();
        int left, right;
        left = getOperand();
        do{
            right = getOperand();
        }while(!checkAdditionEquation(left, right));
        newAddEqu.construct(left, right, '+');
        return newAddEqu;
    }

    //生成减法算式
    public Equation newSubstractionEquation(){
        Equation newSubEqu = new Equation();
        int left, right;
        left = getOperand();
        do{
            right = getOperand();
        }while(!checkSubstractEquation(left, right));
        newSubEqu.construct(left, right, '-');
        return newSubEqu;
    }

    //生成加减随机生成算式
    public Equation newBinaryEquation(){
        Equation newBinEqu = new Equation();
        Random random = new Random();
        int sign = random.nextInt(OPERATOR_NUMBER);
        if(0 == sign){
            newBinEqu = newSubstractionEquation();
        }else {
            newBinEqu = newAdditionEquation();
        }
        return newBinEqu;
    }

    //赋值 并 计算参考答案
    public int construct(int left, int right, char op){
        operator = op;
        leftOperand = left;
        rightOperand = right;
        if(operator=='+'){
            standardAnswer = left + right;
        }else{
            standardAnswer = left - right;
        }
        return standardAnswer;
    }

    //检查加法算式和小于等于100
    public Boolean checkAdditionEquation(int left,int right){
        return left+right<=100;
    }

    //检查减法算式差大于等于0
    public Boolean checkSubstractEquation(int left, int right){
        return left-right>=0;
    }

    //判断两个算式是否相等
    public Boolean isEqual(Equation equation){
        if(this.operator==equation.operator&&((this.leftOperand==equation.leftOperand&&this.rightOperand==equation.rightOperand)||(this.rightOperand==equation.leftOperand&&this.leftOperand==equation.rightOperand))){
            return true;
        }
        return false;
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
    public String fullString(){
        String string = " "+leftOperand+operator+rightOperand+"="+standardAnswer;
        while(string.length()<=EQUATION_SPACING){
            string += " ";
        }
        return string;
    }

    //获得在0-100之间的操作数
    public int getOperand(){
        Random random = new Random();
        int operand = random.nextInt(MAX_OPERAND+1);
        return operand;
    }

    public int getStandardAnswer() {
        return standardAnswer;
    }
}
