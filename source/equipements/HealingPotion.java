package equipements;

import actors.Survivor;

public class HealingPotion extends Equipment {
	private Survivor survivor;
	
	public HealingPotion() {
		super("HealingPotion");
	}

	@Override
	public void use(Survivor survivor) {
		if (survivor.getLifePoints()<5)
			survivor.setLifePoints(5);
	}
	public boolean isNoisy() {
		return false;
	}
}
