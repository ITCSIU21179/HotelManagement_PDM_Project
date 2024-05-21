package ControlManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddNewGuest extends JFrame {
    Conn c = new Conn();
    public AddNewGuest(){
        setBounds(0,0,1000, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.lightGray);

        JLabel First_Name = new JLabel("First name:");
        First_Name.setFont(new Font("Arial", Font.BOLD, 20));
        First_Name.setBounds(50, 10, 110, 30);
        First_Name.setBackground(Color.white);
        add(First_Name);

        JLabel Last_Name = new JLabel("Last name:");
        Last_Name.setFont(new Font("Arial", Font.BOLD, 20));
        Last_Name.setBounds(52, 50, 110, 30);
        Last_Name.setBackground(Color.white);
        add(Last_Name);

        JLabel Dob = new JLabel("Date Of Birth:");
        Dob.setFont(new Font("Arial", Font.BOLD, 20));
        Dob.setBounds(27, 90, 150, 30);
        Dob.setBackground(Color.white);
        add(Dob);

        JLabel Address = new JLabel("Address:");
        Address.setFont(new Font("Arial", Font.BOLD, 20));
        Address.setBounds(69, 130, 90, 30);
        Address.setBackground(Color.white);
        add(Address);

        JLabel Phone = new JLabel("Phone:");
        Phone.setFont(new Font("Arial", Font.BOLD, 20));
        Phone.setBounds(88, 170, 70, 30);
        Phone.setBackground(Color.white);
        add(Phone);

        JLabel Email = new JLabel("Email:");
        Email.setFont(new Font("Arial", Font.BOLD, 20));
        Email.setBounds(95, 210, 70, 30);
        Email.setBackground(Color.white);
        add(Email);

        JLabel Ssn = new JLabel("SSN:");
        Ssn.setFont(new Font("Arial", Font.BOLD, 20));
        Ssn.setBounds(105, 250, 50, 30);
        Ssn.setBackground(Color.white);
        add(Ssn);

        JTextField firstnametext = new JTextField();
        firstnametext.setBounds(170, 10, 200, 30);
        firstnametext.setToolTipText("First name");
        add(firstnametext);

        JTextField lastnametext = new JTextField();
        lastnametext.setBounds(170, 50, 200, 30);
        lastnametext.setToolTipText("Last name");
        add(lastnametext);

        JTextField dobtext = new JTextField();
        dobtext.setBounds(170, 90, 200, 30);
        dobtext.setToolTipText("format: yyyy-mm-dd");
        add(dobtext);

        JTextField addresstext = new JTextField();
        addresstext.setBounds(170, 130, 200, 30);
        addresstext.setToolTipText("address");
        add(addresstext);

        JTextField phonetext = new JTextField();
        phonetext.setBounds(170, 170, 200, 30);
        phonetext.setToolTipText("5 digits only");
        add(phonetext);

        JTextField emailtext = new JTextField();
        emailtext.setBounds(170, 210, 200, 30);
        emailtext.setToolTipText("email");
        add(emailtext);

        JTextField ssntext = new JTextField();
        ssntext.setBounds(170, 250, 200, 30);
        ssntext.setToolTipText("5 digits only");
        add(ssntext);

        JLabel Username = new JLabel("Username:");
        Username.setFont(new Font("Arial", Font.BOLD, 20));
        Username.setBounds(50, 350, 110, 30);
        Username.setBackground(Color.white);
        add(Username);

        JTextField usernametext = new JTextField();
        usernametext.setBounds(170, 350, 200, 30);
        usernametext.setToolTipText("username");
        add(usernametext);

        JLabel Password = new JLabel("Password:");
        Password.setFont(new Font("Arial", Font.BOLD, 20));
        Password.setBounds(50, 390, 110, 30);
        Password.setBackground(Color.white);
        add(Password);

        JTextField passwordtext = new JTextField();
        passwordtext.setBounds(170, 390, 200, 30);
        passwordtext.setToolTipText("password");
        add(passwordtext);

        JButton Confirm = new JButton("Confirm");
        Confirm.setFont(new Font("Arial", Font.BOLD, 20));
        Confirm.setBounds(350, 550, 250, 30);
        Confirm.setBackground(Color.white);
        add(Confirm);


        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = firstnametext.getText();
                String lastname = lastnametext.getText();
                String dob = dobtext.getText();
                String address = addresstext.getText();
                String phone = phonetext.getText();
                String email = emailtext.getText();
                String ssn = ssntext.getText();
                String username = usernametext.getText();
                String password = passwordtext.getText();
                ResultSet rs;
                try {
                    rs = c.s.executeQuery("Select max(User_id) as max_id from user");
                    rs.next();
                    Integer max_id = rs.getInt("max_id")+1;
                    c.s.executeUpdate("insert into user values ('" +max_id+ "','" +firstname+ "','" +lastname+ "','" +dob+ "','" +address+ "','" +phone+ "','" +email+ "','" +ssn+ "')");
                    c.s.executeUpdate("insert into account values ('" +max_id+ "','" +username+ "','" +password+ "','" +max_id+ "', 'Guest')");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JOptionPane.showMessageDialog(null, "Finish sign up!!!");
        new Login();
        dispose();
    }
}
