package board;
import actors.*;
import listchooser.*;
import java.util.*;

public class Round {
		
	private Board board;
	private int num_tour;
	private Phases phase;
	private List<String> nb;
	
	
	public Round(Board board) {
		this.board=board;
		this.num_tour= 0;
		this.phase=Phases.Phase_S;
		this.nb = new ArrayList<>();
		this.nb.add("un");
		this.nb.add("deux");
		this.nb.add("trois");
		this.nb.add("quatre");
	}

	
	public void initPlayers() {
		Scanner sc = new Scanner(System.in);
		int nbPlayers;
		do {
			
			System.out.println("Veuillez enter le nombre de joueurs(2 min.): ");
			nbPlayers=sc.nextInt();
			sc.nextLine();
		} while (nbPlayers==1 || nbPlayers==0);
        	for(int i=0; i<nbPlayers;i++) {
        		new Survivor(board,board.getMainCrossroad());
        		int roles;
            	do {
            		
            		System.out.println("Choisissez un rôle valable pour "+board.getListOfSurvivors().get(i).getName() +" entre (1:fighter, 2:healer, 3:scavenger, 4:lucky):");
            		roles=sc.nextInt();
            		sc.nextLine();
            	}while(roles==0 | roles>4);
            	switch (roles) {
            		case 1:
            			board.getListOfSurvivors().get(i).addRole(new FighterRole());
            			break;
            		case 2:
            			board.getListOfSurvivors().get(i).addRole(new HealerRole());
            			break;
            		case 3:
            			board.getListOfSurvivors().get(i).addRole(new ScavengerRole());
            			break;
            		case 4:
            			board.getListOfSurvivors().get(i).addRole(new LuckyRole());
            			break;
            	}
        	}
        	
        
        	sc.close();
        	System.out.println("Tous les joueurs ont été défini. Le jeu peut commencer !");
            System.out.println(board.getListOfSurvivors());
	}
	
	public void launch() {
		do {
			//Affichage tour
			this.num_tour+=1;
			System.out.print("[Début du "+this.num_tour+"er tour]");
			
			//phase survivants
			System.out.println("->C'est au tour des survivants");
			for(Survivor s: board.getListOfSurvivors()) {
				System.out.println("--A "+s.getName()+" de jouer !--");
				for(int i=1;i<s.getActionPoints();i++) {
					s.Do();
				}
				
			}
			
			//phase zombie
			System.out.println("->C'est au tour des zombies");
			for(Zombie z: board.getListOfZombies()) {
				System.out.println("--"+z.getName()+ " joue: --");
				//z.Do(); //-> à coder
			}
			
			//phase fin de tour
			System.out.println("[Fin du "+this.num_tour+"er tour]");
			this.board.setBoardNoiseToZero();
			this.board.generateZombie();
		
		} while(board.calculateAverageExperience()<30 || !(this.board.getListOfZombies().isEmpty()));
		
		
		
	}
	

	
	
}
