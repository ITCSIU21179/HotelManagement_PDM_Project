package ControlManager;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private JFrame jframe;
    public Frame(Panel jpanel){
        jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBackground(Color.white);
        jframe.add(jpanel);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setVisible(true);
    }


}
