package poppio.cg;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Main extends JFrame{
	String version = "0.01"; 
	
	JButton button_delete;
	JList objectList;
	DefaultListModel objectListModel;
	
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
        JMenuBar menuBar = new JMenuBar();
        //File
        JMenu menu_file = new JMenu("File");
        menuBar.add(menu_file);
        
        JMenuItem menuItem_new = new JMenuItem("New");
        menuItem_new.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_file.add(menuItem_new);
        
        JMenuItem menuItem_exit = new JMenuItem("Exit");
        menuItem_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_file.add(menuItem_exit);
        
        //Object
        JMenu menu_object = new JMenu("Object");
        menuBar.add(menu_object);
        
        JMenuItem menuItem_add_light = new JMenuItem("Add Light");
        menuItem_add_light.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_object.add(menuItem_add_light);
        JMenuItem menuItem_add_furniture = new JMenuItem("Add Furniture");
        menuItem_add_furniture.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_object.add(menuItem_add_furniture);
        
        //Help
        JMenu menu_help = new JMenu("Help");
        menuBar.add(menu_help);
        
        JMenuItem menuItem_about = new JMenuItem("About RLS");
        menuItem_about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});     
        menu_help.add(menuItem_about);
        
        this.setJMenuBar(menuBar);
        
        
        // left panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        
        JPanel subPanel = new JPanel();
        setFixedWidth(subPanel, 300);
        menuPanel.add(subPanel, BorderLayout.CENTER);

        
        objectListModel = new DefaultListModel();
        objectList = new JList(objectListModel);
        objectList.setVisibleRowCount(10);
        JScrollPane objectScrollPane = new JScrollPane(objectList);
        menuPanel.add(objectScrollPane, BorderLayout.PAGE_START);
        
        for (int i = 0; i < 15; i++) {
        	addObjectToList("test"+i);
		}
        
        
        button_delete = new JButton("Delete");
        button_delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){buttonPerformed(e);}});
        subPanel.add(button_delete);
        
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        getContentPane().add(menuPanel, BorderLayout.LINE_START);
        
        // set icon
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
	
	private void addObjectToList(Object obj){
		objectListModel.addElement(obj);
	}
	
	/**
	 * method for top menu bar action listener
	 * @param evt
	 */
	public void menuItemsPerformed(ActionEvent evt) {
		JMenuItem pressedItem = (JMenuItem) evt.getSource();
		if(pressedItem.getText().equalsIgnoreCase("New")){
			System.out.println("menu \"New\" pressed");
			
		}else if(pressedItem.getText().equalsIgnoreCase("Exit")){
			// close program
			System.out.println("menu \"Exit\" pressed");
			WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
		}else if(pressedItem.getText().equalsIgnoreCase("Add Light")){
			System.out.println("menu \"Add Light\" pressed");
			
		}else if(pressedItem.getText().equalsIgnoreCase("Add Furniture")){
			System.out.println("menu \"Add Furniture\" pressed");
			
		}else if(pressedItem.getText().equalsIgnoreCase("About RLS")){
			System.out.println("menu \"About RLS\" pressed");
			java.net.URL icon_URL = Main.class.getResource("img/logo.png");
		     	BufferedImage frame_icon = null;
				try {
					frame_icon = ImageIO.read(icon_URL);
				} catch (IOException e) {
					e.printStackTrace();
				}
		     	ImageIcon icon = new ImageIcon(frame_icon);
			JOptionPane.showMessageDialog(this,
				    "Room lighting Simulation v"+version+"\nGraphics Computing 2143424\nChulalongkorn University\n\n5231222721 Chawalit Aojanepong\n5231334321 Suwichapol Jinnawong\n5500197921 Pierre-Edouard Arrouy\n\n(c) Room Lighting Simulation contributors 2013. All rights reserved.",
				    "About Room Lighting Simulation",
				    JOptionPane.INFORMATION_MESSAGE,
				    icon);
		}
	}
	
	/**
	 * method for buttons action listener
	 * @param evt
	 */
	public void buttonPerformed(ActionEvent evt) {
		JButton pressedItem = (JButton) evt.getSource();
		if(pressedItem.getText().equalsIgnoreCase("Delete")){
			System.out.println("button \"Delete\" pressed");
		}
	}
	
	/**
	 * set component width
	 * @param component
	 * @param width
	 */
	public static void setFixedWidth( Component component, int width ){
		component.setSize( new Dimension( width, Short.MAX_VALUE ) );
		Dimension preferredSize = component.getPreferredSize();
		component.setPreferredSize( new Dimension( width, preferredSize.height ) );
	}
}
