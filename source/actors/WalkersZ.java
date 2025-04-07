package actors;

import board.Cell;

public class WalkersZ extends Zombie{
    public WalkersZ(Cell cell,String name){
        super(1, cell, 1,name);

    }
    
    @Override
    public String toString() {
        return getName() + " (Walker)";
    }
}
