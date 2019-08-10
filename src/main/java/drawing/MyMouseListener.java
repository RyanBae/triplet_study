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
        System.out.println(" 왜 두번 타는지 알아? 왜 옵션을 누르면 두번타지? ");
        if(option==1){
            //map.put("line");
            j.repaint();

        }else if(option ==2 ){ //다각형
            end = e.getPoint();
            g.drawLine(start.x,start.y,end.x,end.y);

        }else if(option==3){//사각형
            map3.put("type", 3);
            map3.put("endY", Math.abs(hight));
            map3.put("endX",  Math.abs(width));
            map3.put("startY", sy);
            map3.put("startX", sx);
            //g.drawRect(start.x, start.y, sx, sy);
            System.out.println("사각형 도형 저장!!");
            savePoint.push(map3);
            j.repaint();


        }else if(option == 4){
            map3.put("type", 4);
            map3.put("endY", Math.abs(hight));
            map3.put("endX",  Math.abs(width));
            map3.put("startY", sy);
            map3.put("startX", sx);
            //g.drawRect(start.x, start.y, sx, sy);
            System.out.println("원형 도형 저장!!");
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
               // System.out.println("Start : "+start.x+" , "+start.y+" || End : "+end.x+" , "+end.y + "|| sx,sy ::"+sx +" , "+ sy +" width : "+width +" , hight : "+hight);
                sx = Math.min(start.x, end.x);
                sy = Math.min(start.y, end.y);
                j.repaint();
                g.drawRect(sx, sy , Math.abs(width), Math.abs(hight));



        }else if(option == 4){
                end = e.getPoint();
                width = end.x - start.x;
                hight = end.y - start.y;
                // System.out.println("Start : "+start.x+" , "+start.y+" || End : "+end.x+" , "+end.y + "|| sx,sy ::"+sx +" , "+ sy +" width : "+width +" , hight : "+hight);
                sx = Math.min(start.x, end.x);
                sy = Math.min(start.y, end.y);
                j.repaint();
                g.drawOval(sx, sy , Math.abs(width), Math.abs(hight));

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
