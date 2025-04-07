package actions;
import exception.GameException;
import actors.Survivor;

public class MakeNoise extends Action{
	
	public MakeNoise(Survivor s) {
		super(s,1);
	}
	
	public String toString() {
		return "faire du bruit";
	}
	
	@Override
	public void execute() {
		if(this.nbpoints <= survivor.getActionPoints()) {
			survivor.getCell().increaseSound();
			survivor.setActionPoints(survivor.getActionPoints() - this.nbpoints);			
		} else {
			System.out.println("Vous n'avez plus de points d'action");
		}
	}
}
