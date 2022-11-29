package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    private final List<String> CARNAMES;
    private final Integer MOVECOUNTS;
    List<Car> CARS = new ArrayList<>();

    public CarGame() {
        this.CARNAMES = CarGameController.repeatInputCarNames();
        this.MOVECOUNTS = CarGameController.repeatInputMoveCounts();
    }

    public void start() {
        for (Integer i = 0; i < CARNAMES.size(); i++) {
            CARS.add(new Car(CARNAMES.get(i)));
        }
    }

    public void play() {
        CarGameController.executeGame(CARS, MOVECOUNTS);
    }
}
