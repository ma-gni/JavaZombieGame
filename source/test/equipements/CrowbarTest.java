package test.equipements;
import actions.*;
import equipements.*;
import board.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrowbarTest {

    @Test
    public void testCrowbarConstructor() {
        Crowbar crowbar = new Crowbar();

        // Since Crowbar extends Weapon, we can use the getters from the Weapon class
        assertEquals(4, crowbar.getThreshold());
        assertEquals(1, crowbar.getDamage());
        assertEquals(0, crowbar.getRange());
    }

   
}
