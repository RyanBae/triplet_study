package drawing;

import java.awt.*;
import java.util.ArrayList;

public class Shape {
    protected int x, y, width, height;
    private ArrayList<Point> startPoints;
    private ArrayList<Point> endPoints;
    private ArrayList<Point> polyPoints;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

}
