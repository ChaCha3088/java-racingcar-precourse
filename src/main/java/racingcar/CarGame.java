package racingcar;

import java.util.List;

public class CarGame {
    private final List<String> CARNAMES;
    private final int MOVECOUNTS;
    Car[] CARS;

    public CarGame() {
        this.CARNAMES = CarGameController.repeatInputCarNames();
        this.MOVECOUNTS = CarGameController.repeatInputMoveCounts();
    }

    public void start() {
        CARS = new Car[CARNAMES.size()];
        for (int i = 0; i < CARNAMES.size(); i++) {
            CARS[i] = new Car(CARNAMES.get(i));
        }
    }

    public void play() {
        CarGameController.executeGame(CARS, MOVECOUNTS);
    }
}
