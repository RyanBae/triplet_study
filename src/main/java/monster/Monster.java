package monster;

public class Monster {
    boolean frighten(int d) {
        System.out.println("arrrgh");


        return true;
    }
    void move(){
        Dragon a = new Dragon();
        a.frighten(1,2);
        System.out.println("movemove");
    }


}
