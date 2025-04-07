package actors;

import board.Board;
import board.Cell;


/**
 * Represents an actor in the game.
 */
public class Actors {
	protected Board board;
    protected Cell cell;
    protected int lifePoints;
    protected String name;


    /**
     * Constructs an actor with the specified life points, starting cell, and name.
     * @param lifePoints The life points of the actor.
     * @param cell The starting cell of the actor.
     * @param name The name of the actor.
     */
    public Actors(int lifePoints, Cell cell, String name){
        this.lifePoints = lifePoints;
        this.cell = cell;
        this.name = name;
        this.board = board;
    }

    /**
     * Gets the life points of the actor.
     * @return The life points of the actor.
     */
    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int amount){
        this.lifePoints = amount;
    }
    public Cell getCell(){
        return this.cell;
    }
    // I added this method to use it in the attack class to check the range
    public int differenceBetweenTwoActors(Actors otherActor){
        int x1 = this.cell.getX();
        int y1 = this.cell.getY();
        int x2 = otherActor.getCell().getX();
        int y2 = otherActor.getCell().getY();
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    public void setCell(Cell cell){
        this.cell = cell;
    }
    public Board getBoard() {
    	return this.board;
    }

    /**
     * Gets the name of the actor.
     * @return The name of the actor.
     */
    public String getName() {
        return this.name;
    }
}
