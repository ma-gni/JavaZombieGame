package equipements;

import actors.Survivor;

public class InfraredGlasses extends Equipment {

	public InfraredGlasses() {
		super("InfraredGalsses");
	}

	@Override
	public void use(Survivor s) {
		s.getZombieNearby();
	}
	
	public boolean isNoisy() {
		return false;
	}
}
