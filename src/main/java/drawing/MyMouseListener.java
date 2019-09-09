package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;




public class MyMouseListener extends MouseAdapter{

    int width, hight;
    Point start = null;
    Point end = null;
    Point polyStart = null;
    int option;

    ArrayList startPoints;
    ArrayList endPoints;
    ArrayList polyPoints;
    Stack shapeStack;
    JPanel j ;

    public void mousePressed(MouseEvent e){
        if(option ==Shape.Line || option==Shape.Rectangle || option==Shape.Circle){
            end = null;
            start = e.getPoint();

        }else {
            start=null;
        }
    }
    public void mouseReleased(MouseEvent e) {
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();
        Shape shape = new Shape();
        Rectangle rect = new Rectangle();

            if (option == Shape.Line) {
                shape.setType(Shape.Line);
                shape.setLog(startPoints.size());
                shape.setStartPoints(startPoints);
                shape.setEndPoints(endPoints);
                shapeStack.push(shape);
                j.repaint();
                startPoints = new ArrayList();
                endPoints = new ArrayList();
                start = null;
                end = null;

            }else if(option == Shape.Polygon) {
                shape.setType(Shape.Polygon);
                System.out.println(polyPoints);
                if(e.getButton() == MouseEvent.BUTTON1){
                    polyStart = e.getPoint();
                    polyPoints.add(polyStart);
                    if(1 < polyPoints.size()) {
                            for (int i = 0; i < polyPoints.size()-1; i++) {
                                start = (Point) polyPoints.get(i);
                                end = (Point) polyPoints.get(i+1);
                                g.drawLine(start.x, start.y, end.x, end.y);
                            }
                        }
                }else if(e.getButton() == MouseEvent.BUTTON3){
                    polyPoints.add(polyPoints.get(0));
                    shape.setLog(polyPoints.size());
                    shape.setPolyPoints(polyPoints);
                    shapeStack.push(shape);
                    j.repaint();
                    polyPoints = new ArrayList();
                    start = null;
                    end = null;
                }

            }else if(option == Shape.Rectangle ){
                start.x = Math.min(start.x, end.x);
                start.y = Math.min(start.y, end.y);
                end.x = Math.abs(width);
                end.y = Math.abs(hight);
                endPoints = new ArrayList<Point>();
                startPoints = new ArrayList<Point>();
                endPoints.add(end);
                startPoints.add(start);
                rect.setrStartPoint(startPoints);
                rect.setrEndPoint(endPoints);
                System.out.println(rect.getrStartPoint()+" , "+rect.getrEndPoint());
                shape.setLog(startPoints.size());
                shape.setStartPoints(startPoints);
                shape.setEndPoints(endPoints);
                shape.setType(option);
                shapeStack.push(shape);
                j.repaint();
                start = null;
                end = null;
            }else {
                start.x = Math.min(start.x, end.x);
                start.y = Math.min(start.y, end.y);
                end.x = Math.abs(width);
                end.y = Math.abs(hight);
                endPoints = new ArrayList<Point>();
                startPoints = new ArrayList<Point>();
                endPoints.add(end);
                startPoints.add(start);
                rect.setrStartPoint(startPoints);
                rect.setrEndPoint(endPoints);
                shape.setType(option);
                shape.setLog(startPoints.size());
                shape.setStartPoints(startPoints);
                shape.setEndPoints(endPoints);
                shapeStack.push(shape);
                j.repaint();
                start = null;
                end = null;
        }
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
