package actors;

import board.Cell;

public class RunnersZ extends Zombie{
    public RunnersZ(Cell cell,String name) {
        super(2, cell, 1, name);
    }
    @Override
    public String toString() {
        return getName() + " (Runner)";
    }
}
