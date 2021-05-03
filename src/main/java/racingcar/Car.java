package racingcar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(of = "name")
public class Car {
    protected static final int STOP_MAX = 3;
    protected static final int CAR_NAME_LENGTH_MIN = 1;
    protected static final int CAR_NAME_LENGTH_MAX = 5;

    @Getter
    private String name;
    private int distance;

    protected Car(String name) {
        if (isCarNameCondition(name)) {
            throw new IllegalArgumentException("자동차 이름 명명규칙에 부적합 합니다.");
        }

        this.name = name;
    }

    protected void treadAxel(int variable) {
        if (isForward(variable)) {
            forward();
        }
    }

    protected int getDistance() {
        return distance;
    }

    private void forward() {
        distance++;
    }

    private boolean isForward(int variable) {
        return variable > STOP_MAX;
    }

    private boolean isCarNameCondition(String name) {
        return name.length() < CAR_NAME_LENGTH_MIN || name.length() > CAR_NAME_LENGTH_MAX;
    }
}
