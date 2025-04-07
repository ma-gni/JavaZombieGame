package main;
import actors.Survivor;
import board.*;
import actors.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java -jar jar/zombicide.jar <width> <height> <numSurvivors>");
            System.exit(1);
        }

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int numSurvivors = Integer.parseInt(args[2]);

        Board board = new Board(width, height);
        board.printBoard();
        Round round = new Round(board);

        Random random = new Random();
        Role[] roles = {new FighterRole(), new HealerRole(), new LuckyRole(), new ScavengerRole()};

        for (int i = 0; i < numSurvivors; i++) {
            Survivor survivor = new Survivor(board, board.getMainCrossroad());
            Role chosenRole = roles[random.nextInt(roles.length)]; 
            survivor.addRole(chosenRole);
        }
        round.launch();
    }
}
