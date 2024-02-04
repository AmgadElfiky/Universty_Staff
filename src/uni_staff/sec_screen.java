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
import javax.swing.JTextField;

public class sec_screen extends JFrame implements ActionListener {

    Font f = new Font("arial",Font.BOLD,15);
    signup_image ii = new signup_image();
    JLabel user, pass, depart, note;
    JTextField user_name, password, department;
    JButton SignUp, Back;

    //constractor
    public sec_screen() { //signup screen
        Show_Second_Screen();
    }

    public void Show_Second_Screen() {
        //Labels
        user = new JLabel("User name");
        pass = new JLabel("Password");
        depart = new JLabel("Department");
        note = new JLabel("Enter IS , CS , IT ONLY ");
        user.setBounds(270, 150, 80, 25);
        pass.setBounds(270, 200, 80, 25);
        depart.setBounds(270, 250, 130, 25);
        note.setBounds(610, 250, 250, 25);
        note.setForeground(Color.PINK);
        user.setFont(f);pass.setFont(f);depart.setFont(f);note.setFont(new Font("arial",Font.BOLD,20));
        ii.add(note);
        ii.add(pass);
        ii.add(user);
        ii.add(depart);

        //TextField
        user_name = new JTextField();
        password = new JTextField();
        department = new JTextField();
        user_name.setBounds(400, 150, 200, 25);
        password.setBounds(400, 200, 200, 25);
        department.setBounds(400, 250, 200, 25);
        ii.add(user_name);
        ii.add(password);
        ii.add(department);

        //Buttons
        SignUp = new JButton("SignUp");
        Back = new JButton("Back");
        SignUp.setBackground(Color.red);
        SignUp.setForeground(Color.yellow);
        Back.setBackground(Color.red);
        SignUp.setBounds(400, 330, 100, 30);
        Back.setBounds(800, 400, 100, 30);
        ii.add(SignUp);
        ii.add(Back);

        //action
        Back.addActionListener(this);
        SignUp.addActionListener(this);

        //panel
        setTitle("Sign_Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(919, 490);
        setLocation(500, 170);
        setVisible(true);
        add(ii);
    }

    public void signup() throws SQLException {
        
        //forusername
        if (user_name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User name mst" + " be filled" + JOptionPane.WARNING_MESSAGE);
        }

        //for password
        boolean pas = false;
        String t1 = password.getText();
        if (t1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "User name mst" + " be filled" + JOptionPane.WARNING_MESSAGE);
        }
        int l1 = 0, l2 = 0, l3 = 0, l4 = 0;
        if (t1.length() >= 8) {
            l1 = 1;
        }
        for (int i = 0; i < t1.length(); i++) {
            if (t1.charAt(i) >= 'a' && t1.charAt(i) <= 'z') {
                l2 = 1;
            } else if (t1.charAt(i) >= 'A' && t1.charAt(i) <= 'Z') {
                l3 = 1;
            } else {
                l4 = 1;
            }
        }
        if (l1 == 1 && l2 == 1 && l3 == 1 && l4 == 1) {
            pas = true;
        } else {
            JOptionPane.showMessageDialog(this, "The Password Must Be More Than 8 Charcters "
                    + "AND Contain (A~Z) &(a~z)&(1~9)"
                    + JOptionPane.WARNING_MESSAGE);
        }

        //for department check
        boolean dep = false;
        String t2 = department.getText();
        if (t2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "User name mst" + " be filled" + JOptionPane.WARNING_MESSAGE);
        }
        if (t2.equalsIgnoreCase("CS") || t2.equalsIgnoreCase("IT") || t2.equalsIgnoreCase("IS")) {
            dep = true;
        } else {
            JOptionPane.showMessageDialog(this, "Invalid " + "Department"
                    + JOptionPane.WARNING_MESSAGE);
        }
        
        //insert data after checks
        if (dep == true && pas == true) {
            database.user_database.Insert_user(user_name.getText(), password.getText(), department.getText()); //name of textfield
            JOptionPane.showMessageDialog(this, "Hello Dr. " + user_name.getText() + JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            first_screen f = new first_screen();
        }
//                else
//                {
//                    JOptionPane.showMessageDialog(this, "The Password Must Contain (A~Z) &(a~z)&(1~9)\n"
//                            + "OR\n"
//                            + "Invalid Department");
//                }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            this.dispose();
            first_screen f = new first_screen();
        } else if (e.getSource() == SignUp) {
            try {
                signup();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

}
