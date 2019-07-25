package monster;

public class Dragon extends Monster{
    boolean frighten(int degree){
        System.out.println("breath fire");
        return true;
    }
    boolean frighten(Integer a, Integer b){
        System.out.println("int ???================");
        return true;
    }

    @Override
    void move() {
        /*super.move();*/
        System.out.println("dragon move");
    }


}
