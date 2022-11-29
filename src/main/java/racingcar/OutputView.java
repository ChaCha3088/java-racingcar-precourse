package racingcar;

import java.util.List;

public class OutputView {
    public static void string(String str) {
        System.out.println(str);
    }

    public static void result(Car car) {
        System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
    }

    public static void finalResult(List<String> list) {
        System.out.println("최종 우승자 : "+String.join(", ", list));
    }
}
