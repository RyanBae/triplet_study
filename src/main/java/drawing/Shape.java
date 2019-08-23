package drawing;

import java.awt.*;
import java.util.ArrayList;

public class Shape {
    public final static int Line = 1;
    public final static int Polygon = 2;
    public final static int Rectangle = 3;
    public final static int Circle = 4;
    public final static int Undo = 5;
    public final static int Redo = 6;

    private int type, log;
    private ArrayList<Point> startPoints;
    private ArrayList<Point> endPoints;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLog() {
        return log;
    }

    public void setLog(int log) {
        this.log = log;
    }

    public ArrayList<Point> getStartPoints() {
        return startPoints;
    }

    public void setStartPoints(ArrayList<Point> startPoints) {
        this.startPoints = startPoints;
    }

    public ArrayList<Point> getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(ArrayList<Point> endPoints) {
        this.endPoints = endPoints;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "type=" + type +
                ", log=" + log +
                ", startPoints=" + startPoints +
                ", endPoints=" + endPoints +
                '}';
    }
}
