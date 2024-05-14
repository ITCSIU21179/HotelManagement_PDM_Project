package ControlManager;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {
    public AdminDashboard(){
        setBounds(0,0,1550, 1000);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chambre-triple-pre-mium.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("<html><b>WELCOME TO THE GREATEST HOTEL EVER</b></html>");
        text.setBounds(280, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 45));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar menu = new JMenuBar();
        menu.setBounds(0, 0, 1550, 30);
        image.add(menu);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        menu.add(hotel);

        JMenuItem reception = new JMenu("RECEPTION");
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        menu.add(admin);


        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        admin.add(addrooms);



    }

}

