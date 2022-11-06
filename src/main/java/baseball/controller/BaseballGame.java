package baseball.controller;

import baseball.model.hint.Hint;
import baseball.model.number.BaseballNumbers;
import baseball.model.player.Computer;
import baseball.view.BaseballGameView;

public class BaseballGame {
    private final BaseballGameView gameView;
    private final Computer computer;

    BaseballGame() {
        gameView = new BaseballGameView();
        computer = new Computer();
    }

    private void init() {
        gameView.startBaseballGame();
        while(true) {
            getUserInput();
        }
    }

    private BaseballNumbers getUserInput() {
        String userInput = gameView.getUserInput();
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(userInput);
        return userBaseballNumbers;
    }

    private void makeHint(BaseballNumbers userBaseballNumbers) {
        Hint userInputHint = computer.makeUserInputHint(userBaseballNumbers);
        String userInputResult = userInputHint.getResult();
        gameView.printUserInputHint(userInputResult);
    }
}
