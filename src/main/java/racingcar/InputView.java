package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> inputCarNames() {
        return new ArrayList<>(Arrays.asList(
                camp.nextstep.edu.missionutils.Console.readLine().split(",")
        ));
    }

    public static int inputMoveCounts() {
        return Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
    }

    public static int generateRandomNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
    }
}
