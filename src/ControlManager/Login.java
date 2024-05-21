package ControlManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    JTextField username, password;
    JButton login, cancel, newguest;
    static String Guest_id;

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


        login = new JButton("Login");
        login.setBounds(40,190,120,30);
        login.setBackground(Color.WHITE);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,190,120,30);
        cancel.setBackground(Color.WHITE);
        add(cancel);

        newguest = new JButton("Sign up");
        newguest.setBounds(110,240,120,30);
        newguest.setBackground(Color.WHITE);
        add(newguest);

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
                String checkAccount = "Select * from account where Username='"+user+"' and Password='"+pass+"'";
                Conn c = new Conn();
                try {
                    ResultSet rs = c.s.executeQuery(checkAccount);
                    if (rs.next()) {
                        if(rs.getString("User_type").equals("Guest")) {
                            Guest_id = rs.getString("User_id");
                            HotelManagementSystem.executeHotel("Guest");
                        }
                        else HotelManagementSystem.executeHotel("Admin");

                        setVisible(false);
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        newguest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddNewGuest();
                dispose();
            }
        });
        ImageIcon login_page = new ImageIcon(ClassLoader.getSystemResource("5451_ho_00_p_2048x1536.jpg"));
        Image i2 = login_page.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370,10,290,290);
        add(image);
        setBounds(340,180,680,370);
        setVisible(true);
    }
    public static String getGuest_id(){
        return Guest_id;
    }
}
