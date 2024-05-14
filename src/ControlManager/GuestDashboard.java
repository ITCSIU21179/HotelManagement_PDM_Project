package ControlManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

        JLabel room_id = new JLabel("Room ID");
        room_id.setFont(new Font("Arial", Font.BOLD, 15));
        room_id.setBounds(150,90,150,40);
        add(room_id);

        JLabel room_type = new JLabel("Room Type");
        room_type.setFont(new Font("Arial", Font.BOLD, 15));
        room_type.setBounds(290,90,150,40);
        add(room_type);

        JLabel description = new JLabel("Description");
        description.setFont(new Font("Arial", Font.BOLD, 15));
        description.setBounds(430,90,150,40);
        add(description);

        JLabel pricepernight = new JLabel("Price per night");
        pricepernight.setFont(new Font("Arial", Font.BOLD, 15));
        pricepernight.setBounds(570,90,150,40);
        add(pricepernight);

        JLabel capacity = new JLabel("Capacity");
        capacity.setFont(new Font("Arial", Font.BOLD, 15));
        capacity.setBounds(710,90,150,40);
        add(capacity);

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

        table = new JTable();
        table.setBounds(150,120,700,300);
        add(table);
        Conn c = new Conn();
        try{

            ResultSet rs = c.s.executeQuery("select Room_id, room.Type_name, Description, PricePerNight, Capacity from room inner join roomtype on room.Type_name = roomtype.Type_name where Status = 'empty' order by Room_id ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
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
    public static void main (String[] args)
    {
        new GuestDashboard();
    }

}
