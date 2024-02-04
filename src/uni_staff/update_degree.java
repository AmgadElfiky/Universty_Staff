package uni_staff;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author El_Fiky ^_^
 */
public class update_degree extends JPanel implements ActionListener{
    
    Font f = new Font("arial",Font.BOLD,15);
    JLabel M1, M2, M3, M4, M5, M6,DEP,Id;
    JTextField T1, T2, T3, T4, T5, T6,ID;
    JButton Upd,Search_Id;
    ArrayList<domain.degree> List;
    
    //constractor
    public update_degree()
    {
        this.setLayout(null);
        Show_Screen();
    }
    public void Show_Screen()
    {
        //Labels
        Id = new JLabel("Enter Student ID");
        M1 = new JLabel("OS");
        M2 = new JLabel("NC");
        M3 = new JLabel("IT");
        M4 = new JLabel("MATH");
        M5 = new JLabel("SA");
        M6 = new JLabel("AI");
        Id.setBounds(170, 20, 150, 25);
        M1.setBounds(60, 50, 50, 25);
        M2.setBounds(60, 80, 50, 25);
        M3.setBounds(60, 110, 50, 25);
        M4.setBounds(60, 140, 50, 25);
        M5.setBounds(60, 170, 50, 25);
        M6.setBounds(60, 200, 50, 25);
        Id.setFont(f);M1.setFont(f);M2.setFont(f);M3.setFont(f);M4.setFont(f);M5.setFont(f);M6.setFont(f);
        add(Id); add(M1); add(M2);add(M3); add(M4);add(M5);add(M6);

        //TextFields
        ID = new JTextField();
        T1 = new JTextField();
        T2 = new JTextField();
        T3 = new JTextField();
        T4 = new JTextField();
        T5 = new JTextField();
        T6 = new JTextField();
        ID.setBounds(300, 20, 50, 25);
        T1.setBounds(120, 50, 50, 25);
        T2.setBounds(120, 80, 50, 25);
        T3.setBounds(120, 110, 50, 25);
        T4.setBounds(120, 140, 50, 25);
        T5.setBounds(120, 170, 50, 25);
        T6.setBounds(120, 200, 50, 25);
        add(ID);
        add(T1);
        add(T2);
        add(T3);
        add(T4);
        add(T5);
        add(T6);

        //Button
        Upd = new JButton("Update Degree");
        Search_Id = new JButton("FIND");
        Upd.setBounds(150, 250, 150, 30);
        Search_Id.setBounds(370, 18, 70, 25);
        Upd.setBackground(Color.BLACK);
        Upd.setForeground(Color.red);
        Search_Id.setBackground(Color.BLACK);
        Search_Id.setForeground(Color.red);
        Upd.setFont(f);Search_Id.setFont(f);
        add(Upd);add(Search_Id);
        //action
        Upd.addActionListener(this);
        Search_Id.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Search_Id)
        {
            List = database.degree_database.Get_Degree(Integer.parseInt(ID.getText()));
            T1.setText("" + List.get(0).getM1());
            T2.setText("" + List.get(0).getM2());
            T3.setText("" + List.get(0).getM3());
            T4.setText("" + List.get(0).getM4());
            T5.setText("" + List.get(0).getM5());
            T6.setText("" + List.get(0).getM6());
        }
        else if(e.getSource() == Upd)
        {
            try {//here we want to check if the student had a degree or not,help?
                database.degree_database.Update_degree(Integer.parseInt(ID.getText()), Integer.parseInt(T1.getText()), Integer.parseInt(T2.getText()), Integer.parseInt(T3.getText()), Integer.parseInt(T4.getText()), Integer.parseInt(T5.getText()), Integer.parseInt(T6.getText()));
                JOptionPane.showMessageDialog(this, "DONE" + "!!!" );
                T1.setText("");
                T2.setText("");
                T3.setText("");
                T4.setText("");
                T5.setText("");
                T6.setText("");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
