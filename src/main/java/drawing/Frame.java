package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Vector;
import java.util.Stack;

/**
 *  Copyright (C) 2019, Ryan.Bae
 */


public class Frame extends JFrame{

        String title = "R_SketchBook_ver_1";
        String modeText = " Copyright (C) 2019, Ryan.Bae All Rights Reserved";
        int option = 0;

        Canvas canvas = new Canvas();
        JMenuBar menubar = new JMenuBar();
        JToolBar toolbar = new JToolBar();
        JPanel endBarPanel =  new JPanel();
        JLabel mode ;


        public Frame(){

            Dimension dim = new Dimension(1024,800);

            setLocation(400, 200 );
            setTitle(title);
            setSize(dim);
            setLayout(null);
            setVisible(true);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            add(canvas);
            add(toolbar);
            add(endBarPanel);
            setJMenuBar(menubar);
            toolbar.setLocation(0,0);
            endBarPanel.setSize(new Dimension(1024,30));
            endBarPanel.setBackground(Color.gray);
            endBarPanel.setLocation(0,720);
            endBarPanel.setLayout(new BoxLayout(endBarPanel, BoxLayout.X_AXIS));
            canvas.setSize(900,720);
            canvas.setBackground(Color.white);
            canvas.setLocation(100,0);

            mode = new JLabel(modeText);
            endBarPanel.add(mode);

            toolbar.setBackground(Color.gray);
            toolbar.setSize(new Dimension(100,720));
            toolbar.setLayout(new FlowLayout());

            JButton[] buttons = new JButton[6];
            buttons[0] = new JButton("line");
            buttons[1] = new JButton("Polygon");
            buttons[2] = new JButton("Rectangle");
            buttons[3] = new JButton("Circle");
            buttons[4] = new JButton("undo");
            buttons[5] = new JButton("redo");

            for(int i = 0; i<buttons.length; i++){
                toolbar.add(buttons[i]);
                buttons[i].setPreferredSize(new Dimension(60,40));
                buttons[i].addActionListener(new ButtonAction());

            }
            toolbar.addSeparator();
        }

        class ButtonAction implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton myButton = (JButton) e.getSource();
                String temp = myButton.getText();

                if(temp.equals("line")){
                    option = 1;
                }else if(temp.equals("Polygon")){
                    option = 2;
                }else if(temp.equals("Rectangle")){
                    option = 3;
                }else if(temp.equals("Circle")){
                    option = 4;
                }else if(temp.equals("undo")){
                    option = 5;
                }else if(temp.equals("redo")){
                    option = 6;
                }

                canvas.draw(option);

            }
        }


}

