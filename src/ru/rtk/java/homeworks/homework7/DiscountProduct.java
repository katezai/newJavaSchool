package ru.rtk.java.homeworks.homework7;

import java.time.LocalDate;

class DiscountProduct extends AbstractProduct {
    private double discount;
    private LocalDate discountEndDate;

    public DiscountProduct(String name, double basePrice, double discount, LocalDate discountEndDate) {
        super(name, basePrice);
        setDiscount(discount);
        this.discountEndDate = discountEndDate;
    }

    private void setDiscount(double discount) {
        if (discount <= 0) {
            throw new IllegalArgumentException("Скидка должна быть положительной");
        }
        if (discount >= basePrice) {
            throw new IllegalArgumentException("Скидка " + discount + " не может быть больше или равна базовой цене " + basePrice);
        }
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        if (LocalDate.now().isAfter(discountEndDate)) {
            return basePrice;
        }
        return basePrice - discount;
    }

    public double getDiscount() { return discount; }
    public LocalDate getDiscountEndDate() { return discountEndDate; }

    @Override
    public String toString() {
        String discountInfo = LocalDate.now().isAfter(discountEndDate) ?
                " (скидка истекла)" :
                " (скидка: " + discount + " до " + discountEndDate + ")";
        return name + " (цена: " + getPrice() + discountInfo + ")";
    }
}

