package ControlManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame {
    JTextField username, password;
    JButton login, cancel, guest;

    Login() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        JLabel user = new JLabel("Username");
        user.setBounds(40,80,100,30);
        add(user);

        username = new JTextField();
        username.setBounds(150,80,150,30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,120,100,30);
        add(pass);

        password = new JTextField();
        password.setBounds(150,120,150,30);
        add(password);

        guest = new JButton("Continue as guest");
        guest.setBounds(70,250,200,30);
        guest.setBackground(Color.WHITE);
        add(guest);

        login = new JButton("Login");
        login.setBounds(40,190,120,30);
        login.setBackground(Color.WHITE);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,190,120,30);
        cancel.setBackground(Color.WHITE);
        add(cancel);

        // Add ActionListener to the Cancel button
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the program
                System.exit(0);
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                String pass = password.getText();
                if (user.equals("JohnnySing123") && pass.equals("123456")) {
                    HotelManagementSystem.executeHotel();
                    setVisible(false);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    new Login();
                    dispose();
                }
            }
        });
        guest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuestDashboard();
                dispose();
            }
        });
        ImageIcon login_page = new ImageIcon(ClassLoader.getSystemResource("5451_ho_00_p_2048x1536.jpg"));
        Image i2 = login_page.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370,10,290,290);
        add(image);

        setBounds(350,180,700,650);
        setVisible(true);


        setBounds(340,180,680,370);
        setVisible(true);
    }
}
