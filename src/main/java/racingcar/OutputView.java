package racingcar;

public class OutputView {
    public static void string(String str) {
        System.out.println(str);
    }

    public static void result(Car car) {
        System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
    }
}
