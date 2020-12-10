package shiyan2_v1_1.code;


public class SubstractExercise extends Exercise_v1_1{
    @Override
    public void generateExercise() {
        SubstractEquation subEqu = new SubstractEquation();
        SubstractEquation toExEqu;

        for(int i = 0; i< getEquationsNum();i++){
            toExEqu = subEqu.newEquation();
            if(!occurIn(toExEqu)){
                equsList.add(toExEqu);
            }else {
                i--;
            }
        }
    }
}
