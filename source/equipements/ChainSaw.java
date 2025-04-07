package equipements;

public class ChainSaw extends Weapon {
    public ChainSaw() {
        super(5, 3, 0,"ChainSaw");
    }
    public boolean canOpenDoor(){
		return true;
	}
}