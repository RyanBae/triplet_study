package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class MyMouseListener extends MouseAdapter{

    int width, hight;
    Point start = null;
    Point end = null;
    Point polyStart = null;
    ArrayList<Point> pointArrayList = new ArrayList();
    int option;
    JPanel j ;



    public void mousePressed(MouseEvent e){
        if(option ==1 || option==3 || option==4){
            end = null;
            start = e.getPoint();

        }else {
            start=null;
        }
    }
    public void mouseReleased(MouseEvent e) {
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();

            if (option == 1) {
                Line line = new Line();
                line.setStartPoints(pointArrayList);
                comp.savePoint.push(line);
                j.repaint();
                start = null;
                end = null;
                pointArrayList = new ArrayList<>();

            }else if(option == 2) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    polyStart = e.getPoint();
                    //polyPoints.add(polyStart);
               /*     if(1 < polyPoints.size()) {
                            for (int i = 0; i < polyPoints.size()-1; i++) {
                                start = (Point) polyPoints.get(i);
                                end = (Point) polyPoints.get(i+1);
                                g.drawLine(start.x, start.y, end.x, end.y);
                            }
                        }
                }else if(e.getButton() == MouseEvent.BUTTON3){
                    polyPoints.add(polyPoints.get(0));
*//*                    shape.setLog(polyPoints.size());
                    shape.setPolyPoints(polyPoints);*//*
                    shapeStack.push(shape);
                    j.repaint();
                    polyPoints = new ArrayList();
                    start = null;
                    end = null;
*/                }

            }else if(option == 3 ){
                Rectangle rect = new Rectangle();
                rect.setX(Math.min(start.x, end.x));
                rect.setY(Math.min(start.y, end.y));
                rect.setWidth(Math.abs(width));
                rect.setHeight(Math.abs(hight));
                comp.savePoint.push(rect);
                j.repaint();
                start = null;
                end = null;
            }else {
                Circle cir = new Circle();
                cir.setX(Math.min(start.x, end.x));
                cir.setY(Math.min(start.y, end.y));
                cir.setWidth(Math.abs(width));
                cir.setHeight(Math.abs(hight));
                comp.savePoint.push(cir);
                j.repaint();
                start = null;
                end = null;
             }
        }

    @Override
    public void mouseDragged(MouseEvent e) {
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();


        if(option == 1) {
            if (start != null) {
                end = start;
                start = e.getPoint();
                pointArrayList.add(end);
                g.drawLine(start.x, start.y, end.x, end.y);
            }
        }else if(option == 3 || option == 4){
            end = e.getPoint();
            width = end.x - start.x;
            hight = end.y - start.y;
            j.repaint();
            if(option == 3) {
                g.drawRect(Math.min(start.x, end.x), Math.min(start.y, end.y), Math.abs(width), Math.abs(hight));
            }else {
                g.drawOval(Math.min(start.x, end.x), Math.min(start.y, end.y), Math.abs(width), Math.abs(hight));
            }
        }

    }

}
