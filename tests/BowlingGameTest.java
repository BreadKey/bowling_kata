import org.junit.Test;

public class BowlingGameTest {
    @Test
    public void testGutterGame() {
        BowlingGame bowlingGame = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(0);
        }
    }
}
