import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {
    private BowlingGame soloBowlingGame;

    @BeforeEach
    public void setUp() {
        soloBowlingGame = new BowlingGame(1);
    }

    @Test
    public void testGutterGame() {
        rollMany(20, 0);

        assertEquals(0, soloBowlingGame.score(0));
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);

        assertEquals(20, soloBowlingGame.score(0));
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        soloBowlingGame.roll(3);
        rollMany(17, 0);

        assertEquals(16, soloBowlingGame.score(0));
    }

    @Test
    public void testOneStrike() {
        rollStrike();
        soloBowlingGame.roll(3);
        soloBowlingGame.roll(4);
        rollMany(16, 0);

        assertEquals(24, soloBowlingGame.score(0));
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);
        assertEquals(300, soloBowlingGame.score(0));
    }

    @Test
    public void testTwoPlayerBowlingGame() {
        BowlingGame bowlingGame = new BowlingGame(2);

        // player0 turn
        bowlingGame.roll(3);
        bowlingGame.roll(4);

        // player1 turn
        bowlingGame.roll(5);
        bowlingGame.roll(4);

        assertEquals(7, bowlingGame.score(0));
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            soloBowlingGame.roll(pins);
        }
    }

    private void rollStrike() {
        soloBowlingGame.roll(10);
    }

    private void rollSpare() {
        soloBowlingGame.roll(5);
        soloBowlingGame.roll(5);
    }
}