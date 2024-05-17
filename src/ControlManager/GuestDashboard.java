package ControlManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import net.proteanit.sql.*;

public class GuestDashboard extends JFrame {
    JTable table;
    JTextField submit_room;
    JButton submit;

    public GuestDashboard()  {
        setBounds(0,0,1000, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel search = new JLabel("Available room");
        search.setFont(new Font("Tahoma", Font.BOLD, 20));
        search.setBounds(400, 30, 200, 30);
        add(search);

        JLabel chooseroom = new JLabel("Choose Room");
        chooseroom.setFont(new Font("Arial", Font.BOLD, 15));
        chooseroom.setBounds(150,500,150,40);
        add(chooseroom);

        submit_room = new JTextField();
        submit_room.setBounds(270, 500, 250,40);
        add(submit_room);

        submit = new JButton("Submit");
        submit.setBounds(530,500,120,40);
        submit.setBackground(Color.WHITE);
        add(submit);
//        String[] header = {"Available room", "Room ID", "Room Type", "Description","Price per night", "Capacity", "Choose Room"};
        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150,120,700,300);
        Conn c = new Conn();
        try{

            ResultSet rs = c.s.executeQuery("select Room_id, room.Type_name, Description, PricePerNight, Capacity from room inner join roomtype on room.Type_name = roomtype.Type_name where Status = 'empty' order by Room_id ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            add(sp);
        } catch(Exception e){
            e.printStackTrace();
        }

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String room_id = submit_room.getText();
                new Booking(room_id);
                dispose();
            }
        });
    }

}
