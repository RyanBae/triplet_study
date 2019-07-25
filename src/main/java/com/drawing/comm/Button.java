package com.drawing.comm;

import javax.swing.*;

public class Button extends Drawingbook{

    public static void button(){
        String[] button_name = {"Line","Rectangle","Circle","Polygon"
                ,"undo","redo"};
        JButton line = new JButton("Line");
        JButton rect = new JButton("Rectangle");
        JButton circ = new JButton("Circle");
        JButton ploy = new JButton("Polygon");
        JButton undo = new JButton("undo");
        JButton redo = new JButton("redo");

    }
}
