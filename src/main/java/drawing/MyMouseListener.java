package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class MyMouseListener extends MouseAdapter implements MouseMotionListener {

    int sx, sy;
    int width, hight;
    Point start = null;
    Point end = null;
    Point polyStart = null;
    int option;

    ArrayList points ;
    ArrayList epoints;
    Stack<Map> savePoint;

    JPanel j ;

    public void mousePressed(MouseEvent e){
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();
        Map<Object, Object> pushMap = new HashMap<>();
        start = null;

        if(option == 1){
           end = null;
           start = e.getPoint();

        }else if(option == 2){
            if (e.getButton()==MouseEvent.BUTTON1) {
                start = e.getPoint();
                if(polyStart ==null){
                    polyStart = start;
                    points.add(start);
                }else {
                    if(end == null){
                        start = polyStart;
                    }else {
                        start = end;
                        points.add(start);
                    }
                    end = e.getPoint();
                    epoints.add(end);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }

            } else if(e.getButton() == MouseEvent.BUTTON3){
                g.drawLine(end.x, end.y, polyStart.x, polyStart.y);
                points.add(end);
                epoints.add(polyStart);
                pushMap.put("type", 2);
                pushMap.put("log", points.size());
                pushMap.put("polystart", points);
                pushMap.put("polyend", epoints);
                savePoint.push(pushMap);
                j.repaint();
                start = null;
                end = null;
                polyStart=null;
            }

        }else if(option ==3){
            start = e.getPoint();

        }else if(option==4){
            start = e.getPoint();
            if(sx != 0){
                g.drawRect(start.x, start.y, sx, sy);
            }
        }

    }
    public void mouseReleased(MouseEvent e) {
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();
        Map<Object, Object> pushMap = new HashMap<>();
        if(option==1){
            pushMap.put("type", 1);
            pushMap.put("log", points.size());
            pushMap.put("start", points);
            pushMap.put("end", epoints);
            savePoint.push(pushMap);
            j.repaint();
            start = null;
            end = null;

        }else if(option==3){
            pushMap.put("type", 3);
            pushMap.put("endY", Math.abs(hight));
            pushMap.put("endX",  Math.abs(width));
            pushMap.put("startY", sy);
            pushMap.put("startX", sx);
            savePoint.push(pushMap);
            j.repaint();
            start = null;
            end = null;

        }else if(option == 4){
            pushMap.put("type", 4);
            pushMap.put("endY", Math.abs(hight));
            pushMap.put("endX",  Math.abs(width));
            pushMap.put("startY", sy);
            pushMap.put("startX", sx);
            savePoint.push(pushMap);
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
                    points.add(start);
                    epoints.add(end);
                    g.drawLine(start.x, start.y, end.x, end.y);

                }
            }else if(option == 3){
                end = e.getPoint();
                width = end.x - start.x;
                hight = end.y - start.y;
                sx = Math.min(start.x, end.x);
                sy = Math.min(start.y, end.y);
                j.repaint();
                g.drawRect(sx, sy , Math.abs(width), Math.abs(hight));

        }else if(option == 4){
                end = e.getPoint();
                width = end.x - start.x;
                hight = end.y - start.y;
                sx = Math.min(start.x, end.x);
                sy = Math.min(start.y, end.y);
                j.repaint();
                g.drawOval(sx, sy , Math.abs(width), Math.abs(hight));

            }


    }

}
