package actors;

import board.Cell;

public class ToughZ extends Zombie{
    public ToughZ(Cell cell, String name){
        super(4, cell, 2, name);
    }
    
    @Override
    public String toString() {
        return getName() + " (Tough)";
    }
}
