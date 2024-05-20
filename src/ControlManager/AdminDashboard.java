package ControlManager;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDashboard extends JFrame {
    JTable table;
    ResultSet rs;
    Conn c = new Conn();
    JLabel Total_Revenue;
    public AdminDashboard(){
        setBounds(0,0,1000, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.lightGray);


        JLabel Admin = new JLabel("Admin Management");
        Admin.setFont(new Font("Tahoma", Font.BOLD, 20));
        Admin.setBounds(400, 30, 500, 30);
        add(Admin);

        JButton ShowOccupiedRoom = new JButton("Occupied Room");
        ShowOccupiedRoom.setBounds(150,450,200,30);
        add(ShowOccupiedRoom);


        JButton ShowAvailableRoom = new JButton("Available Room");
        ShowAvailableRoom.setBounds(360,450,200,30);
        add(ShowAvailableRoom);


        JButton checkRevenue = new JButton("Revenue");
        checkRevenue.setBounds(570,450,200,30);
        add(checkRevenue);

        Total_Revenue = new JLabel();
        Total_Revenue.setFont(new Font("Tahoma", Font.BOLD, 20));
        Total_Revenue.setBounds(570,550,200,30);
        add(Total_Revenue);

        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150,120,700,300);
        add(sp);

        ShowOccupiedRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    rs = c.s.executeQuery("select u.First_Name, u.Last_Name, u.Phone, u.Ssn, r.Room_id, r.Type_name from user as u inner join booking as b on u.User_id = b.User_id inner join room as r on b.Room_id = r.Room_id where r.Status = 'occupied'");

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        });
        ShowAvailableRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    rs = c.s.executeQuery("select r.Room_id, r.Floor, rt.Type_name, rt.Description, rt.PricePerNight from room as r inner join roomtype as rt on r.Type_name = rt.Type_name where r.Status = 'empty' order by r.Room_id");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        });

        checkRevenue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Float> Revenue = new ArrayList<>();
                try {
                    rs = c.s.executeQuery("Select TotalPrice from booking");
                    while(rs.next()){
                        Revenue.add(rs.getFloat("TotalPrice"));
                    };
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Float totalRevenue = 0.00F;
                for(Float i: Revenue)
                    totalRevenue += i;
                String StrRevenue = totalRevenue.toString();
                System.out.println(StrRevenue);
                Total_Revenue.setText(StrRevenue);





            }
        });


    }

}

