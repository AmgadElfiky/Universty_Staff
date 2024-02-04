package uni_staff;

//import database.user_database; // we dont use it because we call it - look down at 72
import database.user_database;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class first_screen extends JFrame implements ActionListener {

    Font f = new Font("arial",Font.BOLD,15);
    image ii = new image();
    JLabel User, Pass;
    JTextField User_name;
    JPasswordField Password;
    JButton SignIn, SignUp;

    //constractor
    public first_screen() {
        Show_Design();
    }

    public void Show_Design() {

        //Labels
        User = new JLabel("User Name");
        Pass = new JLabel("Password");
        User.setBounds(0, 80, 80, 25);
        Pass.setBounds(600, 250, 80, 25);
        User.setFont(f);
        Pass.setFont(f);

        //TextField
        User_name = new JTextField();
        Password = new JPasswordField();
        User_name.setBounds(100, 80, 200, 25);
        Password.setBounds(700, 250, 200, 25);

        //Buttons
        SignIn = new JButton("SignIn");
        SignUp = new JButton("SignUp");
        SignIn.setBounds(350, 300, 100, 30);
        SignUp.setBounds(480, 300, 100, 30);
        SignIn.setBackground(Color.LIGHT_GRAY);
        SignUp.setBackground(Color.LIGHT_GRAY);
        SignIn.setForeground(Color.BLUE);
        SignUp.setForeground(Color.BLUE);
        User.setForeground(Color.DARK_GRAY);
        SignIn.setFont(f);
        SignUp.setFont(f);

        //action
        SignIn.addActionListener(this);
        SignUp.addActionListener(this);

        //put into image
        ii.add(User_name);
        ii.add(Password);
        ii.add(User);
        ii.add(Pass);
        ii.add(SignIn);
        ii.add(SignUp);

        //panel
        setTitle("Universal_Staff");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(930, 390);
        setLocation(500, 170);
        setVisible(true);
        add(ii);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SignIn) {
            int Case = database.user_database/*We dont use () because the method is static*/.Check_user(User_name.getText(), Password.getText());
            if (Case == 1) {
                JOptionPane.showMessageDialog(this, "Hello Dr. " + User_name.getText());
                this.dispose();
                try {
                    doctor dddd = new doctor(user_database.Get_department(User_name.getText()));
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (Case == 2) {
                JOptionPane.showMessageDialog(this, "Wrong Password");
            }
            if (Case == 0) {
                JOptionPane.showMessageDialog(this, "User is not found");
            }
        } else if (e.getSource() == SignUp) {
            this.dispose();
            sec_screen s = new sec_screen();
        }
    }

}
