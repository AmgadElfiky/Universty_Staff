package database;

import domain.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author El_Fiky ^_^
 */
public class Student_database {

     static String depp;
    public static Connection Connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:universal.db");
    }

    public static ArrayList<student> Get_student(String dep) {
        ArrayList<student> List = new ArrayList<>();
        try (
                Connection con = Connect();
                PreparedStatement p = con.prepareStatement("Select * from student where department = ?");) {
            p.setString(1, dep);
            depp = dep;
            ResultSet r = p.executeQuery();
            while (r.next()) {
                List.add(new student(r.getInt("id"), r.getString("fname"), r.getString("lname"), r.getString("adress"), r.getString("department"))); // names in database
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + JOptionPane.WARNING_MESSAGE);
        }
        return List;
    }
    public static void Update_student(int id, String Firstname, String Lastname, String Adress, String Department) throws SQLException {
        try (
                Connection con = Connect();
                PreparedStatement p = con.prepareStatement("update student set fname = ?, lname = ?, adress = ?, department = ? where id =?");) {
            p.setString(1, Firstname);
            p.setString(2, Lastname);
            p.setString(3, Adress);
            p.setString(4, Department);
            p.setInt(5, id);
            p.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void Insert_student(String Firstname, String Lastname, String Adress, String Department) throws SQLException {
        try (
                Connection con = Connect();
                PreparedStatement p = con.prepareStatement("insert into student (fname,lname,adress,department)values(?,?,?,?)");) {
            p.setString(1, Firstname);
            p.setString(2, Lastname);
            p.setString(3, Adress);
            p.setString(4, Department);
            p.execute();
            Get_student(depp);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + JOptionPane.WARNING_MESSAGE);
        }
        
    }

    public static ArrayList<student> Get_student_and_degree(String dep) {
        ArrayList<student> List = new ArrayList<>();
        try (
                Connection con = Connect();
                PreparedStatement p = con.prepareStatement("Select * from student,degree where degree.id = student.id AND student.department = ?");) {
            p.setString(1, dep);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                List.add(new student(r.getInt("id"), r.getString("fname"), r.getString("lname"), r.getString("sum")+"", r.getString("department"))); // names in database
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + JOptionPane.WARNING_MESSAGE);
        }
        return List;
    }
    
}
