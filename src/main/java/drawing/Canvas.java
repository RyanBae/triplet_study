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

    boolean ch = false;

    public boolean isCh() {
        return ch;
    }

    public void setCh(boolean ch) {
        this.ch = ch;
    }

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
        Map<Object, Object> drawMap ;
        for (int i=0; i < savePoint.size(); i++){
            // map = savePoint.pop();
            drawMap = savePoint.get(i);
            if(drawMap.get("type").equals(1)){
                for (int z = 0; z < (Integer) drawMap.get("log"); z ++){
                    points = (ArrayList) drawMap.get("start");
                    epoints = (ArrayList) drawMap.get("end");
                    start = (Point) points.get(z);
                    end = (Point) epoints.get(z);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }
            }else if(drawMap.get("type").equals(2)){
                for (int k = 0; k < (Integer) drawMap.get("log"); k ++){
                    points = (ArrayList) drawMap.get("polystart");
                    epoints = (ArrayList) drawMap.get("polyend");
                    start = (Point) points.get(k);
                    end = (Point) epoints.get(k);
                    System.out.println(" Start :: "+ start);
                    System.out.println(" End :: "+ end);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }

            }else if(drawMap.get("type").equals(3)){
                x = (Integer) drawMap.get("startX");
                y = (Integer) drawMap.get("startY");
                w = (Integer) drawMap.get("endX");
                h = (Integer) drawMap.get("endY");
                g.drawRect(x,y,w,h);
            }else  if(drawMap.get("type").equals(4)) {
                x = (Integer) drawMap.get("startX");
                y = (Integer) drawMap.get("startY");
                w = (Integer) drawMap.get("endX");
                h = (Integer) drawMap.get("endY");
                g.drawOval(x, y, w, h);
            }





        }


    }


}



