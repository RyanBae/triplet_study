package drawing;

import javax.swing.*;
import java.awt.*;


public class Canvas extends JPanel {

    JLabel xycoord ;
    Point mouse = new Point(0,0);
    MyMouseListener ml = new MyMouseListener();

    public void drawLine(int i){
        ml.option = i;
        addMouseListener(ml);
        addMouseMotionListener(ml);

    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

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



