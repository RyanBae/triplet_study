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

    int temp = 0;
    int makeinstance = 0;
    int top=-1;
    int sx, sy , w, h;
    int width, hight;
    JLabel mode ;
    Point start = null;
    Point end = null;

    int move = 0;
    JLabel xycoord ;
    Point mouse = new Point(0,0);
    int option;

    ArrayList points ;
    ArrayList epoints;
    Map<Object, Integer> map;
    Stack<Map> savePoint;

    JPanel j ;

    public void mousePressed(MouseEvent e){
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();

        if(option == 1){ //라인
           end = null;
           start = e.getPoint();
        }else if(option == 2){//다각형
            start = e.getPoint();
            g.drawLine(start.x,start.y,end.x,end.y);

        }else if(option ==3){ //사각형
            start = e.getPoint();
            System.out.println(start.x+"||"+ start.y);

        }else if(option==4){
            start = e.getPoint();
            if(sx != 0){
                g.drawRect(start.x, start.y, sx, sy);
            }
        }

    }
    public void mouseReleased(MouseEvent e) {
        //end = e.getPoint(); // 드래그 한부분을 종료점으로
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();
        Map<Object, Integer> map3 = new HashMap<>();
        if(option==1){


            //map.put("line");
            j.repaint();

        }else if(option ==2 ){ //다각형
            end = e.getPoint();
            g.drawLine(start.x,start.y,end.x,end.y);
        }else if(option==3){//사각형x`
            map3.put("type", 3);
            map3.put("endY", hight);
            map3.put("endX", width);
            map3.put("startY", start.y);
            map3.put("startX", start.x);
            //g.drawRect(start.x, start.y, sx, sy);
            savePoint.push(map3);
            j.repaint();




        }else if(option == 4){
            map3.put("type", 4);
            map3.put("endY", hight);
            map3.put("endX", width);
            map3.put("startY", start.y);
            map3.put("startX", start.x);
            //g.drawRect(start.x, start.y, sx, sy);
            savePoint.push(map3);

            j.repaint();

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Canvas comp = (Canvas) e.getSource();
            Graphics g = comp.getGraphics();
        Map<Object, Integer> map3 = new HashMap<>();
            if(option == 1) {    //라인
            if (start != null) {
                end = start;
                start = e.getPoint();
                //list 에 저장.
                points.add(start);
                epoints.add(end);
                map3.put("type", 1);
                map3.put("endY", end.y);
                map3.put("endX", end.x);
                map3.put("startY", start.y);
                map3.put("startX", start.x);

                savePoint.push(map3);
                g.drawLine(start.x, start.y, end.x, end.y);

            }

        }else if(option == 3){//사각형
                end = e.getPoint();
                width = end.x - start.x;
                hight = end.y - start.y;
                System.out.println("Start : "+start.x+" , "+start.y+" || End : "+end.x+" , "+end.y + "|| sx,sy ::"+sx +" , "+ sy +" width : "+width +" , hight : "+hight);
                j.repaint();
                g.drawRect(end.x, end.y , Math.abs(width), Math.abs(hight));



        }else if(option == 4){
            end = e.getPoint();
            sx = end.x - start.x;
            sy = end.y - start.y;
            j.repaint();
            g.drawOval(end.x, end.y, sx, sy);
        }


    }
    @Override
    public void mouseMoved(MouseEvent e) {

        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();
        if(option == 2){//다각형
            if(start != null){
                g.drawLine(start.x, start.y, end.x, end.y);

            }
        }else if(option==3){

        }else if(option==4){

        }

    }
}
