package equipements;

public class Rifle extends Weapon {
    public Rifle() {
        super(4, 1, 3,"rifle");
    }
    
    public boolean isNoisy() {
		return false;
	}

}
