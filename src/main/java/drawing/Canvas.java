package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Canvas extends JPanel {

    JLabel xycoord ;
    Point mouse = new Point(0,0);
    MyMouseListener ml = new MyMouseListener();
    ArrayList points = new ArrayList();
    ArrayList epoints = new ArrayList();
    Map<Object, Integer> map = new HashMap<>();
    Stack<Map> savePoint = new Stack<>();
    Stack<Map> readPoint = new Stack<>();

    int x,y,w,h;

    public void drawLine(int i){
        ml.option = i;
        addMouseListener(ml);
        addMouseMotionListener(ml);
        ml.points = points;
        ml.epoints = epoints;
        ml.map = map;
        ml.j = this;
        ml.savePoint = savePoint;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Map<String, Object> map2 ;
            for (int i=0; i < savePoint.size(); i++){
                // map = savePoint.pop();
                map2 = savePoint.get(i);
                if(map2.get("type").equals(1)){
                    x = (Integer) map2.get("startX");
                    y = (Integer) map2.get("startY");
                    w = (Integer) map2.get("endX");
                    h = (Integer) map2.get("endY");
                    g.drawLine(x,y,w,h);
                }else if(map2.get("type").equals(2)){

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

    @Override
    public void repaint(Rectangle r) {
        super.repaint(r);

    }


    @Override
    public void update(Graphics g) {
        super.update(g);
        
        repaint();

    }
}



