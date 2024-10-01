package House;

public class House {
    private int id;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int numberOfRooms;
    private String street;

    // Конструктор
    public House(int id, int apartmentNumber, double area, int floor, int numberOfRooms, String street) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.street = street;
    }

    // Методи доступу
    public int getId() {
        return id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getStreet() {
        return street;
    }

    // Метод toString для виведення деталей об'єкта
    @Override
    public String toString() {
        return "Квартира{" +
                "ID=" + id +
                ", Номер квартири=" + apartmentNumber +
                ", Площа=" + area +
                ", Поверх=" + floor +
                ", Кількість кімнат=" + numberOfRooms +
                ", Вулиця='" + street + '\'' +
                '}';
    }
}
