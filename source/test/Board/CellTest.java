package test.Board;
import board.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class CellTest {
	Board b = new Board(5,5);

    @Test
    public void testCellInitialization() {
        Cell cell = new Cell(b,1, 2);

        assertEquals(1, cell.getX());
        assertEquals(2, cell.getY());

    }

    @Test
    public void testSetContent() {
        Cell cell = new Cell(b,1, 2);
        cell.setchar('X');

        assertEquals('X', cell.getC());
    }

}
