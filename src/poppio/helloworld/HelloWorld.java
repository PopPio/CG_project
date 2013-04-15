package poppio.helloworld;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
 
public class HelloWorld 
{
    public static void main(String[] args) 
    {
    	// setup OpenGL Version 2
    	GLProfile profile = GLProfile.get(GLProfile.GL2);
    	GLCapabilities capabilities = new GLCapabilities(profile);
 
    	// The canvas is the widget that's drawn in the JFrame
    	GLCanvas glcanvas = new GLCanvas(capabilities);
    	glcanvas.addGLEventListener(new Renderer());
    	glcanvas.setSize( 500, 500 );
 
        JFrame frame = new JFrame( "Hello World" );
        frame.getContentPane().add( glcanvas);
 
        // shutdown the program on windows close event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
 
        frame.setSize( frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );
    }
}