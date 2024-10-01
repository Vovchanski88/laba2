package Main;
import House.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<House> houses = new ArrayList<>();
        houses.add(new House(1, 101, 75.0, 2, 3, "Шевченка"));
        houses.add(new House(2, 202, 100.0, 5, 4, "Лесі Українки"));
        houses.add(new House(3, 303, 60.0, 1, 2, "Франка"));
        houses.add(new House(4, 404, 85.0, 3, 3, "Грушевського"));
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Додати квартиру");
            System.out.println("2. Показати всі квартири");
            System.out.println("3. Показати квартири з певною кількістю кімнат");
            System.out.println("4. Показати квартири з певною кількістю кімнат і діапазоном поверхів");
            System.out.println("5. Показати квартири з площею більшою за задану");
            System.out.println("0. Вийти");
            System.out.print("Виберіть дію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addHouse(scanner, houses);
                    break;
                case 2:
                    showAllHouses(houses);
                    break;
                case 3:
                    filterByNumberOfRooms(scanner, houses);
                    break;
                case 4:
                    filterByRoomsAndFloorRange(scanner, houses);
                    break;
                case 5:
                    filterByArea(scanner, houses);
                    break;
                case 0:
                    System.out.println("Вихід з програми.");
                    break;
                default:
                    System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        } while (choice != 0);
    }

    // Метод для додавання квартири
    private static void addHouse(Scanner scanner, List<House> houses) {
        System.out.print("Введіть ID: ");
        int id = scanner.nextInt();
        while(IsHouseIdExists(houses, id)){
            System.out.println("Будинок з таким номером вже існує!");
            id = scanner.nextInt();
        }
        System.out.print("Введіть номер квартири: ");
        int apartmentNumber = scanner.nextInt();
        System.out.print("Введіть площу: ");
        double area = scanner.nextDouble();
        System.out.print("Введіть поверх: ");
        int floor = scanner.nextInt();
        System.out.print("Введіть кількість кімнат: ");
        int numberOfRooms = scanner.nextInt();
        scanner.nextLine();  // Спожити залишок нового рядка
        System.out.print("Введіть назву вулиці: ");
        String street = scanner.nextLine();

        House newHouse = new House(id, apartmentNumber, area, floor, numberOfRooms, street);
        houses.add(newHouse);
        System.out.println("Квартира додана успішно.\n");
    }

    // Метод для показу всіх квартир
    private static void showAllHouses(List<House> houses) {
        if (houses.isEmpty()) {
            System.out.println("Немає доданих квартир.");
        } else {
            System.out.println("Усі квартири:");
            for (House house : houses) {
                System.out.println(house);
            }
        }
        System.out.println();
    }

    // Метод для фільтрації квартир за кількістю кімнат
    private static void filterByNumberOfRooms(Scanner scanner, List<House> houses) {
        System.out.print("Введіть кількість кімнат: ");
        int rooms = scanner.nextInt();
        int n = 0;

        System.out.println("Квартири з " + rooms + " кімнатами:");
        for (House house : houses) {
            if (house.getNumberOfRooms() == rooms) {
                System.out.println(house);
                n++;
            }
        }
        if (n==0){
            System.out.println("Немає квартир з заданою кількістю кімнат.");
        }
        System.out.println();
    }

    // Метод для фільтрації квартир за кількістю кімнат і поверхом
    private static void filterByRoomsAndFloorRange(Scanner scanner, List<House> houses) {
        System.out.print("Введіть кількість кімнат: ");
        int rooms = scanner.nextInt();
        System.out.print("Введіть мінімальний поверх: ");
        int minFloor = scanner.nextInt();
        System.out.print("Введіть максимальний поверх: ");
        int maxFloor = scanner.nextInt();
        int n = 0;

        System.out.println("Квартири з " + rooms + " кімнатами на поверхах від " + minFloor + " до " + maxFloor + ":");
        for (House house : houses) {
            if (house.getNumberOfRooms() == rooms && house.getFloor() >= minFloor && house.getFloor() <= maxFloor) {
                System.out.println(house);
                n++;
            }
        }

        if (n==0){
            System.out.println("Немає квартир з заданою кількістю кімнат у вказаному діапазоні поверхів.");
        }
        System.out.println();
    }

    // Метод для фільтрації квартир за площею
    private static void filterByArea(Scanner scanner, List<House> houses) {
        System.out.print("Введіть мінімальну площу: ");
        double area = scanner.nextDouble();
        int n = 0;

        System.out.println("Квартири з площею більше " + area + ":");
        for (House house : houses) {
            if (house.getArea() > area) {
                System.out.println(house);
                n++;
            }
        }
        if (n==0){
            System.out.println("Немає квартир з площею більше ніж " + area + ".");
        }
        System.out.println();
    }
    public static boolean IsHouseIdExists(List<House> Houses,int id){
        for(House house : Houses){
            if(house.getId() == id){
                return true;
            }
        }
        return false;
    }
}
