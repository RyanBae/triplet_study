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
    JLabel xycoord ;
    Point mouse = new Point(0,0);
    ArrayList points = new ArrayList();
    ArrayList epoints = new ArrayList();
    Map<Object, Integer> emptypo = new HashMap<>();
    Map<Object, Integer> map = new HashMap<>();
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
                System.out.println(" SavePoint : "+ savePoint);
                emptypo = savePoint.pop();
                System.out.println(" emptypo : "+emptypo);
                super.repaint();
            }else if(i==6) {
                System.out.println(" Redo ??? ");
                savePoint.push(emptypo);
                super.repaint();
            }
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("savePoint size ======> "+savePoint.size());
        System.out.println("savePoint list ======> "+savePoint);
        System.out.println("============================================");
        System.out.println("ReadPoint size ======> "+readPoint.size());
        System.out.println("ReadPoint list ======> "+readPoint);
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


}



