/**
 * Клас, що представляє автомобіль комфорт-класу.
 */
public class ComfortCar extends Car {
    /**
     * Конструктор для створення авто комфорт-класу.
     *
     * @param model           назва моделі.
     * @param price           ціна.
     * @param fuelConsumption витрати палива.
     * @param maxSpeed        максимальна швидкість.
     */
    public ComfortCar(String model, double price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }
}