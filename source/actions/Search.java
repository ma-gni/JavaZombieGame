package actions;
import equipements.*;
import actors.Survivor;
import actors.Zombie;

public class Search extends Action{
	
	public Search(Survivor s) {
		super(s,1);
	}
	
	public String toString() {
		return "rechercher";
	}
	public void execute() {
	}
}
