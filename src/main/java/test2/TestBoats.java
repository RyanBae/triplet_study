package test2;

public class TestBoats {
    public TestBoats(){
        this.testBoats();
    }
    public void testBoats(){
        Boat b1 = new Boat();
        Sailboat b2 = new Sailboat();
        Rowboat b3 = new Rowboat();
        b2.setLength(32);
        b1.move();
        b3.move();
        b2.move();

    }

}
