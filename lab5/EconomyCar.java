/**
 * Клас, що представляє автомобіль економ-класу.
 */
public class EconomyCar extends Car {
    /**
     * Конструктор для створення авто економ-класу.
     *
     * @param model           назва моделі.
     * @param price           ціна.
     * @param fuelConsumption витрати палива.
     * @param maxSpeed        максимальна швидкість.
     */
    public EconomyCar(String model, double price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }
}