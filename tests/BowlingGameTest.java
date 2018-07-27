import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {
    @Test
    public void testGutterGame() {
        BowlingGame bowlingGame = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(0);
        }
        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void testAllOnes() {
        BowlingGame bowlingGame = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(1);
        }
        assertEquals(20, bowlingGame.score());
    }
}
