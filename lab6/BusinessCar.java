/**
 * Клас, що представляє автомобіль бізнес-класу.
 */
public class BusinessCar extends Car {
    /**
     * Конструктор для створення авто комфорт-класу.
     *
     * @param model           назва моделі.
     * @param price           ціна.
     * @param fuelConsumption витрати палива.
     * @param maxSpeed        максимальна швидкість.
     */
    public BusinessCar(String model, double price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }
}