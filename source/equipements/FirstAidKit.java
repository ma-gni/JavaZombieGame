package equipements;

import actors.Survivor;

import java.util.ArrayList;

public class FirstAidKit extends Equipment {
	private Survivor survivor;
	public FirstAidKit() {
		super("FirstAidKit");
	}

	@Override
	public void use(Survivor s) {
		for(Survivor healdSurvivors : s.getSurvivorNearby()){
			healdSurvivors.incrementLifePoints(1);
		}

	}
	
	public boolean isNoisy() {
		return false;
	}
}
