package uni_staff;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author El_Fiky ^_^
 */
public class addimage extends JPanel{
    
     private ImageIcon add_image;
    
    public addimage() {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        add_image = new ImageIcon(getClass().getResource("..\\img\\add.png"));
        add_image.paintIcon(this, g, 0, 0);
    }
}
