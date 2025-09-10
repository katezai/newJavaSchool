package ru.rtk.java.homeworks.homework6;

abstract class AbstractProduct {
    protected String name;
    protected double basePrice;

    public AbstractProduct(String name, double basePrice) {
        validateName(name);
        validatePrice(basePrice);
        this.name = name;
        this.basePrice = basePrice;
    }

    protected void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Название продукта должно содержать минимум 3 символа");
        }
        if (name.matches("\\d+")) {
            throw new IllegalArgumentException("Название продукта не может состоять только из цифр");
        }
    }

    protected void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть положительной");
        }
    }

    public String getName() { return name; }
    public abstract double getPrice();
}
