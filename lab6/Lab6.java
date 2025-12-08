import java.util.*;
/*
* ІО - 33 Титок Володимир
* Залікова №3324
*/

public class Lab6 {
    public static void main(String[] args) {
        CarPark<Car> myTaxiPark = new CarPark<>();

        myTaxiPark.add(new EconomyCar("Daewoo Lanos", 3000, 9.5, 160));
        myTaxiPark.add(new EconomyCar("Renault Logan", 7000, 7.2, 170));
        myTaxiPark.add(new ComfortCar("Toyota Camry", 25000, 8.5, 210));
        myTaxiPark.add(new ComfortCar("Volkswagen Passat", 22000, 8.0, 205));
        
        Car businessCar = new BusinessCar("Mercedes S-Class", 95000, 12.5, 250);
        CarPark<Car> vipPark = new CarPark<>(businessCar);
        myTaxiPark.addAll(vipPark);

        List<Car> standardList = new ArrayList<>();
        standardList.add(new BusinessCar("BMW 7 Series", 90000, 11.8, 250));
        CarPark<Car> importPark = new CarPark<>(standardList);
        myTaxiPark.addAll(importPark);

        System.out.println("Всi автомобiлi в автопарку");
        for (Car c : myTaxiPark) {
            System.out.println(c);
        }
        System.out.println();

        double totalValue = myTaxiPark.calculateTotalValue();
        System.out.printf("Загальна вартiсть автопарку: $%.2f\n", totalValue);
        System.out.println();

        System.out.println("Сортування за витратами палива (вiд меншого до бiльшого)");
        myTaxiPark.sort(Comparator.comparingDouble(Car::getFuelConsumption));
        for (Car c : myTaxiPark) System.out.println(c);
        System.out.println();

        int minSpeed = 200;
        int maxSpeed = 220;
        System.out.printf("Пошук авто зi швидкiстю вiд %d до %d км/год\n", minSpeed, maxSpeed);
        List<Car> foundCars = myTaxiPark.findCarsBySpeedRange(minSpeed, maxSpeed);
        
        if (foundCars.isEmpty()) {
            System.out.println("Автомобілів не знайдено.");
        } else {
            for (Car c : foundCars) {
                System.out.println(c);
            }
        }
    }
}

