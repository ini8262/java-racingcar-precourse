package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {

    @RepeatedTest(1000)
    @DisplayName("0에서 9사이의 수 반환 테스트")
    public void abc() {
        assertThat(RandomUtil.getTenLessThanNaturalNumbersAndZero())
                .isBetween(0, 9);
    }

}