package racingcar;

import java.util.List;

public class Car {
    private final String name;
    private Integer position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move() {
        this.position ++;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return this.position;
    }
}
