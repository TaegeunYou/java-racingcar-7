package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.domain.Cars;
import racingcar.view.console.ConsoleWriter;

public class RaceController {

    private final InputView inputView;
    private static final String PLAY_START_MESSAGE = "실행 결과";
    private static final String RESULT_MESSAGE = "최종 우승자 : %s";

    public RaceController() {
        inputView = new InputView();
    }

    public void start() {
        Cars cars = new Cars(inputView.requestCarsName());
        int roundCount = inputView.requestRoundCount();

        play(cars, roundCount);

        finish(cars);
    }

    private void play(Cars cars, int roundCount) {
        ConsoleWriter.printlnMessage(PLAY_START_MESSAGE);
        for (int round = 1; round <= roundCount; round++) {
            cars.playSingleRound();

            //해당 차수 실행 결과를 출력
            ConsoleWriter.printlnMessage(cars.toString());
        }
    }

    private void finish(Cars cars) {
        List<String> winnerNames = cars.getWinnerNames();
        ConsoleWriter.printlnMessage(String.format(RESULT_MESSAGE, String.join(", ", winnerNames)));
    }

}
