package test.Board ;
import org.junit.Test;
import board.*;
import static org.junit.Assert.*;

public class DoorTest {


    @Test
    public void testOpenDoor() {
        Door door = new Door();
        assertFalse(door.isOpen());

        door.open();
        assertTrue(door.isOpen());
    }

    @Test
    public void testCloseDoor() {
        Door door = new Door();
        door.open();
        assertTrue(door.isOpen());

        door.close();
        assertFalse(door.isOpen());
    }

 
}
