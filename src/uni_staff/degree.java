/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author El_Fiky ^_^
 */
public class degree extends JPanel implements ActionListener {

    Font f = new Font("arial",Font.BOLD,15);
    static String Depart;
    JTable Table;
    JScrollPane Sc;
    String Data[][];
    String Header[] = {"ID", "First Name", "Last Name"};
    ArrayList<domain.student> List;
    JLabel M1, M2, M3, M4, M5, M6,DEP;
    JTextField T1, T2, T3, T4, T5, T6;
    JButton AddDegree;
    int Get_id = 0;

    public degree(String s) {
        Depart = s;
        setLayout(null);
        setBackground(Color.yellow);
        Show_table();
    }

    public void Show_table() {
        List = database.Student_database.Get_student(Depart);
        /*Desgin of Add Degrees Right Side*/
        //Labels
        DEP = new JLabel("You are in " + Depart + " Department");
        M1 = new JLabel("OS");
        M2 = new JLabel("NC");
        M3 = new JLabel("IT");
        M4 = new JLabel("MATH");
        M5 = new JLabel("SA");
        M6 = new JLabel("AI");
        DEP.setBounds(350, 250,250, 25);
        M1.setBounds(350, 20, 50, 25);
        M2.setBounds(350, 50, 50, 25);
        M3.setBounds(350, 80, 50, 25);
        M4.setBounds(350, 110, 50, 25);
        M5.setBounds(350, 140, 50, 25);
        M6.setBounds(350, 170, 50, 25);
        DEP.setFont(f);
        M1.setFont(f);
        M2.setFont(f);
        M3.setFont(f);
        M4.setFont(f);
        M5.setFont(f);
        M6.setFont(f);
        add(DEP);
        add(M1);
        add(M2);
        add(M3);
        add(M4);
        add(M5);
        add(M6);

        //TextFields
        T1 = new JTextField();
        T2 = new JTextField();
        T3 = new JTextField();
        T4 = new JTextField();
        T5 = new JTextField();
        T6 = new JTextField();
        T1.setBounds(420, 20, 50, 25);
        T2.setBounds(420, 50, 50, 25);
        T3.setBounds(420, 80, 50, 25);
        T4.setBounds(420, 110, 50, 25);
        T5.setBounds(420, 140, 50, 25);
        T6.setBounds(420, 170, 50, 25);
        add(T1);
        add(T2);
        add(T3);
        add(T4);
        add(T5);
        add(T6);

        //Button
        AddDegree = new JButton("Add Degree");
        AddDegree.setBounds(370, 200, 150, 30);
        AddDegree.setFont(f);
        add(AddDegree);
        AddDegree.setBackground(Color.BLACK);
        AddDegree.setForeground(Color.red);
        AddDegree.addActionListener(this);

        //Table design
        Data = new String[List.size()][3];
        for (int i = 0; i < Data.length; i++) {
            Data[i][0] = "" + List.get(i).getID();
            Data[i][1] = List.get(i).getFname();
            Data[i][2] = List.get(i).getLname();
        }
        Table = new JTable(Data, Header);
        Table.setBackground(Color.gray);
        Table.setForeground(Color.GREEN);
        Sc = new JScrollPane(Table);
        Sc.setBounds(0, 0, 300, 400);
        add(Sc);

        //for center the words in table 
        ((DefaultTableCellRenderer) Table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v = new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        Table.getColumnModel().getColumn(0).setCellRenderer(v);
        for (int i = 0; i < Table.getColumnCount(); i++) {
            Table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
        Table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //on click on the table row
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OnMouseClicked(evt);
            }
        });
    }

    private void OnMouseClicked(java.awt.event.MouseEvent evt) {
        Get_id = Table.getSelectedRow();
        System.out.println("OK" + Table.getSelectedRow());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddDegree) {
            int iid = List.get(Get_id).getID();
            System.out.println(Get_id);
            try {
                database.degree_database.Insert_degree(iid, Integer.parseInt(T1.getText()), Integer.parseInt(T2.getText()), Integer.parseInt(T3.getText()), Integer.parseInt(T4.getText()), Integer.parseInt(T5.getText()), Integer.parseInt(T6.getText()));
                JOptionPane.showMessageDialog(this, "DONE!!!" );
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
