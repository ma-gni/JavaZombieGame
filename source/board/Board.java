package board;
import actors.*;
import equipements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a board composed of cells, including rooms and streets.
 */
public class Board {
    private static int height;
    private static int width;
    private Cell[][] board;
    private Door[][] HorizontalDoors;
    private Door[][] VerticalDoors;
    private ArrayList<Cell> boardLeftEdgeCells;
    private ArrayList<Cell> boardTopEdgeCells;
    private ArrayList<Cell> boardRightEdgeCells;
    private ArrayList<Cell> boardBottomEdgeCells;
    private Cell TopLeftCorner;
    private Cell TopRightCorner;
    private Cell BottomLeftCorner;
    private Cell BottomRightCorner;
    private boolean isMainCrossroadSet;
    private Cell MainCrossroad;
    private Cell Manhole1;
    private Cell Manhole2;
    private Cell Manhole3;
    private Cell Manhole4;
    private ArrayList<Survivor> listSurvivors;
    private ArrayList<Zombie> listZombies;

    /**
     * Constructs a board with the specified width and height.
     * @param width The width of the board.
     * @param height The height of the board.
     */
    public Board(int width, int height) {
        Board.width = width;
        Board.height = height;
        this.listSurvivors= new ArrayList<Survivor>();
        
        //Creation for each door of the board
        this.HorizontalDoors = new Door[width][height-1];
        this.VerticalDoors = new Door[width-1][height];
        
        //Initialized each horizontal door of the board
        for(int i=0;i<=width-1;i++) {
        	for(int j=0;j<=height-2;j++) {
        		this.HorizontalDoors[i][j] = new Door();
        	}
        }
        //Initialized each vertical door of the board
        for(int i=0;i<=width-2;i++) {
        	for(int j=0;j<=height-1;j++) {
        		this.VerticalDoors[i][j] = new Door();
        	}
        }
        //Creation of edges categories;
        this.boardLeftEdgeCells= new ArrayList<Cell>();
        this.boardTopEdgeCells= new ArrayList<Cell>();
        this.boardRightEdgeCells= new ArrayList<Cell>();
        this.boardBottomEdgeCells= new ArrayList<Cell>();
        
        this.isMainCrossroadSet= false;
        this.board = new Cell[width][height];
        for(int i = 0; i < Board.width; i++) {
            for(int j = 0; j < Board.height; j++) {
                this.board[i][j] = new Room(this,i, j);
                this.board[i][j].setchar('R');
            }
        }
        
        this.initializeBoard();
        
        //Adding each cells to their corresponding edge categories
        for(int j=1; j<Board.height-1; j ++) {
        	this.boardLeftEdgeCells.add(this.board[0][j]);
        }
        for(int j=1; j<Board.height-1; j ++) {
        	this.boardRightEdgeCells.add(this.board[Board.width-1][j]);
        }
        for(int i=1; i<Board.width-1; i++) {
        	this.boardTopEdgeCells.add(this.board[i][0]);
        }
        for(int i=1; i<Board.width-1; i++) {
        	this.boardBottomEdgeCells.add(this.board[i][Board.height-1]);
        }
        //Associating cells to board's corner;
        this.TopLeftCorner=this.board[0][0];
        this.BottomLeftCorner=this.board[0][Board.height-1];
        this.TopRightCorner=this.board[Board.width-1][0];
        this.BottomRightCorner=this.board[Board.width-1][Board.height-1];
        
        //Associating doors to board's cells;
        this.associateDoor();
    }
    
    /* Give the board horizontal door at the coordinates x,y
     * @return the board horizontal door at the coordinates x,y
     */
    public Door getHorizontalDoor(int x,int y) {
    	return this.HorizontalDoors[x][y];
    }
    
    /* Give the board vertical door at the coordinates x,y
     * @return the board vertical door at the coordinates x,y
     */
    public Door getVerticalDoor(int x,int y) {
    	return this.HorizontalDoors[x][y];
    }
 
    /*
     * Associate each doors of the board (with their position) to the board's cells
     */
    public void associateDoor() {
    	for(int i=0;i<Board.width;i++) {
    		for(int j=0;j<Board.height;j++) {
    			if (this.board[i][j]==this.TopLeftCorner) {
    				this.board[i][j].getDoors().put(DoorPosition.RIGHT,this.VerticalDoors[0][0]);
    				this.board[i][j].getDoors().put(DoorPosition.BOTTOM,this.HorizontalDoors[0][0]);
    			}else if (this.board[i][j]==this.BottomLeftCorner) {
    				this.board[i][j].getDoors().put(DoorPosition.TOP,this.HorizontalDoors[0][j-1]);
    				this.board[i][j].getDoors().put(DoorPosition.RIGHT,this.VerticalDoors[0][j]);
    			}else if(this.board[i][j]==this.TopRightCorner) {
    				this.board[i][j].getDoors().put(DoorPosition.LEFT,this.VerticalDoors[i-1][0]);
    				this.board[i][j].getDoors().put(DoorPosition.BOTTOM, this.HorizontalDoors[i][0]);
    			}else if (this.board[i][j]==this.BottomRightCorner) {
    				this.board[i][j].getDoors().put(DoorPosition.TOP, this.HorizontalDoors[i][j-1]);
    				this.board[i][j].getDoors().put(DoorPosition.LEFT,this.VerticalDoors[i-1][j]);
    			}else if (this.boardLeftEdgeCells.contains(this.board[i][j])) {
    				this.board[i][j].getDoors().put(DoorPosition.TOP,this.HorizontalDoors[i][j-1]);
    				this.board[i][j].getDoors().put(DoorPosition.RIGHT,this.VerticalDoors[i][j]);
    				this.board[i][j].getDoors().put(DoorPosition.BOTTOM, this.HorizontalDoors[i][j]);
    			}else if (this.boardRightEdgeCells.contains(this.board[i][j])) {
    				this.board[i][j].getDoors().put(DoorPosition.LEFT,this.VerticalDoors[i-1][j]);
    				this.board[i][j].getDoors().put(DoorPosition.TOP,this.HorizontalDoors[i][j-1]);
    				this.board[i][j].getDoors().put(DoorPosition.BOTTOM, this.HorizontalDoors[i][j]);
    			}else if (this.boardTopEdgeCells.contains(this.board[i][j])) {
    				this.board[i][j].getDoors().put(DoorPosition.LEFT,this.VerticalDoors[i-1][j]);
    				this.board[i][j].getDoors().put(DoorPosition.RIGHT,this.VerticalDoors[i][j]);
    				this.board[i][j].getDoors().put(DoorPosition.BOTTOM, this.HorizontalDoors[i][j]);
    			}else if (this.boardBottomEdgeCells.contains(this.board[i][j])) {
    				this.board[i][j].getDoors().put(DoorPosition.LEFT,this.VerticalDoors[i-1][j]);
    				this.board[i][j].getDoors().put(DoorPosition.TOP,this.HorizontalDoors[i][j-1]);
    				this.board[i][j].getDoors().put(DoorPosition.RIGHT,this.VerticalDoors[i][j]);
    			} else {
    				this.board[i][j].getDoors().put(DoorPosition.LEFT,this.VerticalDoors[i-1][j]);
    				this.board[i][j].getDoors().put(DoorPosition.TOP,this.HorizontalDoors[i][j-1]);
    				this.board[i][j].getDoors().put(DoorPosition.RIGHT,this.VerticalDoors[i][j]);
    				this.board[i][j].getDoors().put(DoorPosition.BOTTOM, this.HorizontalDoors[i][j]);
    			}
    			
    		}
    	}
    }
    
    
    /*Give the c-th Board's manhole cover
     * @return the c-th mahhole cover 
     */
    public Cell getManhole(int c) {
    	switch (c){
    	case 1: return this.Manhole1;
    	case 2: return this.Manhole2;
    	case 3: return this.Manhole3;
    	case 4: return this.Manhole4;
    	default: 
    		return null;
    	
    	}
    }
    

    /**
     * Gets the height of the board.
     * @return The height of the board.
     */
    public static int getHeight() {
        return height;
    }

    /**
     * Gets the width of the board.
     * @return The width of the board.
     */
    public static int getWidth() {
        return width;
    }

    /**
     * Gets the total number of cells on the board.
     * @return The total number of cells on the board.
     */
    public int getNumberOfCells() {
        return width * height;
    }

    /**
     * Gets the cell at the specified coordinates.
     * @param x The x-coordinate of the cell.
     * @param y The y-coordinate of the cell.
     * @return The cell at the specified coordinates.
     */
    public Cell getCell(int x, int y) {
        return this.board[x][y];
    }
    /*
     * Tells if main crossroad is already set or not
     * @return boolean
     */
    public boolean setMainCrossroad() {
    	return this.isMainCrossroadSet=true;
    }
    
    /* Give the main crossroad cell of the board
     * @return the board's main crossroad
     */
    public Cell getMainCrossroad() {
    	return this.MainCrossroad;
    }
    
    /* Give a list of cells from the board's left edge
     * @return the list of cells from the board's left edge
     */
    public ArrayList<Cell> getBoardLeftEdgeCells(){
    	return this.boardLeftEdgeCells;
    }
    
    /* Give a list of cells from the board's right edge
     * @return the list of cells from the board's right edge
     */
    public ArrayList<Cell> getBoardRightEdgeCells(){
    	return this.boardRightEdgeCells;
    }
    
    /* Give a list of cells from the board's top edge
     * @return the list of cells from the board's top edge
     */
    public ArrayList<Cell> getBoardTopEdgeCells(){
    	return this.boardTopEdgeCells;
    }
    
    /* Give a list of cells from the board's bottom edge
     * @return the list of cells from the board's bottom edge
     */
    public ArrayList<Cell> getBoardBottomEdgeCells(){
    	return this.boardBottomEdgeCells;
    }
   

    /**
     * Generates a random integer between the specified bounds.
     * @param borneInf The lower bound of the range (inclusive).
     * @param borneSup The upper bound of the range (exclusive).
     * @return A random integer between the specified bounds.
     */
    public static int  generateInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }
    

    /**
     * Creates a board recursively, filling it with streets and rooms.
     * @param x1 The starting x-coordinate of the board.
     * @param y1 The starting y-coordinate of the board.
     * @param x2 The ending x-coordinate of the board.
     * @param y2 The ending y-coordinate of the board.
     */
    public void createBoard(int x1, int y1, int x2, int y2){
        if (x2 - x1 >= 4 && y2 - y1 >= 4){
            int a = generateInt(x1 + 2, x2 - 1);
            int b = generateInt(y1 + 2, y2 - 1);
            this.board[a][b] = new Street(this,a, b); // Create a Street cell
            for (int i = x1; i <= x2; i++) {
                    this.board[i][b] = new Street(this,i, b);
                    for(int c=x1;c<x2;c++) {
                    	this.VerticalDoors[c][b] = new Door();
                    	this.VerticalDoors[c][b].open();
                    }
            }
            for (int j = y1; j <= y2; j++) {
                    this.board[a][j] = new Street(this,a, j);
                    for(int d=y1;d<y2;d++) {
                    	this.HorizontalDoors[a][d] = new Door();
                    	this.HorizontalDoors[a][d].open();
                    }
            }
            if(this.isMainCrossroadSet==false){
            	this.setMainCrossroad();
            	this.MainCrossroad = this.board[a][b];
            	this.board[x1][b]= new Manhole(this,x1,b);
            	this.Manhole1= this.board[x1][b];
            	this.board[x2][b]= new Manhole(this,x2,b);
            	this.Manhole2=this.board[x2][b];
            	this.board[a][y1]= new Manhole(this,a,y1);
            	this.Manhole3=this.board[a][y1];
            	this.board[a][y2]= new Manhole(this,a,y2);
            	this.Manhole4=this.board[a][y2];
            }
            // Recursively create streets in each quadrant
            createBoard(x1, y1, a - 1, b - 1);
            createBoard(a + 1, y1, x2, b - 1);
            createBoard(a + 1, b + 1, x2, y2);
            createBoard(x1, b + 1, a - 1, y2);
        } else if(x2-x1>=4){
    		int a= generateInt(x1+2,x2-1);
    		for(int j=y1;j<=y2; j++){
                this.board[a][j]= new Street(this,a,j);
                for(int d=y1;d<y2;d++) {
                	this.HorizontalDoors[a][d].open();
                }              
    		}
    		this.createBoard(x1, y1, a-1, y2);
    		this.createBoard(a+1, y1, x2, y2);
    		
    	} else if(y2-y1>=4) {
    		int b= generateInt(y1+2,y2-1);
    		for(int i=x1;i<=x2;i++){
                this.board[i][b]= new Street(this,i,b);
                for(int c=x1;c<x2;c++) {
                	this.VerticalDoors[c][b].open();
                }
    		}
    		this.createBoard(x1, y1, x2, b-1);
    		this.createBoard(x1,b+1,x2,y2);
    	}
    }
    
    /*
     * Initialize the board
     */
    public void initializeBoard() {
    	this.createBoard(0, 0, this.width - 1, this.height - 1);
    	//this.associateDoor();
    	this.setContinental();
    	this.setPharmacie();
    	this.setWeaponsNEquipment();
    }
    
    /*
     * Set the pharmacy in a random board's cell;
     */
    public void setPharmacie(){
    	int c = generateInt(0, this.getWidth());
        int d = generateInt(0, this.getHeight());
		while (!(this.board[c][d] instanceof Room) | (this.board[c][d] instanceof Continental)) {
        	 c = generateInt(0, this.getWidth());
             d = generateInt(0, this.getHeight());
        }
		this.board[c][d]= new Pharmacie(this,c,d);
    }
    
    /*
     * Set the continental in a random board's cell;
     */
    public void setContinental(){
    	int c = generateInt(0, this.getWidth());
        int d = generateInt(0, this.getHeight());
		while (!(this.board[c][d] instanceof Room) | (this.board[c][d] instanceof Pharmacie)) {
        	 c = generateInt(0, this.getWidth());
             d = generateInt(0, this.getHeight());
        }
		this.board[c][d]= new Continental(this,c,d);
    }
    
    

    /**
     * Prints the board, displaying cells as either rooms,streets, manhole cover or main crossroad.
     */
    public void printBoard(){
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                    System.out.print("| " + this.board[i][j].getC() + " ");
                }
            System.out.println("|");
            }
    }
    
    public ArrayList<Survivor> getListOfSurvivors(){
    	return this.listSurvivors;
    	
    }
    
    public void printSurvivorOnEachCell() {
    	for(int i=0;i<this.getWidth();i++) {
    		for(int j=0;j<this.getHeight();j++) {
    			if(!((this.getCell(i,j).getSurvivors().isEmpty()))) {
    				System.out.println(this.getCell(i, j).toString2());
    			}
    		}
    	}
    }

    //in this part of the code we will be creating the method that will be adding weapons to the map randomly
    //first Method is the method that would be picking a weapon and equipment randomly
    public static Equipment generateRandomEquipement() {
    	Equipment[] possibleEquipments = {new FirstAidKit(),new Axe(),new Pistol(), new Rifle(), new Crowbar(), new ChainSaw(),
    	new HealingPotion(), new InfraredGlasses(),new Map1(),new MasterKey()};
    	Random random = new Random();
    	return possibleEquipments[generateInt(0,4)];
    }
    //the second method consists on the setting these equipment on the board
    public void setWeaponsNEquipment() {
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                Cell cell = this.board[i][j];
                // Check for specific cell types
                if (cell instanceof Room || cell instanceof Continental || cell instanceof Pharmacie) {
                    int numberOfEquipments = generateInt(1, 3);
                    for (int k = 0; k < numberOfEquipments; k++) {
                        cell.getEquipements().add(generateRandomEquipement());
                    }
                }
            }
        }
    }

    // méthode qui consiste à calculer la moyenne des expérience de tous les survivants présents
    public double calculateAverageExperience() {
        double totalExperience = 0;
        int totalSurvivors = 0;

        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                for (Survivor survivor : board[i][j].getSurvivors()) {
                    totalExperience += survivor.getExperience();
                    totalSurvivors++;
                }
            }
        }
        return totalExperience / totalSurvivors;
    }
    
    /* Choose a random board's manhole cover
     * @return a random board's manhole cover
     */
    public Cell choose_ManholeCover() {
    	List<Cell> choose_Cell = new ArrayList<>();
    	choose_Cell.add(Manhole1);
    	choose_Cell.add(Manhole2);
    	choose_Cell.add(Manhole3);
    	choose_Cell.add(Manhole4);
    	int c= generateInt(0,4);
    	return choose_Cell.get(c);
    	
    }
    
    /*
     * Generate zombies on the board's manhole cover.
     */
    public void generateZombie() {
    	int i= (int) Math.ceil((this.calculateAverageExperience())/3);
    	Zombie[] zombies = new Zombie[i];
    	for(int j=0; j<i+1;j++) {
    		int c= generateInt(0,5);
    		Cell s= this.choose_ManholeCover();
    		switch(c) {
    		  case 0:
    		     zombies[i] = new AbominationZ(s,"zombie"+(i+1));
    		    break;
    		  case 1:
    			  zombies[i] = new RunnersZ(s,"zombie"+(i+1));
    		    break;
    		  case 2:
    			  zombies[i] = new ToughZ(s,"zombie"+(i+1));
      		    break;
    		  case 3:
    			  zombies[i] = new WalkersZ(s,"zombie"+(i+1));
      		    break;
    		  case 4:
    			  zombies[i] = new WalkersZ(s,"zombie"+(i+1));
      		    break;
    		  default:
    		    // code block
    		}
    	}
    }
    public Cell getNoisiestZone() {
        Cell cell = this.getCell(0,0);
        for(int i=0;i<this.getWidth();i++) {
            for (int j=0;j<this.getHeight();j++) {
                if (cell.getnoiseLevel() < this.getCell(i,j).getnoiseLevel()){
                    cell = this.getCell(i,j);
                }
            }
        }
        if (cell.getnoiseLevel()==0){
            return null;
        }
        return cell;
    }
    
    public ArrayList<Zombie> getListOfZombies(){
    	return this.listZombies;
    }
    
    public void setBoardNoiseToZero() {
    	for(int i=0;i<this.getWidth();i++) {
            for (int j=0;j<this.getHeight();j++) {
                this.board[i][j].setnoiseLevel(0);
                }
    	}
    
    }
    
   }


