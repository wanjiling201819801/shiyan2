package shiyan2_v1_1.code;

public class SubstractEquation extends Equation_v1_1 {

    @Override
    public SubstractEquation newEquation() {
        SubstractEquation subEqu = new SubstractEquation();
        int left, right;
        left = getOperand();
        do{
            right = getOperand();
        }while(checkEquation(left, right));
        subEqu.construct(left, right, '-');
        return subEqu;
    }

    @Override
    public Boolean checkEquation(int left, int right) {
        return left - right < 0;
    }

    @Override
    public int calculateAnswer() {
        return leftOperand - rightOperand;
    }

    @Override
    public int getOperator() {
        return '-';
    }

}