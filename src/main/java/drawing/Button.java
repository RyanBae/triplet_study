package drawing;

import javax.swing.*;

public class Button {
     public JButton line, rect, circ, ploy, undo, redo;

     public void button(){
          // 버튼
          line = new JButton("Line");
          rect = new JButton("Rectangle");
          circ = new JButton("Circle");
          ploy = new JButton("Polygon");
          undo = new JButton("undo");
          redo = new JButton("redo");

/*          line.addActionListener(listener);
          rect.addActionListener(listener);
          circ.addActionListener(listener);
          ploy.addActionListener(listener);
          undo.addActionListener(listener);
          redo.addActionListener(listener);*/


     }




}
