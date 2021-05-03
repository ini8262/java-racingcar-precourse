package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    private Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car("람보르기니");
    }

    @Test
    @DisplayName("자동차 생성")
    public void initTest() {
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("자동차 생성 에러")
    public void initErrorTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("맥라렌 570s 스파이더"))
                .withMessageContaining("부적합");
    }

    @DisplayName("자동차 멈춤")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void moveStopTest(int variable) {
        car.treadAxel(variable);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("자동차 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveForwardTest(int variable) {
        car.treadAxel(variable);
        assertThat(car.getDistance()).isEqualTo(1);
    }

}
