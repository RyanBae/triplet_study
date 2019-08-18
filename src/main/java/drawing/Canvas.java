package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Canvas extends JPanel {

    int option ;
    int x,y,w,h;
    Point start = null;
    Point end = null;

    JLabel xycoord ;
    Point mouse = new Point(0,0);
    ArrayList points = new ArrayList();
    ArrayList epoints = new ArrayList();

    Map<Object, Object> emptypo = new HashMap<>();
    Map<Object, Object> map = new HashMap<>();
    Stack<Map> savePoint = new Stack<>();
    Stack<Map> readPoint = new Stack<>();

    MyMouseListener ml = new MyMouseListener();


    public void drawLine(int i){
        for(int y = 0; y < this.getMouseListeners().length; y++){
            removeMouseListener(ml);
            removeMouseMotionListener(ml);
        }
        if(i < 5){
            addMouseListener(ml);
            addMouseMotionListener(ml);
            ml.option = i;
            ml.points = points;
            ml.epoints = epoints;
            ml.map = map;
            ml.j = this;
            ml.savePoint = savePoint;
        }else {
            if(i == 5){
                if(savePoint.size() != 0){
                    emptypo = savePoint.pop();
                    readPoint.push(emptypo);
                }
                super.repaint();
            }else if(i == 6) {
                if(readPoint.size() != 0){
                    emptypo = readPoint.pop();
                    savePoint.push(emptypo);
                }
                super.repaint();
            }
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Map<Object, Object> map2 ;
        for (int i=0; i < savePoint.size(); i++){
            // map = savePoint.pop();
            map2 = savePoint.get(i);
            if(map2.get("type").equals(1)){
                for (int z = 0; z < (Integer) map2.get("log"); z ++){
                    points = (ArrayList) map2.get("start");
                    epoints = (ArrayList) map2.get("end");
                    start = (Point) points.get(z);
                    end = (Point) epoints.get(z);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }
            }else if(map2.get("type").equals(2)){
                for (int z = 0; z < (Integer) map2.get("log"); z ++){
                    points = (ArrayList) map2.get("start");
                    epoints = (ArrayList) map2.get("end");
                    start = (Point) points.get(z);
                    end = (Point) epoints.get(z);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }

            }else if(map2.get("type").equals(3)){
                x = (Integer) map2.get("startX");
                y = (Integer) map2.get("startY");
                w = (Integer) map2.get("endX");
                h = (Integer) map2.get("endY");
                g.drawRect(x,y,w,h);
            }else  if(map2.get("type").equals(4)) {
                x = (Integer) map2.get("startX");
                y = (Integer) map2.get("startY");
                w = (Integer) map2.get("endX");
                h = (Integer) map2.get("endY");
                g.drawOval(x, y, w, h);
            }





        }


    }


}



