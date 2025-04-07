package test.equipements;
import actions.*;
import equipements.*;
import board.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponTest {

   

    @Test
    public void testGetters() {
        Weapon weapon = new Weapon(15, 25, 8,"moh");

        assertEquals(15, weapon.getThreshold());
        assertEquals(25, weapon.getDamage());
        assertEquals(8, weapon.getRange());
    }
}


