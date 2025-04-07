package board;

/**
 * Represents a street on the board.
 */
public class Street extends Cell {
    protected char street;

    /**
     * Constructs a new street at the specified coordinates.
     * @param x The x-coordinate of the street.
     * @param y The y-coordinate of the street.
     */
    public Street(Board board,int x, int y) {
        super(board,x, y);
        super.c = '*';
    }
}
