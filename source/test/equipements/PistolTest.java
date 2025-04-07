package test.equipements;
import actions.*;
import equipements.*;
import board.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PistolTest {

    @Test
    public void testPistolConstructor() {
        Pistol pistol = new Pistol();

        // Since Pistol extends Weapon, we can use the getters from the Weapon class
        assertEquals(4, pistol.getThreshold());
        assertEquals(1, pistol.getDamage());
        assertEquals(1, pistol.getRange());
    }

    
}
