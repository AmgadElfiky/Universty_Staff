package uni_staff;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author El_Fiky ^_^
 */
public class print_degree extends JPanel implements ActionListener{

    static String Depart;
    JTable Table;
    JScrollPane Sc;
    String Data[][];
    String Header[] = {"ID", "First Name", "Last Name","Degree"};
    JButton Print;
    ArrayList<domain.student> List;
    int Get_id = 0;
    
    //constractor
    public print_degree(String dep)
    {
        Depart = dep;
        this.setLayout(null);
        Show_table();
    }
    public void Show_table() {
        
        Font f = new Font("arial",Font.BOLD,15);
        List = database.Student_database.Get_student_and_degree(Depart);
        /*Desgin of Add Degrees Right Side*/
        //Button
        Print = new JButton("Print");
        Print.setBounds(0, 300, 600, 40);
        Print.setFont(f);
        add(Print);
        Print.setBackground(Color.BLACK);
        Print.setForeground(Color.red);
        Print.addActionListener(this);

        //Table design
        Data = new String[List.size()][4];
        for (int i = 0; i < Data.length; i++) {
            Data[i][0] = "" + List.get(i).getID();
            Data[i][1] = List.get(i).getFname();
            Data[i][2] = List.get(i).getLname();
            Data[i][3] = List.get(i).getAddress();
        }
        Table = new JTable(Data, Header);
        Table.setBackground(Color.PINK);
        Sc = new JScrollPane(Table);
        Sc.setBounds(0, 0, 600, 300);
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
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MessageFormat h = new MessageFormat("Student Degree");
        MessageFormat f = new MessageFormat("Page 1");
        try{
            Table.print(JTable.PrintMode.NORMAL,h,f);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        }
}
