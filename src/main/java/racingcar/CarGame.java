package racingcar;

public class CarGame {
    private final String[] CARNAMES;
    private final int MOVECOUNTS;
    Car[] CARS;

    public CarGame() {
        this.CARNAMES = CarGameController.repeatInputCarNames();
        this.MOVECOUNTS = CarGameController.repeatInputMoveCounts();
    }

    public void start() {
        CARS = new Car[CARNAMES.length];
        for (int i = 0; i < CARNAMES.length; i++) {
            CARS[i] = new Car(CARNAMES[i]);
        }
    }

    public void play() {
        CarGameController.play(CARS, MOVECOUNTS);
    }
}
