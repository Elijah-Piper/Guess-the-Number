import gameutil.GameOverseer;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {

        boolean playingGame = true;
        while (playingGame) {
            GameOverseer game = new GameOverseer();

            System.out.println("\nWell, %s, I am thinking of a number between 1 and 20.\nTake a guess.\n"
                    .formatted(game.getPlayerName()));

            while (game.getAttempts() <= 6) {
                int guess = game.scanForGuess();

                if (game.isCorrect(guess)) { // Correct guess is made
                    if (game.getAttempts() == 1) {
                        System.out.println("\nCongratulations, %s! You guess the number on your first try!\n"
                                .formatted(game.getPlayerName()));
                    } else {
                        System.out.println("\nCongratulations, %s! You guess the number in %d attempts!\n"
                                .formatted(game.getPlayerName(), game.getAttempts()));
                    }
                    break;
                } else { // Incorrect guess is made
                    if (game.getAttempts() > 6) { // Attempts exhausted = loss
                        System.out.println("Sorry, %s. You only had six guesses. You lose..."
                                .formatted(game.getPlayerName()));
                        break;
                    } else { // Attempts not exhausted; too high or too low?
                        System.out.println("\nYour guess is too %s.\nTake another guess.\n"
                                .formatted(guess < game.getNumber() ? "low" : "high"));
                    }
                }
                game.setAttempts(game.getAttempts() + 1); // Increments attempts by one; skipped if won or lost
            }

            // Post failure or completion of the game
            playingGame = game.wantToPlayAgain();

            if (!playingGame) { // I think this will prevent memory leaks. Maybe.
                Scanner sc = new Scanner(System.in);
                sc.close();
            }
        }
    }
}