package shiyan2_v1_1.code;

public class AdditionEquation extends Equation_v1_1 {

    @Override
    public int calculateAnswer() {
        return leftOperand + rightOperand;
    }

    @Override
    public AdditionEquation newEquation() {
        AdditionEquation addEqu = new AdditionEquation();
        int left, right;
        left = getOperand();
        do{
            right = getOperand();
        }while(checkEquation(left, right));
        addEqu.construct(left, right, '+');
        return addEqu;
    }

    @Override
    public Boolean checkEquation(int left, int right) {
        return left+right>100;
    }

    @Override
    public int getOperator() {
        return '+';
    }

}
