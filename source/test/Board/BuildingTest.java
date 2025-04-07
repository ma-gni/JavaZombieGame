package test.Board;
import board.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class BuildingTest {

    @Test
    public void testBuildingInitialization() {
        Building building = new Building();

        assertNotNull(building.getRooms());
        assertTrue(building.getRooms().isEmpty());
    }

}