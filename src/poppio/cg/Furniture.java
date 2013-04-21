package poppio.cg;
// for store data of furnitures
public class Furniture extends roomObject{
	
	private String path;
	private WavefrontObjectLoader_VertexBufferObject obj;
	
	
	public Furniture (int id, int furnitureCount, int objectID) {
		super(id); 
		
		
		if(objectID == 1){
			// bin
			this.name = "bin"+furnitureCount;
			this.path = "obj/bin.obj";
		}else if(objectID == 2){
			// table
			this.name = "table"+furnitureCount;
			this.path = "obj/table.obj";
		}else if(objectID == 3){
			// table
			this.name = "chair"+furnitureCount;
			this.path = "obj/chair.obj";
		}else if(objectID == 4){
			// table
			this.name = "cube"+furnitureCount;
			this.path = "obj/cube.obj";
		}else if(objectID == 5){
			// table
			this.name = "sphere"+furnitureCount;
			this.path = "obj/sphere.obj";
		}else{ // gonna add more
			// wtf
		}
		this.obj = new WavefrontObjectLoader_VertexBufferObject(path);
	}
	
	public WavefrontObjectLoader_VertexBufferObject getObjectLoader() {
		return this.obj;
	}
	
	
}
