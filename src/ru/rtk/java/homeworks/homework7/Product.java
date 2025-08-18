package ru.rtk.java.homeworks.homework7;

class Product extends AbstractProduct {
    public Product(String name, double price) {
        super(name, price);
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return name + " (цена: " + basePrice + ")";
    }
}