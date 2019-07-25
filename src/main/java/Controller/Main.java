package Controller;

import com.drawing.comm.Frame;
import monster.MonsterTestDrive;
import test2.TestBoats;
import cafe.Cafe;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        switch (JOptionPane.showInputDialog("1,Drawing 2.MonsterTest 3.TestBoats")){
            case "1" :
                break;

            case "2" :  new MonsterTestDrive();
                break;

            case "3" :  new TestBoats();
                break;

            case "4" :  new Cafe();
                break;
             default: break;
        }


    }
}
