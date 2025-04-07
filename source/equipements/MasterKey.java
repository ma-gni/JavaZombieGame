package equipements;

import actors.Survivor;

public class MasterKey extends Equipment {

	public MasterKey() {
		super("MasterKey");
	}
	@Override
	public void use(Survivor s) {
	}
	
	@Override
	public boolean canOpenDoor(){
		return true;
	}
}
