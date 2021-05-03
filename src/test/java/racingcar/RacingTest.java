package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    private Racing racing;

    @BeforeEach
    public void beforeEach() {
        racing = new Racing();
    }

    @Test
    @DisplayName("레이싱 생성")
    public void initTest() {
        racing.participate(new Car("람보르기니"));
        racing.participate(new Car("세스크"));
        racing.participate(new Car("제네시스"));
        racing.participate(new Car("제네시스"));

        assertThat(racing).isNotNull();
        assertThat(racing.size()).isEqualTo(3);
    }

    @DisplayName("레이싱 단독 1등 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10})
    public void racingOnlyWinnerTest(int num) {
        racing.participate(forward(num, new Car("람보르기니")));
        racing.participate(forward(num - 1, new Car("세스크")));
        racing.participate(forward(num - 2, new Car("제네시스")));


        assertThat(racing.getWinner(num))
                .containsOnly(new Car("람보르기니"));
    }

    @DisplayName("레이싱 공동 1등 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10})
    public void racingWinnerTest(int num) {
        racing.participate(forward(num, new Car("람보르기니")));
        racing.participate(forward(num, new Car("세스크")));
        racing.participate(forward(num - 2, new Car("제네시스")));

        assertThat(racing.getWinner(num))
                .contains(new Car("세스크"), new Car("람보르기니"));
    }

    private Car forward(int n, Car car) {
        for (int i = 0; i < n; i++) {
            car.treadAxel(Car.STOP_MAX + 1);
        }

        return car;
    }
}