package racingcar;

import java.util.List;

public class CarGameController {
    public static void executeGame(List<Car> cars, Integer MOVECOUNTS) {
        OutputView.string("실행 결과");
        for (Integer i = 0; i < MOVECOUNTS; i++) {
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

    public static Integer repeatInputMoveCounts() {
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

    public static Integer inputMoveCounts() {
        OutputView.string("시도할 회수는 몇회인가요?");
        return InputView.inputMoveCounts();
    }

    private static void repeatMoves(List<Car> cars) {
        for (Integer i=0; i < cars.size(); i++) {
            if (CarGameAnalyze.analyzeMovement(InputView.generateRandomNumber())) {
                cars.get(i).move();
            }
            OutputView.result(cars.get(i));
        }
    }

    private static void isFinalMove(Integer i, List<Car> cars, Integer MOVECOUNTS) {
        if (CarGameAnalyze.analyzeFinalMove(i, MOVECOUNTS)) {
            OutputView.finalResult(CarGameAnalyze.analyzeWinner(cars));
        }
    }
}
