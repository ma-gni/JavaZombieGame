
import actors.*;
import board.*;
import actions.*;
import exception.*;

public class MainTest {

	public static void main(String[] args) throws GameException{
	    Board board = new Board(5,5);
	    board.printBoard(); 
	    Round round= new Round(board);
	    Survivor survivor1 = new Survivor(board,board.getMainCrossroad());
	    //round.GiveRolesToPlayers();
	   round.initPlayers();
	    //System.out.println(board.getListOfSurvivors().size());
	    /*board.printSurvivorOnEachCell();
	    Survivor survivor1 = new Survivor(board,board.getMainCrossroad());
	    Survivor survivor2 = new Survivor(board,board.getCell(2,2));
	    Zombie runner = new RunnersZ(board.getCell(0,1),"zombie1");
	    Zombie tough = new ToughZ(board.getManhole(2), "zombie2");
	    Zombie walker = new WalkersZ(board.getManhole(3),"zombie3");
	    Zombie tough2 = new ToughZ(board.getManhole(4), "zombie4");
	    
	    
	    Attack2 attack = new Attack2(survivor1);
	    // Exécutez l'action d'attaque sur un zombie spécifique pour tester
	    attack.execute(survivor1);
	    attack.execute(runner);
	    attack.execute(runner);
	    // Changez 'runner' en un autre zombie ou survivant selon le contexte

	        /*System.out.println(attack.x1(survivor2.getWeapon().getRange()));
	        System.out.println(attack.x2(survivor2.getWeapon().getRange()));
	        System.out.println(attack.y1(survivor2.getWeapon().getRange()));
	        System.out.println(attack.y2(survivor2.getWeapon().getRange()));*/
	        
			
			//Round round = new Round(board);
			//round.launch();
			
			
		}
}