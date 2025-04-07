package equipements;

import actors.Survivor;

public class Weapon extends Equipment {
    private int threshold;
    private Weapon weapon;
    private int damage;
    private int range;
    private int rolleOfDice;
    
    public Weapon( int threshold, int damage, int range, String name) {
    	super(name);
        this.threshold = threshold;
        this.damage = damage;
        this.range = range;

    }


    public int getThreshold() {
        return threshold;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public String toString() {
        return  this.getName() + " a été crée et possède les caractéristiques suivantes : \n"+ "- Threshold: " + threshold + ", Damage: " + damage + ", Range: " + range;
    }


	@Override
	public void use(Survivor s) {
		// TODO Auto-generated method stub
		
	}

}
