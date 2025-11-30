/*
* ІО - 33 Титок Володимир
* Залікова №3324
*/

import java.util.Arrays;

class Plane {
    public String modelName;
    public String registrationNumber;
    public int passengerCapacity;
    public int maxTakeOffWeight;
    public String usageType;

    public Plane(String modelName, String registrationNumber, int passengerCapacity, int maxTakeoffWeight, String usageType) {
        this.modelName = modelName;
        this.registrationNumber = registrationNumber;
        this.passengerCapacity = passengerCapacity;
        this.maxTakeOffWeight = maxTakeoffWeight;
        this.usageType = usageType;
    }

    public void printInfo() {
        System.out.println("Модель: " + modelName);
        System.out.println("Реєстрацiйний номер: " + registrationNumber);
        System.out.println("Пасажиромiсткiсть: " + passengerCapacity);
        System.out.println("Максимальне навантаження: " + maxTakeOffWeight + " кг");
        System.out.println("Вид: " + usageType);
        System.out.println();
    }
}

public class Lab3 {

    // C11 = 3324 % 11 = 2 - Визначити клас літак, який складається як мінімум з 5 полів

    public static void main(String[] args) {
        Plane[] planes = new Plane[5];

        planes[0] = new Plane(
            "Boeing 747-400",
            "N747PR",
            416,
            396890,
            "Пасажирський далекомагiстральний"
        );
        planes[1] = new Plane(
            "Airbus A320neo",
            "F-WWAB",
            180,
            79000,
            "Пасажирський середньомагiстральний"
        );
        planes[2] = new Plane(
            "Lockheed C-130 Hercules",
            "86-0010",
            92,
            70310,
            "Вантажний вiйськовий"
        );
        planes[3] = new Plane(
            "Cessna 172 Skyhawk",
            "N987CD",
            4,
            1100,
            "Приватний/Навчальний"
        );
        planes[4] = new Plane(
            "Embraer E190-E2",
            "PR-EJB",
            114,
            56450,
            "Пасажирський регiональний"
        );

        for (Plane plane : planes) {
            plane.printInfo();
        }

        Arrays.sort(planes, (o1, o2) -> Double.compare(o1.passengerCapacity, o2.passengerCapacity));

        System.out.println("Сортування за пасажиромiсткiстю (зростання):");
        for (Plane plane : planes) {
            plane.printInfo();
        }

        Arrays.sort(planes, (o1, o2) -> Integer.compare(o2.maxTakeOffWeight, o1.maxTakeOffWeight));

        System.out.println("\nСортування за вантажопiдйомнiстю (спадання):");
        for (Plane plane : planes) {
            plane.printInfo();
        }
    }
    
}
