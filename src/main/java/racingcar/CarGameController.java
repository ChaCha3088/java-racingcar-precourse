package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarGameController {
    public static int generateRandomNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
    }

    public static Boolean decideMovement(int randomNumber) {
        if (randomNumber>= 4 & randomNumber<=9) {
            return true;
        }
        return false;
    }

    private static String[] verifyLetterCounts(String[] inputLetters, int counts) {
        for (String str: inputLetters) {
            if (str.length() > counts || str.length() == 0) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하거나 1자 이상이어야합니다.");
            }
        }
        return inputLetters;
    }

    private static int verifyMoveCounts(int moveCounts) {
        if (moveCounts < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 1 이상의 수를 입력해야 합니다.");
        }
        return moveCounts;
    }

    public static String[] repeatInputCarNames() {
        while (true) {
            try {
                OutputView.string("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                return verifyLetterCounts(InputView.inputCarNames(), 5);
            } catch (IllegalArgumentException e) {
                OutputView.string("[ERROR] 이름은 5자 이하거나 1자 이상이어야합니다.");
            }
        }
    }

    public static int repeatInputMoveCounts() {
        while (true) {
            try {
                OutputView.string("시도할 회수는 몇회인가요?");
                return verifyMoveCounts(InputView.inputMoveCounts());
            }catch (NumberFormatException e) { OutputView.string("[ERROR] 시도 회수는 정수로 입력해야 합니다."); }
            catch (IllegalArgumentException e) { OutputView.string("[ERROR] 시도 회수는 1 이상의 수를 입력해야 합니다."); }

        }
    }

    public static List<String> analyzeWinner(Car[] cars) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Car car : cars) {
            result.put(car.getName(), car.getPosition());
        }
        return findMaxKeys(result);
    }

    private static List<String> findMaxKeys(LinkedHashMap<String, Integer> result) {
        List<String> resultList = new ArrayList<>();
        int maxValue = Collections.max(result.values());
        for (Map.Entry<String, Integer> m : result.entrySet()) {
            if(m.getValue() == maxValue) {
                resultList.add(m.getKey());
            }
        }
        return resultList;
    }

    public static void play(Car[] cars, int MOVECOUNTS) {
        OutputView.string("실행 결과");
        for (int i = 0; i < MOVECOUNTS; i++) {
            if (decideMovement(generateRandomNumber())) { cars[i].move(); }
            OutputView.result(cars[i]);
            if (i == MOVECOUNTS-1) { OutputView.finalResult(analyzeWinner(cars)); }
        }
    }
}
