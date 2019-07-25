package monster;

import Controller.Main;

public class MonsterTestDrive extends Main {
    public MonsterTestDrive(){
        this.testDrive();
    }
    public void testDrive() {
        // 다형성의 하나, 오버라이드(재정의)
        Monster[] ma = new Monster[3];
        ma[0] = new Vampire();
        ma[1] = new Dragon();
        ma[2] = new Monster();

        Integer a = 1;
        Integer b = 2;

        for(int x = 0; x < 3; x++){
            ma[x].frighten(x);
            ma[x].move();

        }
        Dragon ma2 = new Dragon();
        ma2.frighten(a,b);

    }



}
