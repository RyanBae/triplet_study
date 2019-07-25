package com.drawing.comm;

import javax.swing.*;
import java.awt.*;

public class Drawingbook {
    public void base(){
        Dimension dim = new Dimension(1024 , 768);

        JFrame frame = new JFrame("Drawing Board");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //swing 꺼지면 프로세스도 종료하는 메서드
        frame.setLocation(200, 200);
        frame.setPreferredSize(dim);
        frame.setLayout(new GridLayout(6,3));

        BorderLayout border = new BorderLayout();
        Container con = frame.getContentPane();


        frame.pack();
        frame.setVisible(true);
    }


}
