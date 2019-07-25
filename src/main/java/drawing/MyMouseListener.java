package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class MyMouseListener extends MouseAdapter implements MouseMotionListener {

    int temp = 0;
    int makeinstance = 0;
    int top=-1;
    int sx, sy;

    JLabel mode ;
    Point start = null;
    Point end = null;

    int move = 0;
    JLabel xycoord ;
    Point mouse = new Point(0,0);
    int option;


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
    public void mouseReleased(MouseEvent e){
        //end = e.getPoint(); // 드래그 한부분을 종료점으로
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();


        if(option ==2 ){ //다각형
            end = e.getPoint();
            g.drawLine(start.x,start.y,end.x,end.y);
        }else if(option==3){//사각형
            g.drawRect(start.x, start.y, sx, sy);
        }else if(option == 4){
            g.drawOval(start.x, start.y, sx, sy);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Canvas comp = (Canvas) e.getSource();
        Graphics g = comp.getGraphics();
        if(option == 1) {    //라인
            if (start != null) {
                end = start;
                start = e.getPoint();
                System.out.println(start.x + " " + start.y + " " + end.x + " " + end.y);
                g.drawLine(start.x, start.y, end.x, end.y);
            }

        }else if(option == 3){//사각형
            end = e.getPoint();
            sx = end.x - start.x;
            sy = end.y - start.y;
            comp.repaint();
            g.drawRect(start.x, start.y, sx, sy);

        }else if(option == 4){
            end = e.getPoint();
            sx = end.x - start.x;
            sy = end.y - start.y;
            comp.repaint();
            g.drawOval(start.x, start.y, sx, sy);
        }


    }
    @Override
    public void mouseMoved(MouseEvent e) {

        System.out.println(e.getPoint());
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
