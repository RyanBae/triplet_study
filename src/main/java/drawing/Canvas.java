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

    MyMouseListener ml = new MyMouseListener();

    Point start = null;
    Point end = null;
    ArrayList points = new ArrayList();
    ArrayList epoints = new ArrayList();

    Map<Object, Object> emptypo = new HashMap<>();
    Stack<Map> savePoint = new Stack<>();
    Stack<Map> readPoint = new Stack<>();

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
            drawMap = savePoint.get(i);
            if(drawMap.get("type").equals(1) || drawMap.get("type").equals(2)){
                for (int z = 0; z < (Integer) drawMap.get("log"); z ++){
                    points = (ArrayList) drawMap.get("start");
                    epoints = (ArrayList) drawMap.get("end");
                    start = (Point) points.get(z);
                    end = (Point) epoints.get(z);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }
            }else if(drawMap.get("type").equals(3) || drawMap.get("type").equals(4)){
                if(drawMap.get("type").equals(3)){
                    g.drawRect((Integer) drawMap.get("startX"), (Integer) drawMap.get("startY"), (Integer) drawMap.get("endX"), (Integer) drawMap.get("endY"));
                }else {
                    g.drawOval((Integer) drawMap.get("startX"), (Integer) drawMap.get("startY"), (Integer) drawMap.get("endX"), (Integer) drawMap.get("endY"));
                }
            }
        }
    }
}



