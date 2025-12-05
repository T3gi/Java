import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Клас, що представляє автопарк (колекцію автомобілів).
 * Надає методи для управління автомобілями, сортування та пошуку.
 */
public class CarPark {
    private List<Car> cars;

    /**
     * Конструктор за замовчуванням.
     * Ініціалізує порожній список автомобілів.
     */
    public CarPark() {
        this.cars = new ArrayList<>();
    }

    /**
     * Додає автомобіль до автопарку.
     *
     * @param car об'єкт автомобіля, який потрібно додати.
     */
    public void addCar(Car car) {
        cars.add(car);
    }

    /**
     * Обчислює загальну вартість усіх автомобілів у парку.
     *
     * @return сума цін усіх автомобілів.
     */
    public double calculateTotalValue() {
        double total = 0;
        for (Car car : cars) {
            total += car.getPrice();
        }
        return total;
    }

    /**
     * Сортує автомобілі за витратами палива у порядку зростання.
     * Використовує {@link Comparator}.
     */
    public void sortByFuelConsumption() {
        cars.sort(Comparator.comparingDouble(Car::getFuelConsumption));
    }

    /**
     * Знаходить автомобілі, швидкість яких знаходиться в заданому діапазоні.
     *
     * @param minSpeed мінімальна швидкість (включно).
     * @param maxSpeed максимальна швидкість (включно).
     * @return список знайдених автомобілів.
     */
    public List<Car> findCarsBySpeedRange(int minSpeed, int maxSpeed) {
        List<Car> foundCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }

    /**
     * Виводить інформацію про всі автомобілі в консоль.
     */
    public void printCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}