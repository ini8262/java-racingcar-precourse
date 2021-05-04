package racingcar;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.IntSupplier;

public class RacingGame  {
    private static final char SHAPE = '-';

    private int round;
    private Racing racing;

    public RacingGame(int round, String ...names) {
        this.round = round;
        this.racing = new Racing();

        for (String name : names) {
            racing.participate(new Car(name));
        }
    }

    public String next(IntSupplier intSupplier) {
        racing.timeGoesBy(intSupplier);

        return getProgress(racing.iterator());
    }

    public Car[] getWinner() {
        return racing.getWinner(round);
    }

    public String getProgress(Iterator<Car> iterator) {
        StringBuilder result = new StringBuilder();
        while(iterator.hasNext()) {
            result.append(getPrintFormat(iterator));
        }

        return result.toString();
    }

    public int getRound() {
        return this.round;
    }

    private String getPrintFormat(Iterator<Car> iterator) {
        Car car = iterator.next();
        return String.format("%s : %s\n", car.getName(), getDistanceFormat(car.getDistance()));
    }

    private String getDistanceFormat(int distance) {
        char[] chars = new char[distance];
        Arrays.fill(chars, SHAPE);

        return new String(chars);
    }
}
