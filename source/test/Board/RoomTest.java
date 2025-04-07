package test.Board;

import board.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;



public class RoomTest {
	Board b =new Board(5,5);
    @Test
    public void testRoomInitialization() {
        Room room = new Room(b,1, 2);

        assertEquals(1, room.getX());
        assertEquals(2, room.getY());
    }
}
