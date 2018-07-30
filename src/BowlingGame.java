public class BowlingGame {
    private int rolls[][];
    private int currentRoll[];
    private int numberOfPlayers;
    private int currentPlayer = 0;
    private int currentBall[];

    public BowlingGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        rolls = new int[numberOfPlayers][21];
        currentRoll = new int[numberOfPlayers];
        currentBall = new int[numberOfPlayers];
    }

    public void roll(int pins) {
        rolls[currentPlayer][currentRoll[currentPlayer]] = pins;
        currentRoll[currentPlayer] += 1;

        if (isTurnOver(pins)) {
            turnOver();
        }

        else {
            currentBall[currentPlayer] += 1;
        }
    }

    public int score(int playerId) {
        int score = 0;
        int frameIndex =0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex, playerId)) {
                score += 10 + strikeBonus(frameIndex, playerId);

                frameIndex += 1;
            }

            else if (isSpare(frameIndex, playerId)) {
                score += 10 + spareBonus(frameIndex, playerId);

                frameIndex += 2;
            }

            else {
                score += sumOfBallsInFrame(frameIndex, playerId);

                frameIndex += 2;
            }
        }

        return score;
    }

    private boolean isTurnOver(int pins) {
        if (pins == 10) {
            return true;
        }
        else return currentBall[currentPlayer] == 1;
    }

    private void turnOver() {
        currentBall[currentPlayer] = 0;

        if (isLastPlayer(currentPlayer)) {
            currentPlayer = 0;
        }
        else {
            currentPlayer += 1;
        }
    }

    private boolean isStrike(int frameIndex, int playerId) { return rolls[playerId][frameIndex] == 10; }

    private boolean isSpare(int frameIndex, int playerId) {
        return rolls[playerId][frameIndex] + rolls[playerId][frameIndex + 1] == 10;
    }

    private int sumOfBallsInFrame(int frameIndex, int playerId) {
        return rolls[playerId][frameIndex] + rolls[playerId][frameIndex + 1];
    }

    private int strikeBonus(int frameIndex, int playerId) {
        return rolls[playerId][frameIndex + 1] + rolls[playerId][frameIndex + 2];
    }

    private int spareBonus(int frameIndex, int playerId) {
        return rolls[playerId][frameIndex + 2];
    }

    private boolean isLastPlayer(int player) {
        return player + 1 == numberOfPlayers;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
}
