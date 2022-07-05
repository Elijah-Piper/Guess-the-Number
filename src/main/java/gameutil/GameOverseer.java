package gameutil;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class GameOverseer {
    private int number;
    private int attempts;
    private final String playerName;

    public GameOverseer() {
        // Sets the random value between 1 and 20 for the player to guess
        this.number = ThreadLocalRandom.current().nextInt(1, 21);
        this.attempts = 1;
        this.playerName = scanForPlayerName();
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int n) {
        this.number = n;
    }
    public int getAttempts() {
        return attempts;
    }
    public void setAttempts(int n) {
        this.attempts = n;
    }
    public String getPlayerName() {
        return playerName;
    }

    private static String scanForPlayerName() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nHello, what is your name?\n");

        String name = "";
        while (name.isBlank()) {
            try {
                name = sc.nextLine();
            } catch (Exception e) {
                System.out.println("\tretrievePlayerName failed with exception: " + e);
            }
            if (name.isBlank()) System.out.println("\nNo name was detected... What is your name?\n");
        }

        return name;
    }

    public int scanForGuess() {
        Scanner sc = new Scanner(System.in);

        int guess = Integer.MIN_VALUE;
        while (guess < 1 || guess > 20) {
            try {
                guess = sc.nextInt();
                if (guess < 1 || guess > 20) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nInvalid input detected... Please enter a number between 1 and 20.\n");
                sc.next();
            }
        }

        return guess;
    }

    public boolean isCorrect(int num) {
        return num == number;
    }

    public boolean wantToPlayAgain() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWould you like to play again? (y or n)\n");

        while (true) {
            try {
                String line = sc.nextLine();
                if (line.equals("y") || line.equals("Y")) return true;
                else if (line.equals("n") || line.equals("N")) return false;
                else throw new Exception();
            } catch (Exception e) {
                System.out.println("\nInvalid input detected. Please input (y) or (n).");
            }
        }
    }
}

