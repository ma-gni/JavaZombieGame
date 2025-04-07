package test.actors;
import actors.*;
import board.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurvivorTest {

    @Test
    public void testSurvivorInitialization() {
        Role role = new Role("Warrior");
       
        Board b =new Board(5,5);
        Cell c = new Cell(b,5,5);
        Survivor survivor = new Survivor(b,c);

        assertEquals(5, survivor.getLifePoints());
        assertEquals(role, survivor.getRole());

    }
}
