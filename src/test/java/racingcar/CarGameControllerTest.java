package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGameControllerTest {
    @DisplayName("사용자가 유효하지 않은 값을 입력 했을 때 반복하는 테스트")
    @Test
    void repeatInputCarNamesTest1() {
        String[] input = {"123456", "123,456"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThat(CarGameController.repeatInputCarNames())
                .isEqualTo(new ArrayList<>(Arrays.asList("123", "456")));
    }

    @DisplayName("예외 상황 발생 시 에러 문구 포함 테스트")
    @Test
    void repeatInputCarNamesTest2() {
        String[] input = {"123456", "123,456"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        CarGameController.repeatInputCarNames();

        assertThat(captor.toString().trim()).contains("[ERROR]");
    }

    @DisplayName("사용자가 유효하지 않은 값을 입력 했을 때 반복하는 테스트")
    @Test
    void repeatInputMoveCountsTest1() {
        String[] input = {"0", "what", "5"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThat(CarGameController.repeatInputMoveCounts())
                .isEqualTo(5);
    }

    @DisplayName("IllegalArgumentException 발생 시 에러 문구 포함 테스트")
    @Test
    void repeatInputMoveCountsTest2() {
        String[] input = {"0", "5"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        CarGameController.repeatInputMoveCounts();

        assertThat(captor.toString().trim()).contains("1 이상의 수");
    }

    @DisplayName("NumberFormatException 발생 시 에러 문구 포함 테스트")
    @Test
    void repeatInputMoveCountsTest3() {
        String[] input = {"hey", "5"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        CarGameController.repeatInputMoveCounts();

        assertThat(captor.toString().trim()).contains("정수로 입력해야");
    }

    @DisplayName("NumberFormatException 발생 시 에러 문구 포함 테스트")
    @Test
    void repeatInputMoveCountsTest4() {
        String[] input = {"1.5", "5"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        CarGameController.repeatInputMoveCounts();

        assertThat(captor.toString().trim()).contains("정수로 입력해야");
    }
}