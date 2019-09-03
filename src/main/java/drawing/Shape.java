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
    private ArrayList<Point> polyPoints;

    public static int getLine() {
        return Line;
    }

    public static int getPolygon() {
        return Polygon;
    }

    public static int getRectangle() {
        return Rectangle;
    }

    public static int getCircle() {
        return Circle;
    }

    public static int getUndo() {
        return Undo;
    }

    public static int getRedo() {
        return Redo;
    }

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

    public ArrayList<Point> getPolyPoints() {
        return polyPoints;
    }

    public void setPolyPoints(ArrayList<Point> polyPoints) {
        this.polyPoints = polyPoints;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "type=" + type +
                ", log=" + log +
                ", startPoints=" + startPoints +
                ", endPoints=" + endPoints +
                ", polyPoints=" + polyPoints +
                '}';
    }
}
