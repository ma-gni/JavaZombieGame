package equipements;

public class Axe extends Weapon{
	public Axe() {
        super(4, 2, 0,"Axe");
    }
    public boolean canOpenDoor(){
		return true;
	}
    public boolean isNoisy() {
		return false;
	}
}
