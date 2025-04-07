package actions;

import board.*;
import actors.*;

public class LookAround extends Action {
    

    public LookAround(Survivor s) {
        super(s,0); 
    }
    
    public String toString() {
		return "regarder autour";
	}


    public void execute() {
        Cell currentCell = survivor.getCell();

        System.out.println("------Description de la cellule :-------" + '\n');
        System.out.println(" - Survivants présents : " + currentCell.getSurvivorsContent());
        System.out.println(" - Portes ouvertes : ");
        for (DoorPosition doorPosition : DoorPosition.values()) {
            Door door = currentCell.getDoor(doorPosition);
            if (door != null && door.isOpen()) {
                System.out.print("  - " + doorPosition.name() + '\n');
            }
        }

        System.out.println(" - Portes fermées : ");
        for (DoorPosition doorPosition : DoorPosition.values()) {
            Door door = currentCell.getDoor(doorPosition);
            if (door != null && !door.isOpen()) {
                System.out.print("  - " + doorPosition.name() + '\n');
            }
        }
    }
}
