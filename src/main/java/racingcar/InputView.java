package racingcar;

public class InputView {
    public static String[] inputCarNames() {
        return camp.nextstep.edu.missionutils.Console.readLine().split(",");
    }

    public static int inputMoveCounts() {
        return Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
    }
}
