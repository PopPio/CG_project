package poppio.cg;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class openglRenderer implements GLEventListener {

	@Override
	public void display(GLAutoDrawable gldrawable) {
		//split 2 stage
		//System.out.println("display called");
		update();
		render(gldrawable);
	}

	@Override
	public void dispose(GLAutoDrawable gldrawable) {
		System.out.println("dispose() called");
	}

	@Override
	public void init(GLAutoDrawable gldrawable) {
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
	    
	    // draw a triangle filling the window
	    gl.glBegin(GL.GL_TRIANGLES);
	    gl.glColor3f(1, 0, 0);
	    gl.glVertex2f(-1, -1);
	    gl.glColor3f(0, 1, 0);
	    gl.glVertex2f(0, 1);
	    gl.glColor3f(0, 0, 1);
	    gl.glVertex2f(1, -1);
	    gl.glEnd();
	}
}
