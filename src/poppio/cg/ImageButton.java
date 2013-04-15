package poppio.cg;


import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton{
	
	public ImageButton (ImageIcon img) {
		super("");
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setIcon((img));
        //setOpaque(false);
        setFocusPainted(false);
	}
	
	
}
