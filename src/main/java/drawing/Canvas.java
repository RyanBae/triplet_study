package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;


public class Canvas extends JPanel {

    MyMouseListener ml = new MyMouseListener();
    Point start = null;
    Point end = null;
    Stack<Shape> savePoint = new Stack<>();
    Stack<Shape> readPoint = new Stack<>();

    public void draw(int i){
        for(int y = 0; y < this.getMouseListeners().length; y++){
            removeMouseListener(ml);
            removeMouseMotionListener(ml);
        }
        if(i < 5){
            addMouseListener(ml);
            addMouseMotionListener(ml);
            ml.option = i;
            ml.jPanel = this;
        }else {
            if(i == 5){
                if(savePoint.size() != 0){
                    readPoint.push(savePoint.pop());
                }
                super.repaint();
            }else if(i == 6) {
                if(readPoint.size() != 0){
                    savePoint.push(readPoint.pop());
                }
                super.repaint();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < savePoint.size(); i++){
            if (savePoint.get(i) instanceof  Rectangle){
                g.drawRect(savePoint.get(i).x, savePoint.get(i).y, savePoint.get(i).width, savePoint.get(i).height);

            }else if(savePoint.get(i) instanceof Circle){
                g.drawOval(savePoint.get(i).x, savePoint.get(i).y, savePoint.get(i).width, savePoint.get(i).height);

            }else if(savePoint.get(i) instanceof Line){
                for(int j = 0; j < savePoint.get(i).getStartPoints().size()-1; j++){
                    start = savePoint.get(i).getStartPoints().get(j);
                    end = savePoint.get(i).getStartPoints().get(j+1);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }
            }else if(savePoint.get(i) instanceof Polygon){
                for(int j = 0; j < savePoint.get(i).getPolyPoints().size()-1; j++){
                    start = savePoint.get(i).getPolyPoints().get(j);
                    end = savePoint.get(i).getPolyPoints().get(j+1);
                    g.drawLine(start.x, start.y, end.x, end.y);
                }
            }
        }
    }
}



