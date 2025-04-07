package actions;

import board.*;
import actors.Survivor;
import equipements.Equipment;
import listchooser.*;
import listchooser.util.*;


public class TakeEquipement extends Action {


    public TakeEquipement(Survivor s) {
        super(s,1);

    }
    
    public String toString() {
		return "ramasser un équipement";
	}

    @Override
    public void execute() {
        Cell currentCell = survivor.getCell();
        if (currentCell.getEquipements().isEmpty()) {
            System.out.println("Aucun équipement n'est à prendre dans cette case.");
        }
        ListChooser<Equipment> chooser = new InteractiveListChooser<>();
        Equipment chosenEquipment = chooser.choose("Quel équipement vous voulez prendre ?", currentCell.getEquipements());
        
        if (chosenEquipment != null) {
            System.out.println(survivor.getName() + " a pris l'équipement : " + chosenEquipment);
            currentCell.getEquipements().remove(chosenEquipment);
            survivor.addToBackpack(chosenEquipment);            
        } else {
            System.out.println(survivor.getName() + " n'a pas pris d'équipement.");
        }
       
    
    }
}
