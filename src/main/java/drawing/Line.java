package drawing;

import java.awt.*;
import java.util.ArrayList;

public class Line {
    Point start, end;
    ArrayList<Point> startPoints, endPoints;
    public Line (Point start, Point end){
        System.out.println(" ++ "+start+" , "+end);
        this.start = start;
        this.end = end;
    }
    public Line(ArrayList startPoints, ArrayList endPoints){
        this.startPoints = startPoints;
        this.endPoints = endPoints;

    }

    public ArrayList<Point> drawLine(){
        ArrayList<Point> result = new ArrayList<>();


        return result;
    }




}
