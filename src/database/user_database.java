package database;

import domain.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class user_database {
//    public user_database()
//    {
//        
//    }

    public static Connection Connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:universal.db");
    }

    //insert
    public static void Insert_user(String User, String Pass, String Depart) throws SQLException {
        try (
                Connection con = Connect();
                PreparedStatement p = con.prepareStatement("insert  into user values (?,?,?)");) {
            p.setString(1, User);
            p.setString(2, Pass);
            p.setString(3, Depart);
            p.execute();
        } catch (SQLException ee) {
            JOptionPane.showMessageDialog(null, ee.getMessage() + JOptionPane.WARNING_MESSAGE);
        }
    }

    //getdata
    public static ArrayList<user> Get_users() {
        ArrayList<user> List = new ArrayList<>();
        try (
                Connection con = Connect();
                PreparedStatement p = con.prepareStatement("select * from user");) {
            ResultSet s = p.executeQuery();
            while (s.next()) {
                List.add(new user(s.getString("user_name"), s.getString("password"), s.getString("department")));
            }

        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
        return List;
    }

    //check
    public static int Check_user(String User, String Pass) {
        int Case = 0;
        ArrayList<user> arr = Get_users();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getUser_name().equals(User)) {
                if (arr.get(i).getPassword().equals(Pass)) {
                    Case = 1;
                    break;
                } else {
                    Case = 2;
                    break;
                }
            } else {
                Case = 0;
            }
        }
        return Case;
    }

    public static String Get_department(String user) throws SQLException {//to connect user with its department
        try (
                Connection con = Connect();//con is an object of connection class
                PreparedStatement p = con.prepareStatement("select department from user where user_name = ?");) {
            p.setString(1, user);
            ResultSet s = p.executeQuery();
            return s.getString("department");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
