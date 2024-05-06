package ControlManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener {
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);

        JTextField username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        JTextField password = new JTextField();
        password.setBounds(150,70,150,30);
        add(password);

        JButton login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        add(login);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
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
        Image i2 = login_page.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330,10,260,260);
        add(image);

        setBounds(350,180,700,650);
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
