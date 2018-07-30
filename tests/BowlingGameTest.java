import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {
    private BowlingGame bowlingGame;

    @BeforeEach
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void testGutterGame() {
        rollMany(20, 0);

        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);

        assertEquals(20, bowlingGame.score());
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        bowlingGame.roll(3);
        rollMany(17, 0);

        assertEquals(16, bowlingGame.score());
    }

    @Test
    public void testOneStrike() {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        rollMany(16, 0);

        assertEquals(24, bowlingGame.score());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);
        assertEquals(300, bowlingGame.score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            bowlingGame.roll(pins);
        }
    }

    private void rollStrike() {
        bowlingGame.roll(10);
    }

    private void rollSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }
}