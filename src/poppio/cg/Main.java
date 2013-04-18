// This file responsible for UI of our program.

package poppio.cg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;


public class Main extends JFrame{
	String version = "0.01"; 
	
	JList objectList;
	DefaultListModel objectListModel;
	
	ImageButton button_up, button_down, button_left, button_right, button_low, button_high;
	
	Color deleteButtonColor = new Color(0xC91010);
	Color deleteButtonOverColor = new Color(0x960303);
	Color addButtonColor = new Color(0xEF7409);
	Color addButtonOverColor = new Color(0xD66000);
	
	public Main () throws IOException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(820, 640));
		initComponents();
		System.out.println("zue");
		
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
        menu_file.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu_file);
        
        JMenuItem menuItem_new = new JMenuItem("New");
        menuItem_new.setMnemonic(KeyEvent.VK_N);
        menuItem_new.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem_new.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_file.add(menuItem_new);
        
        menu_file.addSeparator();
        
        JMenuItem menuItem_exit = new JMenuItem("Exit");
        menuItem_exit.setMnemonic(KeyEvent.VK_X);
        menuItem_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_file.add(menuItem_exit);
        
        //Edit
        JMenu menu_edit = new JMenu("Edit entity");
        menu_edit.setMnemonic(KeyEvent.VK_E);
        menuBar.add(menu_edit);
        
        JMenuItem menuItem_rotateClockwise = new JMenuItem("Rotate clockwise");
        menuItem_rotateClockwise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_edit.add(menuItem_rotateClockwise);
        
        JMenuItem menuItem_rotateCounter = new JMenuItem("Rotate counterclockwise");
        menuItem_rotateCounter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_edit.add(menuItem_rotateCounter);
        
        menu_edit.addSeparator();
        
        JMenuItem menuItem_moveForward = new JMenuItem("Move forward");
        menuItem_moveForward.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_edit.add(menuItem_moveForward);
        
        JMenuItem menuItem_moveBackward = new JMenuItem("Move backward");
        menuItem_moveBackward.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_edit.add(menuItem_moveBackward);
        
        JMenuItem menuItem_moveLeft = new JMenuItem("Move left");
        menuItem_moveLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_edit.add(menuItem_moveLeft);
        
        JMenuItem menuItem_moveRight = new JMenuItem("Move right");
        menuItem_moveRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_edit.add(menuItem_moveRight);
        
        menu_edit.addSeparator();
        
        JMenuItem menuItem_moveUp = new JMenuItem("Move up");
        menuItem_moveUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_edit.add(menuItem_moveUp);
        
        JMenuItem menuItem_moveDown = new JMenuItem("Move down");
        menuItem_moveDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_edit.add(menuItem_moveDown);
        
        //Object
        JMenu menu_object = new JMenu("Object");
        menu_object.setMnemonic(KeyEvent.VK_O);
        menuBar.add(menu_object);
        
        JMenuItem menuItem_add_light = new JMenuItem("Add Light");
        menuItem_add_light.setMnemonic(KeyEvent.VK_L);
        menuItem_add_light.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        menuItem_add_light.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_object.add(menuItem_add_light);
        
        JMenuItem menuItem_add_furniture = new JMenuItem("Add Furniture");
        menuItem_add_furniture.setMnemonic(KeyEvent.VK_U);
        menuItem_add_furniture.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        menuItem_add_furniture.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});   
        menu_object.add(menuItem_add_furniture);
        
        //Help
        JMenu menu_help = new JMenu("Help");
        menu_help.setMnemonic(KeyEvent.VK_H);
        menuBar.add(menu_help);
        
        JMenuItem menuItem_about = new JMenuItem("About RLS");
        menuItem_about.setMnemonic(KeyEvent.VK_A);
        menuItem_about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){menuItemsPerformed(e);}});     
        menu_help.add(menuItem_about);
        
        this.setJMenuBar(menuBar);
        // end menu
        
        // left panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setBackground(Color.white);
       

        
        objectListModel = new DefaultListModel();
        objectList = new JList(objectListModel);
        objectList.setVisibleRowCount(10);
        objectList.setFocusable(false);
        
        JScrollPane objectScrollPane = new JScrollPane(objectList);
        menuPanel.add(objectScrollPane, BorderLayout.PAGE_START);
        
        //TODO delete this test list data
        for (int i = 0; i < 15; i++) {
        	addObjectToList("test"+i);
		}
        
        
        
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BorderLayout());
       
       
        
        JPanel controlPanel = new JPanel();
       // subPanel.setLayout(new BorderLayout());
        //setFixedWidth(controlPanel, 300);
        controlPanel.setPreferredSize(new Dimension(300, 150));
        controlPanel.setOpaque(false);
        menuPanel.add(controlPanel, BorderLayout.CENTER);
        
        
        //Button
        // up button
        button_up = new ImageButton(new ImageIcon(ImageIO.read(Main.class.getResource("img/up.png"))));
        button_up.setRolloverIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/up_over.png"))));
        button_up.setPressedIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/up_press.png"))));
        button_down = new ImageButton(new ImageIcon(ImageIO.read(Main.class.getResource("img/down.png"))));
        button_down.setRolloverIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/down_over.png"))));
        button_down.setPressedIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/down_press.png"))));
        button_left = new ImageButton(new ImageIcon(ImageIO.read(Main.class.getResource("img/left.png"))));
        button_left.setRolloverIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/left_over.png"))));
        button_left.setPressedIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/left_press.png"))));
        button_right = new ImageButton(new ImageIcon(ImageIO.read(Main.class.getResource("img/right.png"))));
        button_right.setRolloverIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/right_over.png"))));
        button_right.setPressedIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/right_press.png"))));
        JLabel blank = new JLabel(new ImageIcon((ImageIO.read(Main.class.getResource("img/blank.png")))));
        
        button_up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){imagebuttonPerformed(e);}});
        button_down.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){imagebuttonPerformed(e);}});
        button_left.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){imagebuttonPerformed(e);}});
        button_right.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){imagebuttonPerformed(e);}});
        
        JPanel moveButtonGroup = new JPanel();
        moveButtonGroup.setLayout(new BorderLayout());
        moveButtonGroup.setOpaque(false);
        moveButtonGroup.add(button_up, BorderLayout.PAGE_START);
        moveButtonGroup.add(button_down, BorderLayout.PAGE_END);
        moveButtonGroup.add(button_left, BorderLayout.LINE_START);
        moveButtonGroup.add(button_right, BorderLayout.LINE_END);
        moveButtonGroup.add(blank, BorderLayout.CENTER);
        controlPanel.add(moveButtonGroup, BorderLayout.LINE_START);
        
        controlPanel.add(new JLabel(new ImageIcon(ImageIO.read(Main.class.getResource("img/blank_small.png")))));
        controlPanel.add(new JLabel(new ImageIcon(ImageIO.read(Main.class.getResource("img/blank_small.png")))));

        // height button
        button_high = new ImageButton(new ImageIcon(ImageIO.read(Main.class.getResource("img/higher.png"))));
        button_high.setRolloverIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/higher_over.png"))));
        button_high.setPressedIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/higher_press.png"))));
        button_low = new ImageButton(new ImageIcon(ImageIO.read(Main.class.getResource("img/lower.png"))));
        button_low.setRolloverIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/lower_over.png"))));
        button_low.setPressedIcon(new ImageIcon(ImageIO.read(Main.class.getResource("img/lower_press.png"))));
        JLabel blank_small = new JLabel(new ImageIcon((ImageIO.read(Main.class.getResource("img/blank_small.png")))));

        button_high.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){imagebuttonPerformed(e);}});
        button_low.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){imagebuttonPerformed(e);}});
        
        JPanel heightButtonGroup = new JPanel();
        heightButtonGroup.setLayout(new BorderLayout());
        heightButtonGroup.setOpaque(false);
        heightButtonGroup.add(button_high, BorderLayout.PAGE_START);
        heightButtonGroup.add(button_low, BorderLayout.PAGE_END);
        heightButtonGroup.add(blank_small, BorderLayout.CENTER);
        controlPanel.add(heightButtonGroup, BorderLayout.LINE_END);
        //end control button group
        
        // bottom group
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(300, 180));
        bottomPanel.setOpaque(false);
        // delete button group
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        // delete button
        final SimpleButton button_delete = new SimpleButton("Delete", deleteButtonColor, Color.WHITE);
        button_delete.setPreferredSize(new Dimension(75, 30));
        button_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	button_delete.setBackground(deleteButtonOverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	button_delete.setBackground(deleteButtonColor);
            }
        });
     	ImageIcon delete_icon = new ImageIcon(ImageIO.read(Main.class.getResource("img/delete.png")));
     	button_delete.setIcon(delete_icon);
        button_delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){simplebuttonPerformed(e);}});
        buttonPanel.add(button_delete, BorderLayout.LINE_END);
        
        
        // add buttons group
        JPanel addButtonPanel = new JPanel();
        addButtonPanel.setLayout(new BorderLayout());
        addButtonPanel.setOpaque(false);
        
        final SimpleButton button_add_object = new SimpleButton("Add Object",addButtonColor, Color.WHITE);
        button_add_object.setPreferredSize(new Dimension(100, 30));
        button_add_object.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	button_add_object.setBackground(addButtonOverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	button_add_object.setBackground(addButtonColor);
            }
        });
     	ImageIcon add_object_icon = new ImageIcon(ImageIO.read(Main.class.getResource("img/add_object.png")));
     	button_add_object.setIcon(add_object_icon);
     	button_add_object.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){simplebuttonPerformed(e);}});
     	
     	 final SimpleButton button_add_light = new SimpleButton("Add Light",addButtonColor, Color.WHITE);
     	button_add_light.setPreferredSize(new Dimension(90, 30));
     	button_add_light.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	button_add_light.setBackground(addButtonOverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	button_add_light.setBackground(addButtonColor);
            }
        });
      	ImageIcon add_light_icon = new ImageIcon(ImageIO.read(Main.class.getResource("img/add_light.png")));
      	button_add_light.setIcon(add_light_icon);
      	button_add_light.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){simplebuttonPerformed(e);}});
     	
     	addButtonPanel.add(button_add_object,BorderLayout.LINE_START);
     	addButtonPanel.add(button_add_light,BorderLayout.LINE_END);
        
        menuPanel.add(bottomPanel, BorderLayout.PAGE_END);
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(buttonPanel,BorderLayout.PAGE_START);
        bottomPanel.add(addButtonPanel,BorderLayout.PAGE_END);
        // end bottom group
        
        
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        getContentPane().add(menuPanel, BorderLayout.LINE_START);
        
        // set icon for frame
        java.net.URL icon_URL = Main.class.getResource("img/logo.png");
     	BufferedImage frame_icon = ImageIO.read(icon_URL);
     	setIconImage(frame_icon);
     	// set frame
     	setTitle("Room Lighting Simulation");
        setSize( this.getContentPane().getPreferredSize() );
        setVisible( true );
        setLocationRelativeTo(null); // place JFrame in center of screen
        
        // detect keyboard, for keyboard shortcut
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
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
	/**
	 * used for adding object to object list
	 * @param obj
	 */
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
			// clear all data
		}else if(pressedItem.getText().equalsIgnoreCase("Exit")){
			// close program
			System.out.println("menu \"Exit\" pressed");
			WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
		}else if(pressedItem.getText().equalsIgnoreCase("Rotate clockwise")){
			System.out.println("menu \"Rotate clockwise\" pressed");
			// process
		}else if(pressedItem.getText().equalsIgnoreCase("Rotate counterclockwise")){
			System.out.println("menu \"Rotate counterclockwise\" pressed");
			// process
		}else if(pressedItem.getText().equalsIgnoreCase("Move forward")){
			System.out.println("menu \"Move forward\" pressed");
			// process
		}else if(pressedItem.getText().equalsIgnoreCase("Move backward")){
			System.out.println("menu \"Move backward\" pressed");
			// process
		}else if(pressedItem.getText().equalsIgnoreCase("Move left")){
			System.out.println("menu \"Move left\" pressed");
			// process
		}else if(pressedItem.getText().equalsIgnoreCase("Move right")){
			System.out.println("menu \"Move right\" pressed");
			// process
		}else if(pressedItem.getText().equalsIgnoreCase("Move up")){
			System.out.println("menu \"Move up\" pressed");
			// process
		}else if(pressedItem.getText().equalsIgnoreCase("Move down")){
			System.out.println("menu \"Move down\" pressed");
			// process
		}else if(pressedItem.getText().equalsIgnoreCase("Add Light")){
			System.out.println("menu \"Add Light\" pressed");
			// create "Add Light" Dialog ?
		}else if(pressedItem.getText().equalsIgnoreCase("Add Furniture")){
			System.out.println("menu \"Add Furniture\" pressed");
			// create "Add Object" Dialog ?
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
	public void simplebuttonPerformed(ActionEvent evt) {
		JButton pressedItem = (JButton) evt.getSource();
		if(pressedItem.getText().equalsIgnoreCase("Delete")){
			//System.out.println("button \"Delete\" pressed");
			int index = objectList.getSelectedIndex();
			if(index>=0){
				String selected = (String)objectListModel.get(index);
				System.out.println("Delete "+selected);
			}else{
				System.out.println("No item selected, cannot delete.");
			}
			
		}else if(pressedItem.getText().equalsIgnoreCase("Add Object")){
			System.out.println("\"Add Object\" pressed");
		}else if(pressedItem.getText().equalsIgnoreCase("Add Light")){
			System.out.println("\"Add Light\" pressed");
		}
	}
	
	/**
	 * method for img buttons action listener
	 * @param evt
	 */
	public void imagebuttonPerformed(ActionEvent evt) {
		
		if(evt.getSource()==button_up){
			System.out.println("button \"Up\" pressed");
			
		}else if(evt.getSource()==button_down){
			System.out.println("button \"Down\" pressed");
			
		}else if(evt.getSource()==button_left){
			System.out.println("button \"Left\" pressed");
			
		}else if(evt.getSource()==button_right){
			System.out.println("button \"Right\" pressed");
			
		}else if(evt.getSource()==button_high){
			System.out.println("button \"Higher\" pressed");
			
		}else if(evt.getSource()==button_low){
			System.out.println("button \"Lower\" pressed");
			
		}
	}
	
	/**
	 * set component width
	 * @param component
	 * @param width
	 */
	private static void setFixedWidth( Component component, int width ){
		component.setSize( new Dimension( width, Short.MAX_VALUE ) );
		Dimension preferredSize = component.getPreferredSize();
		component.setPreferredSize( new Dimension( width, preferredSize.height ) );
	}

	// keyboard listener
	private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
            	
            	
            	if(e.getKeyCode() == KeyEvent.VK_UP){
            		System.out.println("key \"Up\" pressed");
            	}
            	
                //System.out.println("key pressed");
            } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                //System.out.println("key released");
            } else if (e.getID() == KeyEvent.KEY_TYPED) {
                //System.out.println("key typeed");
            }
            return false;
        }
    }
}
