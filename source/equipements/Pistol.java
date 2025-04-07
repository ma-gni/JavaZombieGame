package equipements;

public class Pistol extends Weapon {
    public Pistol() {
        super(4, 1, 1,"pistol");
    }
    public boolean canOpenDoor(){
		return true;
	}
    
    public boolean isNoisy() {
		return true;
	}
    
}