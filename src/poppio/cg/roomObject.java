package poppio.cg;
// parent class of furniture and light
public class roomObject {
	protected int id;	
	protected double coorX, coorY, coorZ;
	final double CHANGE_AMOUNT = 1; //amount to change in coordinate when press move key
	protected String name;
	float rotateX, rotateY, rotateZ;
	
	public roomObject(int id){
		this.id = id; // set id
		
		// set default coordinate
		coorX = 0;
		coorY = 0;
		coorZ = 0;
		
		rotateX = 0;
		rotateY = 0;
		rotateZ = 0;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void inCoorX(){
		this.coorX += CHANGE_AMOUNT;
	}
	public void deCoorX(){
		this.coorX -= CHANGE_AMOUNT;
	}
	public void inCoorY(){
		this.coorY += CHANGE_AMOUNT;
	}
	public void deCoorY(){
		this.coorY -= CHANGE_AMOUNT;
	}
	public void inCoorZ(){
		this.coorZ += CHANGE_AMOUNT;
	}
	public void deCoorZ(){
		this.coorZ -= CHANGE_AMOUNT;
	}
	public String toString(){
		return name;
	}
}
