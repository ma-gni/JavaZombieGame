package actions;

import java.util.List;

import actors.HealerRole;
import actors.Survivor;
import listchooser.InteractiveListChooser;
import listchooser.ListChooser;
import exception.GameException;

public class Heal extends Action {

    public Heal(Survivor s) {
        super(s);
    }
    
    public String toString() {
		return "soigner";
	}

    public void execute(){ //throws GameException
        if (survivor.getRole() !="Healer"||survivor.getActionPoints()<= nbpoints){
            System.out.println("Sorry u cant heal");
        }
        else {
            List <Survivor> survivors = survivor.getSurvivorNearby();
            if (survivors.isEmpty())
                System.out.println("Sorry no survivors near you to heal");
            for (Survivor s : survivors) {
                s.incrementLifePoints(1);
            }
        }
    }

}
