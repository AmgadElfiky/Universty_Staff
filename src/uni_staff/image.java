/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_staff;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class image extends JPanel {

    private ImageIcon update_image;
    private ImageIcon signin_image;
    private ImageIcon signup_image;
    
    public image() {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        signin_image = new ImageIcon(getClass().getResource("..\\img\\signin.png"));
        signin_image.paintIcon(this, g, 0, 0);
    }

}
