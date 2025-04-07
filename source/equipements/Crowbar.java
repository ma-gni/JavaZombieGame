package equipements;

public class Crowbar extends Weapon {
    public Crowbar() {
        super(4, 1, 0,"Crowbar");
    }
    public boolean canOpenDoor(){
		return true;
	}
    public boolean isNoisy() {
		return false;
	}
}