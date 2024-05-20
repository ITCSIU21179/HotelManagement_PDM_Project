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

        JLabel roomID = new JLabel(room_id);
        roomID.setFont(new Font("Arial", Font.BOLD, 20));
        roomID.setBounds(150,400,150,40);
        roomID.setBackground(Color.WHITE);
        add(roomID);

        submit = new JButton("Confirm");
        submit.setBounds(400,500,120,40);
        submit.setBackground(Color.WHITE);
        add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Conn c = new Conn();

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
                String update_booking = "Insert into booking(Booking_id, CheckinDate, User_id, Room_id) values('"+booking_id+"', '"+strDate+"','"+Guest_id+"', '"+room_id+"')";
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
