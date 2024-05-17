package ControlManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ControlManager.Login.getGuest_id;

public class Booking extends JFrame {
    String room_id;
    JTextField first_name, last_name, DoB, address, Phone, Email, Ssn;
    JButton submit;
    String Guest_id = getGuest_id();
    public Booking(String room_id){
        this.room_id = room_id;
        setBounds(0,0,1000, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel booking = new JLabel("Information");
        booking.setFont(new Font("Tahoma", Font.BOLD, 20));
        booking.setBounds(400, 30, 200, 30);
        add(booking);

        JLabel firstname = new JLabel("First name");
        firstname.setFont(new Font("Arial", Font.BOLD, 15));
        firstname.setBounds(150,100,150,40);
        firstname.setBackground(Color.white);
        add(firstname);

        first_name = new JTextField();
        first_name.setBounds(250, 100, 150,40);
        first_name.setBackground(Color.white);
        add(first_name);

        JLabel lastname = new JLabel("Last name");
        lastname.setFont(new Font("Arial", Font.BOLD, 15));
        lastname.setBounds(150,150,150,40);
        lastname.setBackground(Color.white);
        add(lastname);

        last_name = new JTextField();
        last_name.setBounds(250, 150, 150,40);
        last_name.setBackground(Color.white);
        add(last_name);

        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Arial", Font.BOLD, 15));
        dob.setBounds(130,200,150,40);
        dob.setBackground(Color.white);
        add(dob);

        DoB = new JTextField();
        DoB.setBounds(250, 200, 150,40);
        DoB.setBackground(Color.white);
        add(DoB);

        JLabel add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.BOLD, 15));
        add.setBounds(150,250,150,40);
        add.setBackground(Color.white);
        add(add);

        address = new JTextField();
        address.setBounds(250, 250, 150,40);
        address.setBackground(Color.white);
        add(address);

        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("Arial", Font.BOLD, 15));
        phone.setBounds(150,300,150,40);
        phone.setBackground(Color.white);
        add(phone);

        Phone = new JTextField();
        Phone.setBounds(250, 300, 150,40);
        Phone.setBackground(Color.white);
        add(Phone);

        JLabel email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.BOLD, 15));
        email.setBounds(150,350,150,40);
        email.setBackground(Color.white);
        add(email);

        Email = new JTextField();
        Email.setBounds(250, 350, 150,40);
        Email.setBackground(Color.white);
        add(Email);

        JLabel ssn = new JLabel("SSN");
        ssn.setFont(new Font("Arial", Font.BOLD, 15));
        ssn.setBounds(150,400,150,40);
        ssn.setBackground(Color.white);
        add(ssn);

        Ssn = new JTextField();
        Ssn.setBounds(250, 400, 150,40);
        Ssn.setBackground(Color.white);
        add(Ssn);

        submit = new JButton("Submit");
        submit.setBounds(400,500,120,40);
        submit.setBackground(Color.WHITE);
        add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = first_name.getText();
                String lastname = last_name.getText();
                String birthday = DoB.getText();
                String addressS = address.getText();
                String phone_numb = Phone.getText();
                String mail = Email.getText();
                String ssn = Ssn.getText();
                Conn c = new Conn();
                String guest_id = "";
                try{
                    String check_old_guest = "select Guest_id, Ssn from user where Ssn = '"+ssn+"'";
                    ResultSet rs = c.s.executeQuery(check_old_guest);

                    if(rs.next()){
                        guest_id = rs.getString("Guest_id");
                    }
                    else{
                        try {
                            ResultSet guestid = c.s.executeQuery("Select max(Guest_id) as max_gid from guest");
                            guestid.next();
                            String newGuest_id = Integer.toString(guestid.getInt("max_gid") +1);
                            String updateGuest = "Insert into guest values('"+newGuest_id+"', '" +firstname+"', '"+ lastname+"', '"+birthday+"', '"+addressS+"', '"+phone_numb+"','"+mail+"', '"+ssn+"')";
                            c.s.executeUpdate(updateGuest);

                            String newGuest = "select Guest_id  from guest where Ssn = '"+ssn+"'";
                            ResultSet rs1 = c.s.executeQuery(newGuest);
                            rs1.next();
                            int g_id = rs1.getInt("Guest_id");
                            guest_id = Integer.toString(g_id);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                } catch(Exception exc){
                    exc.printStackTrace();
                }
                String query_booking_id = "Select max(Booking_id) as max_bid from booking";
                String booking_id;
                try {
                    ResultSet bookingid = c.s.executeQuery(query_booking_id);
                    bookingid.next();
                    booking_id = Integer.toString(bookingid.getInt("max_bid")+1);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String strDate = formatter.format(date);
                String update_booking = "Insert into booking(Booking_id, CheckinDate, Guest_id, Room_id) values('"+booking_id+"', '"+strDate+"','"+guest_id+"', '"+room_id+"')";
                String update_room = "update room set Status = 'occupied' where Room_id ='"+room_id+"'";
                try {
                    c.s.executeUpdate(update_booking);
                    c.s.executeUpdate(update_room);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Please meet receptionists to check in");
                new Login();
                dispose();
            }
        });



    }
}
