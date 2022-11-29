package racingcar;

import java.util.List;

public class CarGameVerification {
    public static List<String> verifyLetterSize(List<String> inputLetters, Integer counts) {
        for (String str: inputLetters) {
            if (str.length() > counts || str.length() == 0) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하거나 1자 이상이어야합니다.");
            }
        }
        return inputLetters;
    }

    public static Integer verifyMoveCounts(Integer moveCounts) {
        if (moveCounts < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 1 이상의 수를 입력해야 합니다.");
        }
        return moveCounts;
    }
}
