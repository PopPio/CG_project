package poppio.cg;
// for store data of furnitures
public class Furniture {
	float coorX, coorY, coorZ;
	private String name;
	private String path;
	
	final double CHANGE_AMOUNT = 1;
	
	private WavefrontObjectLoader_VertexBufferObject obj;
	
	public Furniture (int objectID) {
		// set default coordinate
		coorX = 0;
		coorY = 0;
		coorZ = 0;
		
		if(objectID == 1){
			// bin
			this.name = "bin";
			this.path = "obj/bin.obj";
		}else if(objectID == 2){
			// table
			this.name = "table";
			this.path = "obj/table.obj";
		}else if(objectID == 3){
			// table
			this.name = "chair";
			this.path = "obj/chair.obj";
		}else if(objectID == 4){
			// table
			this.name = "cube";
			this.path = "obj/cube.obj";
		}else if(objectID == 5){
			// table
			this.name = "sphere";
			this.path = "obj/sphere.obj";
		}else{ // gonna add more
			// wtf
		}
		this.obj = new WavefrontObjectLoader_VertexBufferObject(path);
	}
	
	// use by objectloader to load .obj file
	/*public String getPath(){
		return this.path;
	}*/
	
	public WavefrontObjectLoader_VertexBufferObject getObjectLoader() {
		return this.obj;
	}
	
	public String toString(){
		return name;
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
}
