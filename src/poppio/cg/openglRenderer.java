package poppio.cg;

import java.util.ArrayList;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class openglRenderer implements GLEventListener {
	private GLU glu = new GLU();
	private float width, length;
	private int referenceWidth, referenceLength;
	//private int mDisplayListID;
	WavefrontObjectLoader_VertexBufferObject objLoader;// for test only
	private int Cx = 0,Cz = 0,Cy = 0, Cd = 3;
	
	private ArrayList<Furniture> furnituresList;
	private ArrayList<Light> lightList;
	
	public openglRenderer () {
		this.width=0;
		this.length = 0;
		referenceWidth = 300;
		referenceLength = 300;
		
		furnituresList = new ArrayList<Furniture>();
		lightList = new ArrayList<Light>();
	}
	
	@Override
	public void display(GLAutoDrawable gldrawable) {
		
	
		
		//split 2 stage
		//System.out.println("display called");
		
		
		update();
		setLight(gldrawable);
		render(gldrawable);
		

		
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
		gl.glEnable(GL2.GL_TEXTURE_2D);
		// load obj data
		//mDisplayListID = WavefrontObjectLoader_DisplayList.loadWavefrontObjectAsDisplayList(gl,"obj/table.obj"); 
		//objLoader = new WavefrontObjectLoader_VertexBufferObject("obj/bin.obj");
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
	    glu.gluLookAt(3,Cd,1,Cx,Cz,Cy,0,0,1);
	     
	    gl.glPushMatrix();
	    //
	    gl.glScalef(width/referenceWidth, length/referenceLength, 1);
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
	    
	    gl.glPopMatrix();
	    //gl.glScalef((float)((width/referenceWidth)*0.1), (float)((length/referenceLength)*0.1), (float)(1*0.1));
	    
	    //objLoader.DrawModel(gl);
	    gl.glColor3f(1,1,1);
	    for (Furniture tempFur : furnituresList) {
	    	gl.glPushMatrix();
	    	
		    	gl.glScalef((float)0.3, (float)0.3, (float)0.3); // scale model down
		    	WavefrontObjectLoader_VertexBufferObject tempObj = tempFur.getObjectLoader();
		    	gl.glTranslated(tempFur.coorX, tempFur.coorY, tempFur.coorZ); // coordianate of model
		    	
		    	tempObj.DrawModel(gl);
		    	
	    	gl.glPopMatrix();
	    	
	    }

	    
	}
	
	public void setLight (GLAutoDrawable gldrawable) {
		GL2 gl = gldrawable.getGL().getGL2();
		float[] lightPos = { 2000,3000,2000,1 };        // light position
		float[] noAmbient = { 0.2f, 0.2f, 0.2f, 1f };     // low ambient light
		float[] diffuse = { 1f, 1f, 1f, 1f };        // full diffuse colour

		gl.glEnable(GL2.GL_LIGHTING);
		gl.glEnable(GL2.GL_LIGHT0);
		gl.glEnable(GL2.GL_COLOR_MATERIAL);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, noAmbient, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION,lightPos, 0);
        
     
	}
	
	public void setWidth (float width) {
		this.width = width;
	}
	
	public void setLength (float length) {
		this.length = length;
	}
	
	public void InCx(){
	  Cx = Cx+1 ;
	 }
	 
	 public void InCz(){
	  Cz = Cz+1;
	 }
	 
	 public void InCy(){
	  Cy = Cy+1;
	  
	 }	 
	 public void InCd(){
	Cd = Cd+1;
		 
	}
	 public void DeCx(){
	  Cx = Cx-1;
	 }
	 
	 public void DeCz(){
	  Cz = Cz-1;
	 }
	 
	 public void DeCy(){
		  Cy = Cy-1;
		  
	 }
	 
	 public void DeCd(){
		 Cd = Cd-1;
	}
		 
	 public void addFurnitureToList(Furniture newObject){
		 this.furnituresList.add(newObject);
	 }
	 public void removeFurnitureFromList(Furniture removeObject){
		 this.furnituresList.remove(removeObject);
	 }
	 public void addLightToList(Light newLight){
		 this.lightList.add(newLight);
	 }
	 public void removeLightFromList(Light removeObject){
		 this.lightList.remove(removeObject);
	 }
}
