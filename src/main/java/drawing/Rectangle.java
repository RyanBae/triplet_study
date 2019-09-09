package drawing;

import java.awt.*;
        import java.util.ArrayList;

public class Rectangle extends Shape{
    private ArrayList<Point> rStartPoint;
    private ArrayList<Point> rEndPoint;


    public ArrayList<Point> getrStartPoint() {
        return rStartPoint;
    }

    public void setrStartPoint(ArrayList<Point> rStartPoint) {
        this.rStartPoint = rStartPoint;
    }

    public ArrayList<Point> getrEndPoint() {
        return rEndPoint;
    }

    public void setrEndPoint(ArrayList<Point> rEndPoint) {
        this.rEndPoint = rEndPoint;
    }

}
