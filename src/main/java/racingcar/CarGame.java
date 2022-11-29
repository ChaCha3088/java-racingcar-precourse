package racingcar;

public class CarGame {
    private final String[] CARNAMES;
    private final int MOVECOUNTS;
    Car[] CARS;

    private CarGame(int moveCounts) {
        this.CARNAMES = CarGameController.repeatInputCarNames();
        this.MOVECOUNTS = CarGameController.repeatInputMoveCounts();
    }

    private void start() {
        for (int i = 0; i < CARNAMES.length; i++) {
            CARS[i] = new Car(CARNAMES[i]);
        }
    }
}
