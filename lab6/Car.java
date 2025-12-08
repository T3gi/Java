/**
 * Абстрактний базовий клас, що описує загальні характеристики автомобіля.
 * Всі специфічні типи автомобілів повинні наслідувати цей клас.
 */
public abstract class Car {
    private String model;
    private double price;
    private double fuelConsumption;
    private int maxSpeed;

    /**
     * Конструктор для створення нового автомобіля.
     *
     * @param model           назва моделі.
     * @param price           ціна автомобіля.
     * @param fuelConsumption витрати палива (л/100км).
     * @param maxSpeed        максимальна швидкість (км/год).
     */
    public Car(String model, double price, double fuelConsumption, int maxSpeed) {
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    /**
     * Отримує ціну автомобіля.
     *
     * @return ціна.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Отримує витрати палива.
     *
     * @return витрати палива (л/100км).
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Отримує максимальну швидкість.
     *
     * @return максимальна швидкість (км/год).
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Повертає рядкове представлення об'єкта автомобіля.
     *
     * @return відформатований рядок з характеристиками авто.
     */
    @Override
    public String toString() {
        return String.format("Модель: %-15s \t Цiна: $%-8.2f \t Витрати: %-4.1f л/100км \t Швидкiсть: %d км/год",
                model, price, fuelConsumption, maxSpeed);
    }
}