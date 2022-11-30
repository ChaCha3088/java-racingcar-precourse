package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGameAnalyzeTest {
    @DisplayName("최종 우승자가 한명인 경우")
    @Test
    void analyzeWinnerTest1() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("a"));
        cars.get(0).setPosition(3);
        cars.add(new Car("b"));
        cars.get(1).setPosition(4);
        cars.add(new Car("c"));
        cars.get(2).setPosition(5);

        assertThat(String.join(", ", CarGameAnalyze.analyzeWinner(cars))).isEqualTo("c");
    }

    @DisplayName("최종 우승자가 두명인 경우")
    @Test
    void analyzeWinnerTest2() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("a"));
        cars.get(0).setPosition(5);
        cars.add(new Car("b"));
        cars.get(1).setPosition(4);
        cars.add(new Car("c"));
        cars.get(2).setPosition(5);

        assertThat(String.join(", ", CarGameAnalyze.analyzeWinner(cars))).isEqualTo("a, c");
    }

    @DisplayName("최종 우승자가 세명인 경우")
    @Test
    void analyzeWinnerTest3() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("a"));
        cars.get(0).setPosition(5);
        cars.add(new Car("b"));
        cars.get(1).setPosition(5);
        cars.add(new Car("c"));
        cars.get(2).setPosition(5);

        assertThat(String.join(", ", CarGameAnalyze.analyzeWinner(cars))).isEqualTo("a, b, c");
    }

    @DisplayName("마지막 시도인 경우")
    @Test
    void analyzeFinalMoveTest1() {
        Integer i = 4;
        Integer MOVECOUNTS = 5;

        assertThat(CarGameAnalyze.analyzeFinalMove(i, MOVECOUNTS)).isEqualTo(true);
    }

    @DisplayName("마지막 시도가 아닌 경우")
    @Test
    void analyzeFinalMoveTest2() {
        Integer i = 3;
        Integer MOVECOUNTS = 5;

        assertThat(CarGameAnalyze.analyzeFinalMove(i, MOVECOUNTS)).isEqualTo(false);
    }

    @DisplayName("4와 9 사이의 수인 경우")
    @Test
    void analyzeMovementTest1() {
        Integer randomNumber = 4;

        assertThat(CarGameAnalyze.analyzeMovement(randomNumber)).isEqualTo(true);
    }

    @DisplayName("4와 9 사이의 수가 아닌 경우")
    @Test
    void analyzeMovementTest2() {
        Integer randomNumber = 1;

        assertThat(CarGameAnalyze.analyzeMovement(randomNumber)).isEqualTo(false);
    }
}