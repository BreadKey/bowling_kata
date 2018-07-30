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
        rollMany(soloBowlingGame,20, 0);

        assertEquals(0, soloBowlingGame.score(0));
    }

    @Test
    public void testAllOnes() {
        rollMany(soloBowlingGame,20, 1);

        assertEquals(20, soloBowlingGame.score(0));
    }

    @Test
    public void testOneSpare() {
        rollSpare(soloBowlingGame);
        soloBowlingGame.roll(3);
        rollMany(soloBowlingGame,17, 0);

        assertEquals(16, soloBowlingGame.score(0));
    }

    @Test
    public void testOneStrike() {
        rollStrike(soloBowlingGame);
        soloBowlingGame.roll(3);
        soloBowlingGame.roll(4);
        rollMany(soloBowlingGame,16, 0);

        assertEquals(24, soloBowlingGame.score(0));
    }

    @Test
    public void testPerfectGame() {
        rollMany(soloBowlingGame,12, 10);
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

    @Test
    public void testCurrentPlayerAfterStrike() {
        BowlingGame bowlingGame = new BowlingGame(2);
        rollStrike(bowlingGame); // strike

        assertEquals(1, bowlingGame.getCurrentPlayer());
    }

    @Test
    public void testTwoPlayerStrike() {
        BowlingGame bowlingGame = new BowlingGame(3);

        // player 0
        rollStrike(bowlingGame);

        // player 1
        rollStrike(bowlingGame);

        // player 2
        bowlingGame.roll(3);
        bowlingGame.roll(6);

        // player 0
        bowlingGame.roll(6);
        bowlingGame.roll(3);

        // player 1
        bowlingGame.roll(3);
        bowlingGame.roll(4);

        // player 2
        bowlingGame.roll(3);
        bowlingGame.roll(5);

        rollMany(bowlingGame, 16 + 16 + 16, 0);

        assertEquals(28, bowlingGame.score(0));
        assertEquals(24, bowlingGame.score(1));
        assertEquals(17, bowlingGame.score(2));
    }

    private void rollMany(BowlingGame bowlingGame, int n, int pins) {
        for (int i = 0; i < n; i++) {
            bowlingGame.roll(pins);
        }
    }

    private void rollStrike(BowlingGame bowlingGame) {
        bowlingGame.roll(10);
    }

    private void rollSpare(BowlingGame bowlingGame) {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }
}