package actors;

import board.*;
import equipements.*;
import listchooser.InteractiveListChooser;
import listchooser.ListChooser;

import java.util.*;

import actions.*;

import static board.Board.generateRandomEquipement;

/**
 * Represents a survivor in the game.
 */
public class Survivor extends Actors {
    private int level;
    private Board board;
    private Cell cell;
    private Weapon weapon;
    private int experience;
    private HashSet<Role> roles;
    private HashSet<Equipment> backpack;
    private Equipment takeninhand;
    private int actionPoints;
    private List<Action> possibleActions;
    private List<Role> possibleRoles;
    //we created a variable of the zombies that were killed by the survivor so we could deal with the evaluation of the experience of each survivor
    private int zombiesKilled;
    private static int COUNTER = 1;
    private boolean pThreeIsAlreadyReach = false;
    private boolean pFourIsAlreadyReach = false;
    private boolean pElevenIsAlreadyReach = false;


    


    /**
     * Constructs a survivor with the specified starting cell and name.
     *
     * @param cell The starting cell of the survivor.
     * @param name The name of the survivor.
     */
    public Survivor(Board board, Cell cell) {
        super(5, cell, "");
        this.name="survivor"+(Survivor.COUNTER++);
        this.getCell().addSurvivors(this);
        this.board=board;
        board.getListOfSurvivors().add(this);
        this.level = 1;
        this.weapon = new Pistol();
        this.roles = new HashSet<>();
        this.backpack = new HashSet<>();
        this.experience = 0;
        this.takeninhand = new Pistol();
        this.actionPoints = 3;
        this.zombiesKilled = 0;
        
        this.possibleActions = new ArrayList<>();
        possibleActions.add(new Attack(this));
        possibleActions.add(new Move(this));
        possibleActions.add(new OpenDoor(this));
        possibleActions.add(new Heal(this));
        possibleActions.add(new TakeEquipement(this));
        possibleActions.add(new LookAround(this));
        possibleActions.add(new Search(this));
        
        this.possibleRoles = new ArrayList<>();
        possibleRoles.add(new FighterRole());
        possibleRoles.add(new HealerRole());
        possibleRoles.add(new ScavengerRole());
        possibleRoles.add(new LuckyRole());
        
    }
    
    public void Do() {
        ListChooser<Action> chooser = new InteractiveListChooser<>();
        Action a = chooser.choose("Quel action vous voulez executer ?", possibleActions);
        a.execute();
    }
    
    /*
     * Allow the survivor to move from his cell according to whether or not doors next to him are open
     */
    public Board getBoard() {
    	return this.board;
    }
    
   public HashSet<Equipment> getHashSetEquipment(){
	   return this.backpack;
   }
   
   public HashSet<Role> getHashSetRole(){
	   return this.roles;
   }
    	
    
    public void setCell(Cell cell) {
    	this.getCell().getSurvivors().remove(this);
    	super.cell= cell;
    	this.getCell().getSurvivors().add(this);
    }
    
    

    /**
     * Gets the level of the survivor.
     *
     * @return The level of the survivor.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the weapon of the survivor.
     *
     * @return The weapon of the survivor.
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Gets the experience of the survivor.
     *
     * @return The experience of the survivor.
     */
    public int getExperience() {
        return experience;
    }


    /**
     * Adds a role to the survivor.
     *
     * @param e The role to add.
     */
    public void addRole(Role e) {
    		this.roles.add(e);
            System.out.println(this.getName()+" est maintenant "+e.getRoleName());
    	}
        

    
    public void incrementExperience() {
    	this.experience += 1;
    	if(this.experience==3 && this.pThreeIsAlreadyReach==false) {
    		this.pThreeIsAlreadyReach=true;
    		System.out.print(this.getName()+"a gagné +1xp. "+this.getExperience());
    		System.out.println("Pt d'action:"+this.getActionPoints());
    	} else if (this.experience==7 && this.pFourIsAlreadyReach==false) {
    		System.out.print(this.getName()+"a gagné +1xp. "+this.getExperience());
    		System.out.println("Pt d'action:"+this.getActionPoints());
    	}else if(this.experience==11 && this.pElevenIsAlreadyReach==false) {
    		System.out.print(this.getName()+"a gagné +1xp. "+this.getExperience());
    		System.out.println("Pt d'action:"+this.getActionPoints());
    	}
    	
    }
    
    


    public void chooseRoles(){
    	Scanner sc= new Scanner(System.in);
    	int roles;
    	do {
    		System.out.println("Entrer un numéro valable (1:fighter, 2:healer, 3:scavenger, 4:lucky):");
    		roles=sc.nextInt();
    		sc.nextLine();
    	}while(0<roles  && roles<5);
    	switch (roles) {
    		case 1:
    			this.addRole(new FighterRole());
    			break;
    		case 2:
    			this.addRole(new HealerRole());
    			break;
    		case 3:
    			this.addRole(new ScavengerRole());
    			break;
    		case 4:
    			this.addRole(new LuckyRole());
    			break;
    	}
    	sc.close();
    }
    
    /**
     * Gets the roles of the survivor.
     *
     * @return The roles of the survivor.
     */
    public String getRole() {
        String result = "";
        for (Role role : this.roles) {
            result += " " + role.getRoleName() + " "; // Assuming Role class has getRoleName() method
        }
        return result;
    }

    /**
     * Adds an item to the survivor's backpack.
     *
     * @param item The item to add.
     */
    public void addToBackpack(Equipment item) {
        if (!hasFullBackpack()) {
            backpack.add(item);
        } else {
            System.out.println("Backpack is full !!!!!");
        }
    }

    /**
     * Removes an item from the survivor's backpack.
     *
     * @param item The item to remove.
     */
    public void removeFromBackpack(Equipment item) {
        backpack.remove(item); // Reste à gérer le choix de l'équipement que le survivant vas choisir de remplacer.
    }

    /**
     * Checks if the survivor has a specific item in the backpack.
     *
     * @param item The item to check for.
     * @return True if the item is in the backpack, false otherwise.
     */
    public boolean hasInBackpack(Equipment item) {
        return backpack.contains(item);
    }

    /**
     * Takes an item from the backpack and puts it in the survivor's hand.
     *
     * @param item The item to take in hand.
     */
    public void takeInHand(Equipment item) {
        if (backpack.contains(item)) {
            // check si il y'a déja un équipement en main.
            if (takeninhand != null) {
                // met l'équipement dans le sac à dos
                addToBackpack(takeninhand);
                System.out.println("On remet " + takeninhand.getName() + " dans le sac à dos ");
            }
            // Prend l'equipment en main
            takeninhand = item;
            removeFromBackpack(item);
            System.out.println("Pris en main: " + item.getName());
        } else {
            System.out.println(item.getName() + " ne figure pas dans le sac à dos ");
        }
    }
    public boolean hasEquipementInHand(){
        return takeninhand != null;
    }
    
    public boolean hasWeaponInHand() {
    	if((this.takeninhand !=null) & (this.takeninhand instanceof Weapon)) {
    		return true;
    	} 
    	return false;
    			
    }

    /**
     * Checks if the survivor's backpack is full.
     *
     * @return True if the backpack is full, false otherwise.
     */
    public boolean hasFullBackpack() {
        return backpack.size() >= 5;
    }

    /**
     * Gets the contents of the survivor's backpack.
     *
     * @return A string containing the contents of the backpack.
     */
    public String getBackpackContent() {
        String content = "";

        for (Equipment item : backpack) {
            content += item.getName() + ' ';
        }
        return content;
    }

    /**
     * Returns a string representation of the survivor.
     *
     * @return A string containing the survivor's name, roles, and backpack contents.
     */
    public String toString() {
    	String result="";
    	if(this.getHashSetEquipment().isEmpty() && this.getHashSetRole().isEmpty()) {
    		result = this.getName() + " (Role(s) : aucun, Contenu du sac à dos : vide)";
    	} else if(this.getHashSetEquipment().isEmpty()) {
    		result = this.getName() + " (Role(s) :" + this.getRole() + ", Contenu du sac à dos : vide)";
    	} else if(this.getHashSetRole().isEmpty()) {
    		result = this.getName() + " (Role(s) : aucun, Contenu du sac à dos : " + this.getBackpackContent() + ")";
    	} else {
    		result = this.getName() + " (Role(s) :" + this.getRole() + ", Contenu du sac à dos : " + this.getBackpackContent() + ")";
    	}
    	return result;
    }

    //in this part of the code we will try to focus on the way we'll be dealing with the survivors actions
    public void attackZombie(Zombie zombie) {
        int damageDealt = this.weapon.getDamage();
        zombie.takeDamage(damageDealt);
        if (zombie.getLifePoints() == 0)
            zombiesKilled++;
    }

    public void searchRoom() {
        if (!(this.cell instanceof Room)) {
            System.out.println("You are not in a room. Cannot search.");
            return;
        }

        Random random = new Random();
        int chanceToGetAnEquip = random.nextInt(101); // we are generating here an integer to calculate the

        if (chanceToGetAnEquip < 25) { // we'll discuss the chance needed more tomorrow
            Equipment foundEquipment = generateRandomEquipement();
            addToBackpack(foundEquipment);
        } else {
            System.out.println("Nothing found!");
        }
    }

    public void incrementLifePoints(int ammount) {
        lifePoints += ammount;
       
    }



    public Equipment equipmentInHand() {
        return this.takeninhand;
    }

    public void useEquipement() {
        if (takeninhand != null) {
            takeninhand.use(this);
        }
    }

    public List<Zombie> getZombieNearby() {
        List<Zombie> zombiesNearby = new ArrayList<>();
        int x = this.cell.getX();
        int y = this.cell.getY();
        int[] neighbourOffsests = {-1, 0, 1};
        for (int offsetX : neighbourOffsests) {
            for (int offsetY : neighbourOffsests) {
                if (offsetX == 0 && offsetY == 0) {
                    continue;
                }
                Cell c = this.board.getCell(x + offsetX, y + offsetY);
                zombiesNearby.addAll(c.getZombies());
            }
        }
        return zombiesNearby;
    }

    public List<Survivor> getSurvivorNearby() {
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
    public Map <String, Integer> getContentOfTheMap(Board board) {
        Map <String, Integer> cityInfo = new HashMap<>();
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                Cell cell = board.getCell(x, y);
                int numZombies = 0;
                int numSurvivors = 0;
                String coordinates = "(" + x + ", " + y + ")";

                List<Actors> actors = cell.getActors();
                for (Actors actor : actors) {
                    if (actor instanceof Zombie)
                        numZombies++;
                    else if (actor instanceof Survivor)
                        numSurvivors++;
                }
                cityInfo.put(coordinates, numZombies  + numSurvivors);
            }
        }
        return cityInfo;
    }
    public int getActionPoints() {
        return this.actionPoints;
    }
    public void setActionPoints(int nb) {
        this.actionPoints = nb;
    }
    
    
    
}
