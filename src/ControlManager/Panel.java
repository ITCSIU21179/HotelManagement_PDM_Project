package ControlManager;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public Panel(){
    setPanelSize();
    }
    public void setPanelSize(){
        Dimension size = new Dimension(1000, 700);
        setPreferredSize(size);
    }

}
