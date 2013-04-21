package poppio.cg;

public class Light extends roomObject{
	
	
	public Light(int id, int lightCount){
		super(id); 
		
		this.name = "light"+lightCount;
	}
}
