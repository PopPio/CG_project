package poppio.cg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class SimpleButton extends JButton{
	final Color BTN_TEXT = Color.WHITE;

	public SimpleButton () {
		this(Color.GRAY ,Color.WHITE);
	}
	
	public SimpleButton (String name) {
		this(name, Color.GRAY ,Color.WHITE);
	}
	
	public SimpleButton (Color bg, Color text) {
		this.setFont(new Font("Arial", Font.BOLD, 12));
		this.setBorder(null);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setBackground(bg);
		this.setForeground(text);
	}
	
	public SimpleButton (String name, Color bg, Color text) {
		this.setFont(new Font("Arial", Font.BOLD, 12));
		this.setBorder(null);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setBackground(bg);
		this.setForeground(text);
		this.setText(name);
	}
}
