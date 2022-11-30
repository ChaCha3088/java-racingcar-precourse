package racingcar;

import static org.assertj.core.api.Assertions.*;
import static racingcar.CarGameController.inputCarNames;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGameVerificationTest {
    @DisplayName("글자수 검증 메소드 테스트")
    @Test
    void verifyLetterSizeTest1() {
        String[] input = {"a,b,c"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThat(CarGameVerification.verifyLetterSize(inputCarNames(),5))
                .isEqualTo(new ArrayList<>(Arrays.asList("a", "b", "c")));
    }

    @DisplayName("예외 상황에서 오류 발생 테스트")
    @Test
    void verifyLetterSizeTest2() {
        String[] input = {"123456,1,2"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> CarGameVerification.verifyLetterSize(inputCarNames(), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 상황에서 오류 발생 테스트")
    @Test
    void verifyLetterSizeTest3() {
        String[] input = {",1,2"};

        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> CarGameVerification.verifyLetterSize(inputCarNames(), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 회수 검증 테스트")
    @Test
    void verifyMoveCountsTest1() {
        assertThat(CarGameVerification.verifyMoveCounts(5))
                .isEqualTo(5);
    }

    @DisplayName("예외 상황에서 오류 발생 테스트")
    @Test
    void verifyMoveCountsTest2() {
        assertThatThrownBy(() -> CarGameVerification.verifyMoveCounts(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}