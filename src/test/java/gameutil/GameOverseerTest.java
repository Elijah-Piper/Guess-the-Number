package gameutil;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class GameOverseerTest {

    @Test
    void scanForPlayerNameReturnsName() {
        String testNameStr = "Java-Aficionado";
        InputStream testName = new ByteArrayInputStream(testNameStr.getBytes());

        System.setIn(testName);
        GameOverseer game = new GameOverseer();

        assertEquals(testNameStr, game.getPlayerName());
    }

    @Test
    void scanForGuessReturnsGuess() {
        System.setIn(new ByteArrayInputStream("NAME".getBytes()));
        GameOverseer game = new GameOverseer();

        String testGuessStr = "10";
        InputStream testGuess = new ByteArrayInputStream(testGuessStr.getBytes());

        System.setIn(testGuess);

        assertEquals(10, game.scanForGuess());
    }

    @Test
    void numberIsBetweenOneAndTwenty() {
        for (int i = 0; i < 160; i++) {
            System.setIn(new ByteArrayInputStream("NAME".getBytes()));
            GameOverseer game = new GameOverseer();

            if (game.getNumber() < 1 || game.getNumber() > 20) fail("Number out of bounds");
        }
    }
}