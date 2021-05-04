package racingcar;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.IntSupplier;

public class Racing {
    private final Set<Car> cars;

    protected Racing() {
        this.cars = new HashSet<>();
    }

    protected int size() {
        return cars.size();
    }

    protected Iterator<Car> iterator() {
        return cars.iterator();
    }

    protected void participate(Car car) {
        cars.add(car);
    }

    protected Car[] getWinner(int round) {
        NotExistNullSet<Car> winners = new NotExistNullSet<>();

        grade(round, winners);

        return winners.toArray(new Car[winners.size()]);
    }

    protected void timeGoesBy(IntSupplier supplier) {
        iterator(car->car.treadAxel(supplier.getAsInt()));
    }

    private void grade(int round, NotExistNullSet<Car> winners) {
        iterator(car->winners.addIfNullIgnore(round == car.getDistance() ? car : null));

        if (winners.isEmpty()) {
            grade(round - 1, winners);
        }
    }

    private void iterator(Consumer<Car> consumer) {
        for (Car car : cars) {
            consumer.accept(car);
        }
    }

    private class NotExistNullSet<E> extends HashSet<E> {
        public boolean addIfNullIgnore(E e) {
            if (e == null) {
                return false;
            }

            return super.add(e);
        }
    }
}
