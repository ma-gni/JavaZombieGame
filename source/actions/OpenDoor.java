package actions ;
import java.util.*;
import equipements.*;
import listchooser.InteractiveListChooser;
import listchooser.ListChooser;
import board.*;

import actors.Survivor;

public class OpenDoor extends Action {
	private List<DoorPosition> possibleActions;
	
    public OpenDoor (Survivor s) {
        super(s, 1);
        this.possibleActions = new ArrayList<>();
        possibleActions.add(DoorPosition.LEFT);
        possibleActions.add(DoorPosition.RIGHT);
        possibleActions.add(DoorPosition.BOTTOM);
        possibleActions.add(DoorPosition.TOP);
    }
    
    public String toString() {
		return "ouvrir une porte";
		//Gerer le choix de la porte avec le listChooser
	}

    public void execute() {
    	ListChooser<DoorPosition> chooser = new InteractiveListChooser<>();
        DoorPosition choice = chooser.choose("Quel porte voulez-vous ouvrir", possibleActions);
    	    	if(survivor.getCell().getDoors().containsKey(choice)) {
    	    		if(!(survivor.getCell().getDoors().get(choice).isOpen())) {
    	    			if(choice==DoorPosition.LEFT) {
    	    				survivor.getBoard().getHorizontalDoor(survivor.getCell().getX()-1,survivor.getCell().getY()).open();
    	    				System.out.println("La porte gauche est ouverte");
    	    			}else if(choice==DoorPosition.RIGHT) {
    	    				survivor.getBoard().getHorizontalDoor(survivor.getCell().getX()+1,survivor.getCell().getY()).open();
    	    				System.out.println("La porte droite est ouverte");
    	    			}else if(choice==DoorPosition.TOP) {
    	    				survivor.getBoard().getVerticalDoor(survivor.getCell().getX(),survivor.getCell().getY()-1).open();
    	    				System.out.println("La porte du haut est ouverte");
    	    			}else if(choice==DoorPosition.BOTTOM) {
    	    				survivor.getBoard().getVerticalDoor(survivor.getCell().getX(),survivor.getCell().getY()+1).open();
    	    				System.out.println("La porte du bas est ouverte");
    	    			}
    	    		} else {
    	    			System.out.println("Cette porte est déja ouverte");
    	    		}
    	    	} else {
    	    		System.out.println("Il n'y a pas de porte dans cette direction");
    	    	}
    	    }
}
