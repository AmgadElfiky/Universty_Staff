package uni_staff;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author El_Fiky ^_^
 */
public class update_Image extends JPanel{
     private ImageIcon update_image;
    
    public update_Image() {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        update_image = new ImageIcon(getClass().getResource("..\\img\\update.jpg"));
        update_image.paintIcon(this, g, 0, 0);
    }
}
