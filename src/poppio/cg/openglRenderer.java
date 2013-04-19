package poppio.cg;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class openglRenderer implements GLEventListener {
	private GLU glu = new GLU();
	private float width, length;
	
	public openglRenderer () {
		
	}
	
	@Override
	public void display(GLAutoDrawable gldrawable) {
		
	
		
		//split 2 stage
		//System.out.println("display called");
		
		
		update();
		setLight(gldrawable);
		render(gldrawable);
		try {
			Thread.sleep(20);
		}catch(InterruptedException e){e.printStackTrace();}
		

		
	}

	@Override
	public void dispose(GLAutoDrawable gldrawable) {
		System.out.println("dispose() called");
	}

	@Override
	public void init(GLAutoDrawable gldrawable) {
		GL2 gl = gldrawable.getGL().getGL2();
		gl.glMatrixMode( GL2.GL_PROJECTION );
		gl.glLoadIdentity( );
		glu.gluPerspective(70,(double)600/600,1,1000);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		System.out.println("init() called");
	}
	
	@Override
	public void reshape(GLAutoDrawable gldrawable, int x, int y, int width, int height) {
    	System.out.println("reshape() called: x = "+x+", y = "+y+", width = "+width+", height = "+height);
	}
	
	private void update() {
	
	}
	
	private void render(GLAutoDrawable gldrawable) {
		GL2 gl = gldrawable.getGL().getGL2();

	    gl.glClear( GL2.GL_COLOR_BUFFER_BIT  | GL2.GL_DEPTH_BUFFER_BIT );
	    
	    gl.glMatrixMode( GL2.GL_MODELVIEW );
	    gl.glLoadIdentity( );
	    glu.gluLookAt(3,3,1,0,0,0,0,0,1);
	    
	    gl.glScalef(2, 2, 1);
	   
	    
	   
	    // draw a triangle filling the window
	    gl.glBegin(GL2.GL_QUADS);
	    
	    gl.glColor3f(0,0,1); //face rouge
	    gl.glVertex3d(-1,-1,1);
	    gl.glVertex3d(-1,-1,-1);
	    gl.glVertex3d(1,-1,-1);
	    gl.glVertex3d(1,-1,1);
	    
	    gl.glColor3f(1,0,1);
	    gl.glVertex3d(-1,1,1);
	    gl.glVertex3d(-1,1,-1);
	    gl.glVertex3d(-1,-1,-1);
	    gl.glVertex3d(-1,-1,1);
	 
	    gl.glColor3f(0,1,1); //face cyan
	    gl.glVertex3d(1,1,-1);
	    gl.glVertex3d(1,-1,-1);
	    gl.glVertex3d(-1,-1,-1);
	    gl.glVertex3d(-1,1,-1);
	    
	    gl.glColor3f(0,1,0); //face cyan
	    gl.glVertex3d(0.25,0.25,0);
	    gl.glVertex3d(0.25,0.75,0);
	    gl.glVertex3d(0.75,0.75,0);
	    gl.glVertex3d(0.75,0.25,0);
	 
	   /* gl.glColor3f(1,1,0); //face magenta
	    gl.glVertex3d(1,-1,1);
	    gl.glVertex3d(1,1,1);
	    gl.glVertex3d(-1,1,1);
	    gl.glVertex3d(-1,-1,1);*/
	    
	    gl.glEnd();
	    
	   
	    
	}
	
	public void setLight (GLAutoDrawable gldrawable) {
		GL2 gl = gldrawable.getGL().getGL2();
		 // Prepare light parameters.
        float SHINE_ALL_DIRECTIONS = 5;
        float[] lightPos = {3, 3, 40, SHINE_ALL_DIRECTIONS};
        float[] lightColorAmbient = {0.2f, 0.2f, 0.2f, 1f};
        float[] lightColorSpecular = {0.8f, 0.8f, 0.8f, 1f};

        // Set light parameters.
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, lightPos, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_AMBIENT, lightColorAmbient, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_SPECULAR, lightColorSpecular, 0);

        // Enable lighting in GL.
        gl.glEnable(GL2.GL_LIGHT1);
        gl.glEnable(GL2.GL_LIGHTING);

     // Set material properties.
        float[] rgba = {0.3f, 0.5f, 1f};
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL2.GL_FRONT, GL2.GL_SHININESS, 0.5f);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
     
	}
	

}
