package uni_staff;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author El_Fiky ^_^
 */
public class update_student extends JPanel implements ActionListener{
    
    Font f = new Font("arial",Font.BOLD,15);
    JLabel Fname,Lname,Address,Department,id;
    JTextField Firstname,Lastname,Addres,Depart,Id;
    JButton Send;
    
    public update_student()
    {
        this.setLayout(null);
        
        //Labels
        id = new JLabel("ID");
        Fname = new JLabel("First Name");
        Lname = new JLabel("Last Name");
        Address = new JLabel("Address");
        Department = new JLabel("Deaprtment");
        id.setBounds(50, 20, 80, 25);
        Fname.setBounds(50, 50, 80, 25);
        Lname.setBounds(50, 80, 80, 25);
        Address.setBounds(50, 110, 80, 25);
        Department.setBounds(50, 140, 80, 25);
        id.setFont(f);Fname.setFont(f);Lname.setFont(f);Address.setFont(f);Department.setFont(f);
        add(id);add(Fname);add(Lname);add(Address);add(Department);
        
        //Textfields
        Id = new JTextField();
        Firstname = new JTextField();
        Lastname = new JTextField();
        Addres = new JTextField();
        Depart = new JTextField();
        Id.setBounds(150, 20, 200, 25);
        Firstname.setBounds(150, 50, 200, 25);
        Lastname.setBounds(150, 80, 200, 25);
        Addres.setBounds(150, 110, 200, 25);
        Depart.setBounds(150, 140, 200, 25);
        add(Id);add(Firstname);add(Lastname);add(Addres);add(Depart);
        
        //Buttons
        Send = new JButton("UPDATE");
        Send.setBounds(200, 200, 100, 30);
        Send.setBackground(Color.black);
        Send.setForeground(Color.red);
        Send.setFont(f);
        add(Send);
        Send.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            database.Student_database.Update_student(Integer.parseInt(Id.getText()), Firstname.getText(), Lastname.getText(), Addres.getText(), Depart.getText());
            JOptionPane.showMessageDialog(this, "Updated"
                    + "\nThe Data You Inserted Is : - "
                    + "\nId              : " + Integer.parseInt(Id.getText())
                    + "\nFirst Name   : " + Firstname.getText()
                    + "\nLast Name    : " + Lastname.getText()
                    + "\nAddress        : " + Addres.getText()
                    + "\nDepartment : " + Depart.getText());
            Id.setText("");
            Firstname.setText("");
            Lastname.setText("");
            Addres.setText("");
            Depart.setText("");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
