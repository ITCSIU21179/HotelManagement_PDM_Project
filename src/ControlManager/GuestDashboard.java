package ControlManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

import net.proteanit.sql.*;

public class GuestDashboard extends JFrame {
    JTable table;
    public GuestDashboard()  {
        setBounds(0,0,1000, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room where Status = 'empty'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e){
            e.printStackTrace();
        }


    }
    public static void main (String[] args)
    {
        new GuestDashboard();
    }

}
