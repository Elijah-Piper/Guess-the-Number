import gameutil.GameOverseer;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner mainScan = new Scanner(System.in);

        System.out.println("Hello! What is your name?\n");
        String name = mainScan.nextLine();

        GameOverseer game = new GameOverseer(name);

        boolean playingGame = true;

        do {
            System.out.println(String.format(
                    "\nWell, %s, I am thinking of a number between 1 and 20.\nTake a guess.\n", name));

            int firstGuess = mainScan.nextInt();
            game.guess(firstGuess);

            // Post failure or completion of the game
            System.out.println("Would you like to play again? (y or n)\n");
            Scanner newScan = new Scanner(System.in);
            char restart = newScan.nextLine().charAt(0);
            if (restart == 'n' || restart == 'N') {
                playingGame = false;
            } else if (restart != 'y' && restart != 'Y') {
                System.out.println("Unknown input detected... I'll assume you wanted to play again!");
                System.out.println(String.format("\tInput: %s", restart));
            }
        } while (playingGame);
    }
}