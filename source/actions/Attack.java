/**
 * The Attack class represents an action where a Survivor attacks a Zombie or a Zombie attacks a Survivor.
 * It includes methods to determine targets within the weapon range and execute the attack.
 */
package actions;
import actors.*;
import actors.Survivor;
import java.util.*;
import board.*;
import equipements.*;
import listchooser.InteractiveListChooser;
import listchooser.ListChooser;
import listchooser.RandomListChooser;

public class Attack extends Action {
	//fields
	private Actors actor;
	private String name;
	private Survivor survivor;
	/**
	 * Constructor for creating an Attack object associated with an actor (Survivor or Zombie).
	 *
	 * @param actor The actor (Survivor or Zombie) performing the attack.
	 */
	public Attack(Actors actor) {
        super(actor);
        this.actor = actor;
        this.name = "attaquer";
        if (actor instanceof Survivor) {
            this.survivor = (Survivor) actor;
        }
    }
	/**
	 * Retrieves a string representation of the attack.
	 *
	 * @return A string representing the attack.
	 */
	public String toString() {
		return this.name;
	}
	// Helper methods for calculating weapon range
	public int x1(int r) {
		if(this.survivor.getCell().getX()-r < 0) {
			return 0;
		} else {
			return this.survivor.getCell().getX()-r;
		}		
	}
	// Helper methods for calculating weapon range
	public int x2(int r) {
		if(this.survivor.getCell().getX()+r > this.survivor.getBoard().getWidth()-1) {
			return this.survivor.getBoard().getWidth()-1;
		} else {
			return this.survivor.getCell().getX()+r;
		}		
	}
	
	public int y1(int r) {
		if(this.survivor.getCell().getY()-r < 0) {
			return 0;
		} else {
			return this.survivor.getCell().getY()-r;
		}
	}
	
	public int y2(int r) {
		if(this.survivor.getCell().getY()+ r > this.survivor.getBoard().getHeight()-1) {
			return this.survivor.getBoard().getWidth()-1;
		} else {
			return this.survivor.getCell().getY()+r;
		}
	}


	/**
	 * Retrieves a list of Zombies within the weapon range of the Survivor.
	 *
	 * @return An ArrayList of Zombies within the weapon range.
	 */
	public ArrayList<Zombie> ListZombieInWeaponRange() {
			ArrayList <Zombie> zombieList = new ArrayList<>();
			if(this.survivor !=null) {
				Weapon weapon=  (Weapon) this.survivor.equipmentInHand();
				int r= weapon.getRange();
				Cell c=this.survivor.getCell();
				if (c.hasZombies()) {
					zombieList.addAll(c.getZombies());
				}
				for(int a1=this.x1(r);a1<c.getX();a1++){
					if (this.survivor.getBoard().getCell(a1, c.getY()).hasZombies()) {
						zombieList.addAll(this.survivor.getBoard().getCell(a1, c.getY()).getZombies());
					} 
				}
				for(int a2=c.getX()+1;a2<=this.x2(r);a2++) {
					if (this.survivor.getBoard().getCell(a2, c.getY()).hasZombies()) {
						zombieList.addAll(this.survivor.getBoard().getCell(a2, c.getY()).getZombies());
					}
				}
				for(int b1=this.y1(r);b1<c.getY();b1++) {
					if(this.survivor.getBoard().getCell(c.getX(),b1).hasZombies()){
						zombieList.addAll(this.survivor.getBoard().getCell(c.getX(),b1).getZombies());
					}
				}
				for(int b2=c.getY()+1;b2<=this.y2(r);b2++) {
					if(this.survivor.getBoard().getCell(c.getX(),b2).hasZombies()) {
						zombieList.addAll(this.survivor.getBoard().getCell(c.getX(),b2).getZombies());
					}
				}
			}
			
			return zombieList;
	}


	/**
	 * Retrieves a list of Survivors within the weapon range of the Survivor.
	 *
	 * @return An ArrayList of Survivors within the weapon range.
	 */
	public ArrayList<Survivor> ListSurvivorsInWeaponRange() {
	    ArrayList<Survivor> survivorList = new ArrayList<>();
	    if (this.survivor != null) {
	    	Weapon weapon = (Weapon) this.survivor.equipmentInHand();
	    	int r = weapon.getRange();
	    	Cell c = this.actor.getCell();
	    	if (c.hasSurvivors()) {
	    		survivorList.addAll(c.getSurvivors());
	    	}
	    	
	    	// Ajoutez les survivants dans les cellules adjacentes dans les limites de la portée de l'arme
	    	for (int a1 = this.x1(r); a1 <= this.x2(r); a1++) {
	    		for (int b1 = this.y1(r); b1 <= this.y2(r); b1++) {
	    			Cell adjacentCell = this.actor.getBoard().getCell(a1, b1);
	    			if (adjacentCell.hasSurvivors()) {
	    				survivorList.addAll(adjacentCell.getSurvivors());
	    			}
	    		}
	    	}
	    	
	    	return survivorList;
	    }
	    return survivorList;	
	}

	/**
	 * Simulates rolling a six-sided dice.
	 *
	 * @return The result of the dice roll.
	 */
	public  int rollDice() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}


	/**
	 * Executes the attack action based on the specified actor (Survivor or Zombie).
	 *
	 * @param actor The actor performing the attack.
	 */
	public void execute(Actors actor) {
	    if (actor instanceof Zombie) {
	        Zombie zombie = (Zombie) actor;
	        List<Survivor> survivorsInRange = ListSurvivorsInWeaponRange();
	        if (!survivorsInRange.isEmpty()) {
	            ListChooser<Survivor> chooser = new RandomListChooser<>();
	            Survivor targetSurvivor = chooser.choose("Le zombie vas choisir d'attaquer un survivant", survivorsInRange);
	            if (targetSurvivor != null) {
	            	int newHealth = targetSurvivor.getLifePoints() - zombie.getDamage();
		            targetSurvivor.setLifePoints(newHealth);
	                System.out.println(zombie.getName() + " attacks " + targetSurvivor.getName());
	                if (targetSurvivor.getLifePoints() <= 0) {
	                    targetSurvivor.getCell().getSurvivors().remove(targetSurvivor);
	                    System.out.println(targetSurvivor.getName() + " has been killed by " + zombie.getName());
	                }
	            } else {
	                System.out.println("Aucun survivant à portée pour attaquer.");
	            }
	        } else {
	            System.out.println("Aucun survivant à portée pour attaquer.");
	        }
	    } else if (actor instanceof Survivor) {
	        Survivor survivor = (Survivor) actor;
	        List<Zombie> zombiesInRange = ListZombieInWeaponRange();
	        if (!zombiesInRange.isEmpty()) {
	            ListChooser<Zombie> chooser = new InteractiveListChooser<>();
	            Zombie targetZombie = chooser.choose("Quel zombie voulez-vous tuer ?", zombiesInRange);
	            if (targetZombie != null) {
	                Weapon weapon = survivor.getWeapon();
	                int threshold = weapon.getThreshold();
	                int range = weapon.getRange();
	                int damage = weapon.getDamage();
	                int diceRoll = rollDice();

	                if (targetZombie.differenceBetweenTwoActors(survivor) <= range && diceRoll >= threshold) {
	                    targetZombie.takeDamage(damage);
	                    System.out.println(survivor.getName() + " attacks " + targetZombie.getName());
	                    if (targetZombie.getLifePoints() <= 0) {
	                        targetZombie.getCell().getZombies().remove(targetZombie);
	                        System.out.println(targetZombie.getName() + " has been killed by " + survivor.getName());
	                    }
	                }
	            } else {
	                System.out.println("Aucun zombie à portée pour attaquer.");
	            }
	        } else {
	            System.out.println("Aucun zombie à portée pour attaquer.");
	        }
	    } else {
	        System.out.println("Type d'acteur non pris en charge.");
	    }
	}


}
