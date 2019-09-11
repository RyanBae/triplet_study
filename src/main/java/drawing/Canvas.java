package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Canvas extends JPanel {

    MyMouseListener ml = new MyMouseListener();

    Point start = null;
    Point end = null;
    ArrayList points = new ArrayList();
    ArrayList epoints = new ArrayList();
    ArrayList polyPoints = new ArrayList();

    Stack<Shape> savePoint = new Stack<>();
    Stack<Shape> readPoint = new Stack<>();

    public void draw(int i){
        for(int y = 0; y < this.getMouseListeners().length; y++){
            removeMouseListener(ml);
            removeMouseMotionListener(ml);
        }
        if(i < 5){
            addMouseListener(ml);
            addMouseMotionListener(ml);
            ml.option = i;
            ml.startPoints = points;
            ml.endPoints = epoints;
            ml.polyPoints = polyPoints;
            ml.j = this;
            ml.shapeStack = savePoint;

        }else {
            if(i == 5){
                if(savePoint.size() != 0){
                    readPoint.push(savePoint.pop());
                }
                super.repaint();
            }else if(i == 6) {
                if(readPoint.size() != 0){
                    savePoint.push(readPoint.pop());
                }
                super.repaint();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Shape shape;

        for (int i=0; i < savePoint.size(); i++){
            System.out.println(savePoint.get(i));
            if(savePoint.get(i) instanceof Rectangle){
                System.out.println("Rectangle ?????");
            }else {
                System.out.println(" No!!!!!");
            }
            /*if(shape.getType() == Shape.Line ){
                for (int z = 0; z < shape.getLog(); z ++){
                    points = shape.getStartPoints();
                    epoints = shape.getEndPoints();
                    start = (Point) points.get(z);
                    end = (Point) epoints.get(z);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }
            } else if(shape.getType() == Shape.Polygon){
                for (int y = 0; y < shape.getLog()-1; y ++){
                    polyPoints = shape.getPolyPoints();
                    start = (Point) polyPoints.get(y);
                    end = (Point) polyPoints.get(y+1);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }
            }else if(shape.getType() == Shape.Rectangle){



            }else if(shape.getType() == Shape.Circle){
                Circle cir = new Circle();
                end = shape.getEndPoints().get(0);
                cir.setrStartPoint(shape.getStartPoints());
                cir.setrEndPoint(shape.getEndPoints());
                g.drawOval(cir.getrStartPoint().get(0).x, cir.getrStartPoint().get(0).y,
                        cir.getrEndPoint().get(0).x, cir.getrEndPoint().get(0).y);
            }*/
            polyPoints = new ArrayList();
            points = new ArrayList();
            epoints = new ArrayList();
        }
    }
}



