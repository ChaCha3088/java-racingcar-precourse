package racingcar;

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
}
