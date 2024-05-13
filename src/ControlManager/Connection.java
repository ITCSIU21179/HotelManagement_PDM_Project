package ControlManager;
import java.sql.*;

public class Connection {
    Connection c;
    Statement s;
    public Connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql:///hotel_management_system", "root", "123456789");
//            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
