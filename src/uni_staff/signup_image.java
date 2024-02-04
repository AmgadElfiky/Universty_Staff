/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author El_Fiky ^_^
 */
public class signup_image extends JPanel{
    
    private ImageIcon signup_image;
    
    public signup_image() {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        signup_image = new ImageIcon(getClass().getResource("..\\img\\3.jpg"));
        signup_image.paintIcon(this, g, 0, 0);
    }
}
