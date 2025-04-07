package test.equipements;
import actions.*;
import equipements.*;
import board.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RifleTest {

    @Test
    public void testRifleConstructor() {
        Rifle rifle = new Rifle();

        // Since Rifle extends Weapon, we can use the getters from the Weapon class
        assertEquals(4, rifle.getThreshold());
        assertEquals(1, rifle.getDamage());
        assertEquals(3, rifle.getRange());
    }

   
}
