package board;

import equipements.Equipment;

/**
 * Represents a room on the board.
 */
public class Room extends Cell {
    protected char room;
    private Equipment equipment;
    

    /**
     * Constructs a new room at the specified coordinates.
     * @param x The x-coordinate of the room.
     * @param y The y-coordinate of the room.
     */
    public Room(Board board,int x, int y) {
        super(board,x, y);
        this.room = 'R';
    }
    
    public void setEquipment(Equipment equipment){
        this.equipment = equipment;
    }
}

