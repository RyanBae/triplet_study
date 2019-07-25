package com.drawing.comm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends Frame{
    public Panel(){
        this.createpanel();
    }

    public void createpanel(){
        System.out.println("===> Panel ");

        JPanel p1 = new JPanel();
        p1.setBackground(Color.GRAY);
        p1.setPreferredSize(new Dimension(1024, 50));


        JButton line = new JButton("Line");
        JButton rect = new JButton("Rectangle");
        JButton circ = new JButton("Circle");
        JButton ploy = new JButton("Polygon");
        JButton undo = new JButton("undo");
        JButton redo = new JButton("redo");

        p1.add(line);
        p1.add(rect);
        p1.add(circ);
        p1.add(ploy);
        p1.add(undo);
        p1.add(redo);

        ActionListener ner = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("click!");


            }
        };
        line.addActionListener(ner);
        rect.addActionListener(ner);
        circ.addActionListener(ner);
        ploy.addActionListener(ner);
        undo.addActionListener(ner);
        redo.addActionListener(ner);



    }
}
