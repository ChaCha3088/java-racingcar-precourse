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

    private void verifyLetterCounts(String[] inputLetters, int counts) {
        for (String str: inputLetters) {
            if (str.length() > counts || str.length() == 0) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하거나 1자 이상이어야합니다.");
            }
        }
    }
}
