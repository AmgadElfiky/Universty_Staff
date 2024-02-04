/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
public class add extends JPanel  implements ActionListener{
    
    Font f = new Font("arial",Font.BOLD,15);
    addimage ii = new addimage();
    JLabel Fname,Lname,Address,Department;
    JTextField Firstname,Lastname,Addres,Depart;
    JButton Send;
    //JFrame f = new JFrame();
    
    public add()
    {
        this.setLayout(null);
        //Labels
        Fname = new JLabel("First Name");
        Lname = new JLabel("Last Name");
        Address = new JLabel("Address");
        Department = new JLabel("Deaprtment");
        Fname.setBounds(50, 50, 80, 25);
        Lname.setBounds(50, 80, 80, 25);
        Address.setBounds(50, 110, 80, 25);
        Department.setBounds(50, 140, 110, 25);
        Fname.setFont(f);Lname.setFont(f);Department.setFont(f);Address.setFont(f);
        add(Fname);add(Lname);add(Address);add(Department);
        
        //Textfields
        Firstname = new JTextField();
        Lastname = new JTextField();
        Addres = new JTextField();
        Depart = new JTextField();
        Firstname.setBounds(180, 50, 200, 25);
        Lastname.setBounds(180, 80, 200, 25);
        Addres.setBounds(180, 110, 200, 25);
        Depart.setBounds(180, 140, 200, 25);
        add(Firstname);add(Lastname);add(Addres);add(Depart);
        
        //Buttons
        Send = new JButton("SEND");
        Send.setBounds(200, 200, 100, 30);
        Send.setFont(f);
        Send.setBackground(Color.black);
        Send.setForeground(Color.red);
        add(Send);
        Send.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Send)
        {
            try{
                database.Student_database.Insert_student(Firstname.getText(), Lastname.getText(), Addres.getText(),Depart.getText());
                JOptionPane.showMessageDialog(this, "DONE\n"
                        + "Data you Sent Is : - "
                        + "\nFirts Name   : " + Firstname.getText()
                        + "\nLast Name    : " + Lastname.getText()
                        + "\nAddress        : " + Addres.getText()
                        + "\nDepartment : " + Depart.getText());
                Firstname.setText("");
                Lastname.setText("");
                Addres.setText("");
                Depart.setText("");
                //database.Student_database.Get_student(depp);
            }catch(SQLException ex)
            {
                System.out.println( ex.getMessage());
            }
        }
    }
    
}
