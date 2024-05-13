package ControlManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import Object.LoadSave;


public class Login extends JFrame implements ActionListener {
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        // Load the New Romance font
//        Font newRomanceFont = new Font("New Romance", Font.PLAIN, 20); // Adjust size as needed


        JLabel page = new JLabel("<html><b><font size='5'>Login Page</font></b></html>");
//        page.setFont(newRomanceFont); // Set the font
        page.setBounds(130,20,150,50);
        add(page);

        JLabel user = new JLabel("Username");
        user.setBounds(40,80,100,30);
        add(user);

        JTextField username = new JTextField();
        username.setBounds(150,80,150,30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,120,100,30);
        add(pass);

        JTextField password = new JTextField();
        password.setBounds(150,120,150,30);
        add(password);

        JButton login = new JButton("Login");
        login.setBounds(40,190,120,30);
        login.setBackground(Color.BLACK);
        add(login);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(180,190,120,30);
        cancel.setBackground(Color.BLACK);
        add(cancel);

        // Add ActionListener to the Cancel button
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the program
                System.exit(0);
            }
        });

        ImageIcon login_page = new ImageIcon(ClassLoader.getSystemResource("5451_ho_00_p_2048x1536.jpg"));
        Image i2 = login_page.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370,10,290,290);
        add(image);


        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,200,100,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN,50));
        add(text);

        setBounds(340,180,680,370);
        setVisible(true);

    }
    public static void main (String[] args)
    {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}
