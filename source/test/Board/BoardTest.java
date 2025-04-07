package test.Board;
import org.junit.jupiter.api.Test;


import board.*;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

 
	 public static void main(String[] args) {
	        testBoardCreation();
	        testMainCrossroad();
	        testEquipmentsPlacement();
	        testAverageExperienceCalculation();
	    }

	    private static void testBoardCreation() {
	        Board board = new Board(10, 10);
	        System.out.println("Board created successfully!");
	        System.out.println("Board height: " + board.getHeight());
	        System.out.println("Board width: " + board.getWidth());
	    }

	    private static void testMainCrossroad() {
	        Board board = new Board(10, 10);
	        board.setMainCrossroad();
	        Cell mainCrossroad = board.getMainCrossroad();
	        System.out.println("Main crossroad coordinates: (" + mainCrossroad.getX() + ", " + mainCrossroad.getY() + ")");
	    }

	    private static void testEquipmentsPlacement() {
	        Board board = new Board(10, 10);
	        board.setWeaponsNEquipment();
	        board.printBoard(); // Print board with equipments
	    }
	    
	    private static void testAverageExperienceCalculation() {
	        Board board = new Board(10, 10);
	        double averageExperience = board.calculateAverageExperience();
	        System.out.println("Average experience of survivors: " + averageExperience);
	    }

	   

}
