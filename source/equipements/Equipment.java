package equipements;

import actors.Survivor;
import board.Board ;
public abstract class Equipment {
	protected String name;
	boolean isNoisy;
	public abstract void use(Survivor s);

	public Equipment(String name) {
		 this.name= name;	 
	}
	
	public String toString() {
		String result=this.getName();
		return result;
	}
	public String getName() {
		return this.name;
	}
	public boolean canOpenDoor(){
		return false;
	}
	public boolean isNoisy() {
		return false;
	}
}
