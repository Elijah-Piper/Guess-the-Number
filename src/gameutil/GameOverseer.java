package gameutil;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class GameOverseer {
    public int number;
    public int attempts;
    public int prevGuess;
    public String playerName;
    public Scanner scan;

    public GameOverseer(String name) {
        // Sets the random value between 1 and 20 for the player to guess
        this.number = ThreadLocalRandom.current().nextInt(1, 21);
        this.attempts = 1;
        // Prior to any attempt, prevAttempt will be 0
        this.prevGuess = 0;
        this.playerName = name;
        this.scan = new Scanner(System.in);
    }

    public boolean isCorrect(int num) {
        if (num == this.number) return true;
        else return false;
    }

    public String guess(int num) {
        do {
            if (this.prevGuess < this.number) {
                System.out.println("\nYour guess is too low.\nTake a guess.\n");
                System.out.println(
                        String.format("Attempts: %d, Number: %d", this.attempts, this.number)
                );
            } else if (this.prevGuess > this.number) {
                System.out.println("\nYour guess is too high.\nTake a guess.\n");
            }
            this.attempts++;
            this.prevGuess = this.scan.nextInt();
        } while (this.prevGuess != this.number && this.attempts < 6);
        if (this.attempts < 6) {
            this.prevGuess = 0;
            this.attempts = 1;
            this.number = ThreadLocalRandom.current().nextInt(1, 21);
            return String.format(
                    "\nGood job, %s! You guess my number in %d guesses!", this.playerName, this.attempts);
        } else {
            this.prevGuess = 0;
            this.attempts = 1;
            this.number = ThreadLocalRandom.current().nextInt(1, 21);
            return String.format(
                    "Sorry, %s, you only had six guesses...", this.playerName);
        }
    }
}
