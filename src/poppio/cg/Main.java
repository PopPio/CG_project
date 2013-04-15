package poppio.cg;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Main extends JFrame{
	JMenuBar menuBar;
	JMenu menu_file,menu_help;
	JMenuItem menuItem_exit,
				menuItem_about;
	
	public Main () throws IOException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(820, 640));
		initComponents();
		
		
	}
	
	private void initComponents() throws IOException {
		// setup OpenGL Version 2
    	GLProfile profile = GLProfile.get(GLProfile.GL2);
    	GLCapabilities capabilities = new GLCapabilities(profile);
 
    	// The canvas is the widget that's drawn in the JFrame
    	GLCanvas glcanvas = new GLCanvas(capabilities);
    	glcanvas.addGLEventListener(new openglRenderer());
    	glcanvas.setSize( 600, 600 ); // set size of canvas
		
 
        //UI
    	//MenuBar
        menuBar = new JMenuBar();
        //File
        menu_file = new JMenu("File");
        menuBar.add(menu_file);
        
        menuItem_exit = new JMenuItem("Exit");
        menuItem_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	menuItemsPerformed(e);
            }
        });   
        menu_file.add(menuItem_exit);
        
        //Help
        menu_help = new JMenu("Help");
        menuBar.add(menu_help);
        
        menuItem_about = new JMenuItem("About RLS");
        menuItem_about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	menuItemsPerformed(e);
            }
        });     
        menu_help.add(menuItem_about);
        
        this.setJMenuBar(menuBar);
        
        
      
        // set icon
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        
        java.net.URL icon_URL = Main.class.getResource("img/logo.png");
     	BufferedImage frame_icon = ImageIO.read(icon_URL);
     	setIconImage(frame_icon);
     	setTitle("Room Lighting Simulation");
        setSize( this.getContentPane().getPreferredSize() );
        setVisible( true );
	}
	
	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new Main().setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

	}

	
	public void menuItemsPerformed(ActionEvent evt) {
		JMenuItem pressedItem = (JMenuItem) evt.getSource();
		if(pressedItem.getText().equalsIgnoreCase("About RLS")){
			 java.net.URL icon_URL = Main.class.getResource("img/logo.png");
		     	BufferedImage frame_icon = null;
				try {
					frame_icon = ImageIO.read(icon_URL);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     	ImageIcon icon = new ImageIcon(frame_icon);
			JOptionPane.showMessageDialog(this,
				    "Room lighting Simulation\nGraphics Computing 2143424\nChulalongkorn University\n\n5231222721 Chawalit Aojanepong\n5231334321 Suwichapol Jinnawong\n5500197921 Pierre-Edouard Arrouy\n\n(c) Room Lighting Simulation contributors 2013. All rights reserved.",
				    "About Room Lighting Simulation",
				    JOptionPane.INFORMATION_MESSAGE,
				    icon);
			System.out.println("\"About RLS\" pressed");
		}else if(pressedItem.getText().equalsIgnoreCase("Exit")){
			WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
            System.out.println("\"Exit\" pressed");
		}
	}

}
