package equipements;

import actors.Survivor;
import board.Board;

public class Map1 extends Equipment {
	protected Board board;

	public Map1() {
		super("Map");
	}

	@Override
	public void use(Survivor s) {
		s.getContentOfTheMap(board);
		
	}
	
	public boolean isNoisy() {
		return true;
	}
	

	
}
