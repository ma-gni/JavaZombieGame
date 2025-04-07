package board;

import java.util.*;

import java.util.Map;

import equipements.*;
import actors.*;
/**
 * Represents a cell on the board, which can be a part of a room or a street.
 */
public class Cell {
    protected int x;
    protected int y;
    protected char c;
    protected Map<DoorPosition, Door> doors;
    protected int noiseLevel; 
    protected Board board;
    protected List<Equipment> equipment;
    protected List<Survivor> survivors;
    protected List<Zombie> zombies;
    private List<Actors> actors;

    /**
     * Constructs a cell with the specified coordinates.
     * @param x The x-coordinate of the cell.
     * @param y The y-coordinate of the cell.
     */
    public Cell(Board board,int x, int y) {
    	this.doors = new HashMap<>();
        this.x = x;
        this.y = y;
        this.board = board;
        this.noiseLevel = 0;
        equipment = new LinkedList<>();
        survivors = new LinkedList<>();
        zombies = new LinkedList<>();
        actors = new ArrayList<>();
        
        //doors = new HashMap<>();
       /* doors.put(DoorPosition.LEFT, new Door(DoorPosition.LEFT));
        doors.put(DoorPosition.RIGHT, new Door(DoorPosition.RIGHT));
        doors.put(DoorPosition.TOP, new Door(DoorPosition.TOP));
        doors.put(DoorPosition.BOTTOM, new Door(DoorPosition.BOTTOM));

        // doors always closed at the edges
        if (x == 0 || x == Board.getWidth() - 1 || y == 0 || y == Board.getHeight() - 1) {
            for (Door door : doors.values()) {
                door.close();
            }
        } else {
            // doors facing the streets always opened
            if (x == 0) doors.get(DoorPosition.LEFT).open();
            if (x == Board.getWidth() - 1) doors.get(DoorPosition.RIGHT).open();
            if (y == 0) doors.get(DoorPosition.TOP).open();
            if (y == Board.getHeight() - 1) doors.get(DoorPosition.BOTTOM).open();
        }*/
        
    }
    
    /* Give a list of each door of the cell with their position
     * @return a Map<DoorPosition, Door>
     */
    public Map<DoorPosition, Door> getDoors() {
    	return this.doors;
    }
    
    /*
     * Display the cells' doors by showing whether or no their are open
     */
    public void displayDoors() {
    	Set<Map.Entry<DoorPosition, Door>> lesEntries = this.doors.entrySet();
    	Iterator<Map.Entry<DoorPosition, Door>> it_entry = lesEntries.iterator();
    	while(it_entry.hasNext()) {
    		Map.Entry<DoorPosition, Door> e = it_entry.next();
    		System.out.println(e.getKey()+": "+e.getValue().isOpen());
    	}
    }
    
    /* Give the position of the cell in the board
     * @return a string with the x-coordinate and y-coordinate of the cell
     */
    public String getPosition() {
    	String res=this.getX()+","+this.getY();
    	return res;
    }
    
    public Board getBoard() {
    	return this.board;
    }

    /**
     * Gets the x-coordinate of the cell.
     * @return The x-coordinate of the cell.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the y-coordinate of the cell.
     * @return The y-coordinate of the cell.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Gets the content of the cell.
     * @return The content of the cell.
     */
    public char getC(){
        return this.c;
    }

    /**
     * Sets the content of the cell.
     * @param c The content to set.
     */
    public void setchar(char c){
        this.c = c;
    }
    
    
    public void addEquipements(Equipment e) {
    	this.equipment.add(this.equipment.size(),e);
    }
    public void addSurvivors(Survivor e) {
    	this.survivors.add(this.survivors.size(),e);
    }
    
     
    public List<Survivor> getSurvivors(){
    	return survivors ;
    }
    
    public String getSurvivorsContent() {
    	String result="";
    	Iterator <Survivor> it= survivors.iterator();
    	while(it.hasNext()) {
    		Survivor ref= it.next();
    		result+=ref+" ";
    		}			
    	return result; 
    }
    public void addZombie(Zombie z) {
    	this.zombies.add(this.zombies.size(),z);
    }
    
    public List<Zombie> getZombies(){
    	return zombies ;
    }
    
    public boolean hasZombies(){
    	if(this.getZombies().isEmpty()) {
    		return false;
    	} else {
    		return true;
    	}
    }
    public boolean hasSurvivors(){
    	if(this.getSurvivors().isEmpty()) {
    		return false;
    	} else {
    		return true;
    	}
    }
    public String getZombiesContent() {
    	String result="";
    	Iterator <Zombie> it= zombies.iterator();
    	while(it.hasNext()) {
    		Zombie ref= it.next();
    		result+=ref+" , ";
    		}
    	return result;
    }
    // avec une liste
    public List<Equipment> getEquipements() {
        return equipment;
    }
    // Avec un iterateur
    public String getEquipementsContent() {
    	String result="";
    	Iterator <Equipment> it= equipment.iterator();
    	while(it.hasNext()) {
    		Equipment ref= it.next();
    		result+=ref+" , ";
    		}
    	return result;
    }
    
    public String toString2() {
        return "Cette case de coordonnées " + "(" + getX()+','+ getY() +") possède le(s) joueur(s): " + this.getSurvivorsContent();
    }
    
    public String toString() {
        return "Cette case de coordonnées " + "(" + getX()+','+ getY() +") possède le(s) joueur(s): " + this.getSurvivorsContent() 
        		+getZombiesContent() +'\n' +
         " .Ainsi que l'/les équipement(s): " + this.getEquipementsContent()+ " .";
    }
    
    public List<Actors> getActors(){
        return actors;
    }
    public void increaseSound() {
        this.noiseLevel++;
    }
    
    public int getnoiseLevel(){
		return noiseLevel;
	}
    
	public void setnoiseLevel(int noise){
		this.noiseLevel = noise;

	}
	public Door getDoor(DoorPosition position) {
        return doors.get(position);
    }

   
}
