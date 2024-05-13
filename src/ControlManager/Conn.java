package ControlManager;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "123456789");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
