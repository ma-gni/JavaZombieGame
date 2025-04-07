package actors;
import java.util.ArrayList;
import java.util.List;

import actions.*;
import board.Board;
import board.Cell;

/**
 * Represents a zombie actor in the game.
 */
public class Zombie extends Actors  {
    private Cell cell;
    protected int damage;
    private List<Action> possibleActions;
    private static int COUNTER = 1;
    private Board board;

    /**
     * Constructs a zombie with the specified life points, starting cell, damage, and name.
     * @param lifePoints The life points of the zombie.
     * @param cell The starting cell of the zombie.
     * @param damage The damage inflicted by the zombie.
     * @param name The name of the zombie.
     */
    public Zombie(int lifePoints, Cell cell, int damage, String name){
        super(lifePoints, cell, "");
        this.possibleActions = new ArrayList<Action>();
        possibleActions.add(new Attack(this));
        //possibleActions.add(new Move(this));
        this.damage = damage;
        this.name= "Zombie"+(Zombie.COUNTER++);
        this.cell.addZombie(this);
        this.board=this.cell.getBoard();
        this.board.getListOfZombies().add(this);
        }
    

    /**
     * Returns a string representation of the zombie.
     * @return The name of the zombie.
     */
    public String toString() {
        return this.getName();
    }
    public int getDamage(){
    	return damage;
    }
    public List<Survivor> getSurvivorsNearby() {
        List<Survivor> survivorsNearby = new ArrayList<>();
        int x = this.cell.getX();
        int y = this.cell.getY();
        int[] neighbourOffsests = {-1, 0, 1};
        for (int offsetX : neighbourOffsests) {
            for (int offsetY : neighbourOffsests) {
                if (offsetX == 0 && offsetY == 0) {
                    continue;
                }
                Cell c = this.board.getCell(x + offsetX, y + offsetY);
                survivorsNearby.addAll(c.getSurvivors());
            }
        }
        return survivorsNearby;
    }

    public void takeDamage(int damage){
        if (this.lifePoints-damage >0){
            this.lifePoints -=damage;
        } else {
        	this.getCell().getZombies().remove(this);
        	System.out.println(this.name+" sur la case "+this.getCell().getPosition()+" est mort");
        }
    }
    /**
     * Moves the specified zombie to the cell representing the noisiest zone on the board and initiates an attack on any survivors present in that zone.
     *
     * @param zombie The zombie to be moved to the noisiest zone.
     */
    public void MoveZombieToTheNoisiestZone(Zombie zombie) {
        Cell targetZone = zombie.board.getNoisiestZone();

        if (targetZone == null) {
            System.out.println("no target zone found. Zombie cannot move.");
            return;
        }
        Cell currentCell = zombie.getCell();
        currentCell.getZombies().remove(zombie);

        targetZone.getZombies().add(zombie);
        zombie.setCell(targetZone);

        System.out.println(" moved to the zone with the highest noise level: ");
        if (targetZone.hasSurvivors()) {
            ArrayList<Survivor> survivors = (ArrayList<Survivor>) zombie.getSurvivorsNearby();
            for (Survivor survivor : survivors) {
                Attack attack = new Attack(zombie);
                attack.execute(survivor);
            }
        }

    }
}
