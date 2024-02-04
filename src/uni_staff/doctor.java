package uni_staff;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class doctor extends JFrame{
    
    addimage ii = new addimage();
    static String  Depart;
    JTabbedPane Tab1;
    add a1;
    degree d1;
    print_degree p1;
    update_student u1;
    update_degree u2;
    public doctor(String s)
    {
        Depart = s;
        Show_doctor_screen();
    }
    public void Show_doctor_screen()
    {
        a1 = new add();
        d1 = new degree(Depart);
        p1 = new print_degree(Depart);
        u1 = new update_student();
        u2 = new update_degree();
        setTitle("Doctor Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 400);
        setLocation(600,250);
        setVisible(true);
        
        Tab1 = new JTabbedPane();
        Tab1.addTab("Student", a1);
        Tab1.addTab("Degree", d1);
        Tab1.addTab("Print",p1);
        Tab1.addTab("Update Student",u1);
        Tab1.add("Update Degree",u2);
        add(Tab1);
    }
}
