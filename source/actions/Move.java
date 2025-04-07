package actions;
import actors.*;
import board.*;
import exception.GameException;
import listchooser.InteractiveListChooser;
import listchooser.ListChooser;

import java.util.*;


public class Move extends Action{
	private List<DoorPosition> possibleActions;
	
	public Move(Survivor s) {
		super(s,1);
		this.possibleActions = new ArrayList<>();
		for (DoorPosition doorPosition : DoorPosition.values()) {
            Door door = survivor.getCell().getDoor(doorPosition);
            if (door != null && door.isOpen()) {
                possibleActions.add(doorPosition);
            }
		}
	}
	
	public String toString() {
		return "se déplacer";
	}
	
	//the execution in s class would consist on the door that the survivor would be choosing to move to
	public void execute() {
		ListChooser<DoorPosition> chooser = new InteractiveListChooser<>();
        DoorPosition choice = chooser.choose("Où voulez-vous aller ?", possibleActions);
        if(choice==DoorPosition.LEFT) {
        	Cell e=survivor.getBoard().getCell(survivor.getCell().getX()-1,survivor.getCell().getY());
			survivor.setCell(e);
			System.out.println(survivor.getName()+" s'est déplacé à gauche sur la case "+survivor.getCell().getPosition());
		}else if(choice==DoorPosition.RIGHT) {
			Cell e=survivor.getBoard().getCell(survivor.getCell().getX()+1,survivor.getCell().getY());
			survivor.setCell(e);
			System.out.println(survivor.getName()+" s'est déplacé à droite sur la case "+survivor.getCell().getPosition());
		}else if(choice==DoorPosition.TOP) {
			Cell e=survivor.getBoard().getCell(survivor.getCell().getX(),survivor.getCell().getY()-1);
			survivor.setCell(e);
			System.out.println(survivor.getName()+" s'est déplacé en haut sur la case "+survivor.getCell().getPosition());
		}else if(choice==DoorPosition.BOTTOM) {
			Cell e=survivor.getBoard().getCell(survivor.getCell().getX(),survivor.getCell().getY()+1);
			survivor.setCell(e);
			System.out.println(survivor.getName()+" s'est déplacé en bas sur la case "+survivor.getCell().getPosition());
		}
	}

	//here we are trying to create a method where we see if there are any open doors near the survivor
	//if yes we will be collecting them in an arraylist
	/*
	public List<Door> getOpenDoorsNearBy() {
		int x = survivor.getCell().getX();
		int y = survivor.getCell().getY();
		int[] neighbourOffsests = {-1, 0, 1};
		for (int offsetX : neighbourOffsests) {
			for (int offsetY : neighbourOffsests) {
				if (offsetX == 0 && offsetY == 0) {
					continue;
				}
				Cell cell = s.board.getCell(x + offsetX, y + offsetY);
				cell.getDoor(offsetX)
//s method may still need some debuging

			}
		}
	}
	/*
	        int x = s.cell.getX();
        int y = s.cell.getY();
        int[] neighbourOffsests = {-1, 0, 1};
        for (int offsetX : neighbourOffsests) {
            for (int offsetY : neighbourOffsests) {
                if (offsetX == 0 && offsetY == 0) {
                    continue;
                }
                Cell c = s.board.getCell(x + offsetX, y + offsetY);
                zombiesNearby.addAll(c.getZombies());
            }
        }
        return zombiesNearby;
*/
}
