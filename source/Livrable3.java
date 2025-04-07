import actors.*;
import board.*;
import equipements.*;
import exception.GameException;
import actions.*;

public class Livrable3 {
		
	public static void main(String[] args) throws GameException {
		Board board = new Board(5,5);
		board.printBoard();
		RunnersZ runner = new RunnersZ(board.getManhole(1),"zombie1");
        ToughZ tough = new ToughZ(board.getManhole(2), "zombie2");
        RunnersZ runner2 = new RunnersZ(board.getManhole(3),"zombie3");
        ToughZ tough2 = new ToughZ(board.getManhole(4), "zombie4");
        int x= Board.generateInt(0, 3);
        int y= Board.generateInt(0,3);
        Role fighter = new FighterRole();
        Role healer = new HealerRole();
        Role lucky = new LuckyRole();
        Role scavenger = new ScavengerRole();
        Survivor survivor1 = new Survivor(board,board.getCell(Board.generateInt(0, 3),Board.generateInt(0, 3)),"survivor1");
        survivor1.addRole(fighter);
        System.out.println(survivor1.getCell());
        
        Survivor survivor2 = new Survivor(board,board.getCell(Board.generateInt(0, 3),Board.generateInt(0, 3)),"survivor2");
        survivor2.addRole(healer);
        System.out.println(survivor2.getCell());
        
        Survivor survivor3 = new Survivor(board,board.getCell(Board.generateInt(0, 3),Board.generateInt(0, 3)),"survivor3");
        survivor3.addRole(lucky);
        System.out.println(survivor3.getCell());
        
        Survivor survivor4 = new Survivor(board,board.getCell(Board.generateInt(0, 3),Board.generateInt(0, 3)),"survivor4");
        survivor4.addRole(scavenger);
        System.out.println(survivor4.getCell());
        
        Axe axe = new Axe();
        HealingPotion potion = new HealingPotion();
        survivor2.addToBackpack(axe);
        survivor3.addToBackpack(potion);
        //TakeEquipement take = new TakeEquipement();
        //take.execute(survivor2);
        //take.execute(survivor3);
        
        //action survivant1
        System.out.println("-------Execution de l'action LookAround pour le survivor1------");
        LookAround look = new LookAround();
        look.execute(survivor1);
        
        //action survivant2
        
        //MakeNose noise= new MakeNose();   
        //noise.execute(survivor2);
        System.out.println("-------Execution de l'action Moove  pour le survivor3------");
        Move mv = new Move();
        mv.execute(runner2,DoorPosition.LEFT);
        
        System.out.println("-------Execution de l'action OpenDoor pour le survivor4------");
        //survivor4.openDoor(DoorPosition.RIGHT);
        
        OpenDoor od = new OpenDoor();
        od.execute(survivor4,DoorPosition.LEFT);
        System.out.println("-------Execution de l'action OpenDoor pour le survivor4------");
        
	}
}
