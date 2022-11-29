package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGameController {
    private int generateRandomNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
    }

    private Boolean decideMovement(int randomNumber) {
        if (randomNumber>= 4 & randomNumber<=9) {
            return true;
        }
        return false;
    }

    private String[] verifyLetterCounts(String[] inputLetters, int counts) {
        for (String str: inputLetters) {
            if (str.length() > counts || str.length() == 0) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하거나 1자 이상이어야합니다.");
            }
        }
        return inputLetters;
    }

    private int verifyMoveCounts(int moveCounts) {
        if (moveCounts < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 1 이상의 수를 입력해야 합니다.");
        }
        return moveCounts;
    }

    private String[] repeatInputCarNames(String[] inputCarNames) {
        while (true) {
            try {
                return verifyLetterCounts(InputView.inputCarNames(), 5);
            } catch (IllegalArgumentException e) {
                OutputView.string("[ERROR] 이름은 5자 이하거나 1자 이상이어야합니다.");
            }
        }
    }

    private int repeatInputMoveCounts(String inputMoveCounts) {
        while (true) {
            try {
                return verifyMoveCounts(InputView.inputMoveCounts());
            }catch (NumberFormatException e) { OutputView.string("[ERROR] 시도 회수는 정수로 입력해야 합니다."); }
            catch (IllegalArgumentException e) { OutputView.string("[ERROR] 시도 회수는 1 이상의 수를 입력해야 합니다."); }

        }
    }
}
