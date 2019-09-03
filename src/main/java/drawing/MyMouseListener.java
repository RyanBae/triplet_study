package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


//  맵을 빼고 클레스로 바꿔서 명시 하기.

public class MyMouseListener extends MouseAdapter{

    int width, hight;
    Point start = null;
    Point end = null;
    Point polyStart = null;
    int option;

    ArrayList startPoints;
    ArrayList endPoints;
    Stack<Shape> shapeStack;

    JPanel j ;

    public void mousePressed(MouseEvent e){
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();
        Shape shape = new Shape();
        start = null;

        if(option == Shape.Polygon){
            System.out.println(option +" = "+Shape.Polygon);
            if (e.getButton()==MouseEvent.BUTTON1) {
                start = e.getPoint();
                if(polyStart ==null){
                    polyStart = start;
                    startPoints.add(start);
                }else {
                    if(end != null){
                        start = end;
                        startPoints.add(start);
                        System.out.println(" ? "+startPoints);
                        g.drawLine(start.x, start.y, end.x, end.y);
                    }
                    end = e.getPoint();
                    endPoints.add(end);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }
                System.out.println("startPoint"+startPoints);
                System.out.println("endPoint"+endPoints);
            } else if(e.getButton() == MouseEvent.BUTTON3){
                g.drawLine(end.x, end.y, polyStart.x, polyStart.y);
                startPoints.add(end);
                endPoints.add(polyStart);
                shape.setType(Shape.Polygon);
                shape.setLog(startPoints.size());
                shape.setStartPoints(startPoints);
                shape.setEndPoints(endPoints);
                shapeStack.push(shape);
                j.repaint();
                start = null;
                end = null;
                polyStart=null;
                startPoints = new ArrayList<Point>();
                endPoints = new ArrayList<Point>();

            }

        }else if(option ==Shape.Line || option==Shape.Rectangle || option==Shape.Circle){
            end = null;
            start = e.getPoint();

        }

    }
    public void mouseReleased(MouseEvent e) {
        Shape shape = new Shape();

            if (option == Shape.Line) {
                shape.setType(Shape.Line);

            }else if(option == Shape.Rectangle || option == Shape.Circle){
                start.x = Math.min(start.x, end.x);
                start.y = Math.min(start.y, end.y);
                end.x = Math.abs(width);
                end.y = Math.abs(hight);
                endPoints = new ArrayList<Point>();
                startPoints = new ArrayList<Point>();
                endPoints.add(end);
                startPoints.add(start);
                shape.setType(option);

            }
            shape.setLog(startPoints.size());
            shape.setStartPoints(startPoints);
            shape.setEndPoints(endPoints);
            shapeStack.push(shape);
            j.repaint();


            start = null;
            end = null;


        }



    @Override
    public void mouseDragged(MouseEvent e) {
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();

        if(option == Shape.Line) {
            if (start != null) {
                end = start;
                start = e.getPoint();
                startPoints.add(start);
                endPoints.add(end);
                g.drawLine(start.x, start.y, end.x, end.y);
            }
        }else if(option == Shape.Rectangle || option == Shape.Circle){
            end = e.getPoint();
            width = end.x - start.x;
            hight = end.y - start.y;
            j.repaint();
            if(option == Shape.Rectangle) {
                g.drawRect(Math.min(start.x, end.x), Math.min(start.y, end.y), Math.abs(width), Math.abs(hight));
            }else {
                g.drawOval(Math.min(start.x, end.x), Math.min(start.y, end.y), Math.abs(width), Math.abs(hight));
            }
        }



    }

}
