import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {
    @Test
    public void testGutterGame() {
        BowlingGame bowlingGame = new BowlingGame();

        rollMany(bowlingGame, 20, 0);

        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void testAllOnes() {
        BowlingGame bowlingGame = new BowlingGame();

        rollMany(bowlingGame, 20, 1);

        assertEquals(20, bowlingGame.score());
    }

    private void rollMany(BowlingGame bowlingGame, int n, int pins) {
        for (int i = 0; i < n; i++) {
            bowlingGame.roll(pins);
        }
    }
}