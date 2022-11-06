package baseball.model.hint;

import baseball.model.number.BaseballNumbers;

public class Hint {
    private static final String BALL_STRING = "볼";
    private static final String STRIKE_STRING = "스트라이크";
    private static final String NOTHING_STRING = "낫싱";
    private static final String SPACE_STRING = " ";
    private static final String NULL_STRING = "";

    private final BaseballNumbers answerBaseballNumbers;
    private final BaseballNumbers inputBaseballNumbers;

    public Hint(BaseballNumbers answerBaseballNumbers, BaseballNumbers inputBaseballNumbers) {
        this.answerBaseballNumbers = answerBaseballNumbers;
        this.inputBaseballNumbers = inputBaseballNumbers;
    }

    public boolean isCorrectNumber() {
        int strikeCount = answerBaseballNumbers.getStrike(inputBaseballNumbers);
        if(strikeCount == 3) {
            return true;
        }
        return false;
    }

    public String getBaseballNumberCount() {
        if(answerBaseballNumbers.isNothing(inputBaseballNumbers)) {
            return NOTHING_STRING;
        }
        int strikeCount = answerBaseballNumbers.getStrike(inputBaseballNumbers);
        int ballCount = answerBaseballNumbers.getBall(inputBaseballNumbers);
        String result = makeCountString(ballCount, strikeCount);
        return result;
    }

    private String makeCountString(int ballCount, int strikeCount) {
        String result = getBallResult(ballCount);

        if(strikeCount == 0) {
            result += getStrikeResult(strikeCount);
        }
        if(strikeCount >= 1) {
            result += (SPACE_STRING + getStrikeResult(strikeCount));
        }
        return result;
    }

    private String getBallResult(int ballCount) {
        if(ballCount == 0) {
            return NULL_STRING;
        }
        return ballCount + BALL_STRING;
    }

    private String getStrikeResult(int strikeCount) {
        if(strikeCount == 0) {
            return NULL_STRING;
        }
        return strikeCount + STRIKE_STRING;
    }

}
