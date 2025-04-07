 package board;

public class Door {
    private boolean isOpen;
    //private DoorPosition position;

    public Door() {
        this.isOpen = false;
        //this.position = position;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

	/*public DoorPosition getPosition() {
		return position;
	}*/
}