package racingcar;

import java.util.List;

public class CarGameController {
    public static void executeGame(Car[] cars, int MOVECOUNTS) {
        OutputView.string("실행 결과");
        for (int i = 0; i < MOVECOUNTS; i++) {
            repeatMoves(cars);
            isFinalMove(i, cars, MOVECOUNTS);
        }
    }

    public static List<String> repeatInputCarNames() {
        while (true) {
            try {
                return CarGameVerification.verifyLetterSize(inputCarNames(), 5);
            } catch (IllegalArgumentException e) {
                OutputView.string("[ERROR] 이름은 5자 이하거나 1자 이상이어야합니다.");
            }
        }
    }

    public static int repeatInputMoveCounts() {
        while (true) {
            try {
                return CarGameVerification.verifyMoveCounts(inputMoveCounts());
            } catch (NumberFormatException e) { OutputView.string("[ERROR] 시도 회수는 정수로 입력해야 합니다."); }
            catch (IllegalArgumentException e) { OutputView.string("[ERROR] 시도 회수는 1 이상의 수를 입력해야 합니다."); }
        }
    }

    public static List<String> inputCarNames() {
        OutputView.string("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return InputView.inputCarNames();
    }

    public static int inputMoveCounts() {
        OutputView.string("시도할 회수는 몇회인가요?");
        return InputView.inputMoveCounts();
    }

    private static void repeatMoves(Car[] cars) {
        for (int i=0; i < cars.length; i++) {
            if (CarGameAnalyze.analyzeMoveCounts(InputView.generateRandomNumber())) {
                cars[i].move();
            }
            OutputView.result(cars[i]);
        }
    }

    private static void isFinalMove(int i, Car[] cars, int MOVECOUNTS) {
        if (CarGameAnalyze.analyzeFinalMove(i, MOVECOUNTS)) {
            OutputView.finalResult(CarGameAnalyze.analyzeWinner(cars));
        }
    }
}
