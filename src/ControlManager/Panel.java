package ControlManager;
import Object.LoadSave;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {
    private BufferedImage lobby = LoadSave.getImg(LoadSave.lobby);

    public Panel(){
    setPanelSize();
    }
    public void setPanelSize(){
        Dimension size = new Dimension(1000, 700);
        setPreferredSize(size);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(lobby,0,0,1000,700, null);

    }

}
