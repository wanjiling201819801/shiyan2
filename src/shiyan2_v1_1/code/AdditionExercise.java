package shiyan2_v1_1.code;

public class AdditionExercise extends Exercise_v1_1 {
    @Override
    public void generateExercise() {
        AdditionEquation addEqu = new AdditionEquation();
        AdditionEquation toExEqu;
        for(int i = 0; i< getEquationsNum();i++){
            toExEqu = addEqu.newEquation();
            if(!occurIn(toExEqu)){
                equsList.add(toExEqu);
            }else {
                i--;
            }
        }

    }
}
