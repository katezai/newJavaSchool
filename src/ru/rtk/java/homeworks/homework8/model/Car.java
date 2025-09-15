package ru.rtk.java.homeworks.homework8.model;

public class Car {
    private String number;    // Номер автомобиля
    private String model;     // Модель
    private String color;     // Цвет
    private int mileage;      // Пробег
    private double price;     // Стоимость

    // Конструктор
    public Car(String number, String model, String color, int mileage, double price) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    // Геттеры и сеттеры
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return String.format("Car{number='%s', model='%s', color='%s', mileage=%d, price=%.2f}",
                number, model, color, mileage, price);
    }

    // Переопределение equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number.equals(car.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}