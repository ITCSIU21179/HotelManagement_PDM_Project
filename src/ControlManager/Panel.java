package ControlManager;
import Object.LoadSave;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;


public class Panel extends JPanel  {
    private BufferedImage lobby = LoadSave.getImg(LoadSave.lobby);
    private BufferedImage room01 = LoadSave.getImg(LoadSave.room01);

    public Panel() {
        setPanelSize();
    }

    public void setPanelSize() {
        Dimension size = new Dimension(1000, 700);
        setPreferredSize(size);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(lobby.getSubimage(130,0,1848,1536),0,0,1000,700, null);


    }

}
//public class Home extends JFrame implements ActionListener {
//
//    private Panel panel;
//
//    Home() {
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(new BorderLayout());
//
//        BufferedImage lobby = LoadSave.getImg(LoadSave.lobby);
//        panel = new Panel(lobby);
//        add(panel, BorderLayout.CENTER);
//
//        // Create a panel to hold the login button
//        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        buttonPanel.setOpaque(false); // Make the panel transparent
//        JButton loginButton = new JButton("Log in");
//        loginButton.addActionListener(this);
//        buttonPanel.add(loginButton);
//
//        // Add the button panel to the south of the frame
//        add(buttonPanel, BorderLayout.SOUTH);
//
//        setBounds(500, 200, 600, 300);
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        setVisible(false);
//        new Login();
//    }
//
//    public static void main(String[] args) {
//        new Home();
//    }
// }
