package ru.rtk.java.homeworks.homework6;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> customers = new LinkedHashMap<>();
        List<AbstractProduct> availableProducts = new ArrayList<>();

        // Ввод покупателей
        System.out.println("Введите покупателей в формате 'Имя = баланс'");
        System.out.println("Для завершения введите 'END'");
        while (true) {
            System.out.print("Введите покупателя> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) {
                break;
            }

            try {
                String[] parts = input.split("=");
                if (parts.length != 2) throw new IllegalArgumentException();

                String name = parts[0].trim();
                double balance = Double.parseDouble(parts[1].trim());
                customers.put(name, new Person(name, balance));
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Используйте: Имя = баланс");
            }
        }

        // Ввод продуктов
        System.out.println("\nВведите продукты (1 - обычный, 2 - со скидкой)");
        System.out.println("Формат: 'Название = цена' (обычный)");
        System.out.println("Формат: 'Название = базовая цена = скидка = дата(ГГГГ-ММ-ДД)' (со скидкой)");
        System.out.println("Для завершения введите 'END'");
        while (true) {
            System.out.print("Введите продукт> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) {
                break;
            }

            try {
                String[] parts = input.split("=");
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }

                if (parts.length == 2) {
                    // Обычный продукт
                    double price = Double.parseDouble(parts[1]);
                    availableProducts.add(new Product(parts[0], price));
                }
                else if (parts.length == 4) {
                    // Скидочный продукт
                    double basePrice = Double.parseDouble(parts[1]);
                    double discount = Double.parseDouble(parts[2]);
                    LocalDate endDate = LocalDate.parse(parts[3]);

                    try {
                        availableProducts.add(new DiscountProduct(parts[0], basePrice, discount, endDate));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка создания продукта: " + e.getMessage());
                        continue;
                    }
                }
                else {
                    throw new IllegalArgumentException("Неверное количество параметров");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат числа");
            }
            catch (DateTimeParseException e) {
                System.out.println("Ошибка: неверный формат даты. Используйте ГГГГ-ММ-ДД");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // Вывод списков
        System.out.println("\nСписок покупателей:");
        customers.values().forEach(c -> System.out.println(c.getName() + " = " + c.getMoney() + " руб."));

        System.out.println("\nСписок продуктов:");
        availableProducts.forEach(System.out::println);

        // Обработка покупок
        System.out.println("\nВводите покупки в формате 'Имя покупателя = Название продукта'");
        System.out.println("Для завершения введите 'END'");
        while (true) {
            System.out.print("Введите покупку> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) {
                break;
            }

            // Разделяем только по первому знаку '='
            int equalSignIndex = input.indexOf('=');
            if (equalSignIndex == -1) {
                System.out.println("Ошибка ввода. Используйте: Имя покупателя = Название продукта");
                continue;
            }

            String customerName = input.substring(0, equalSignIndex).trim();
            String productName = input.substring(equalSignIndex + 1).trim();

            Person customer = customers.get(customerName);
            if (customer == null) {
                System.out.println("Покупатель '" + customerName + "' не найден");
                continue;
            }

            AbstractProduct product = availableProducts.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(productName))
                    .findFirst()
                    .orElse(null);

            if (product == null) {
                System.out.println("Продукт '" + productName + "' не найден");
                continue;
            }

            if (customer.canAfford(product)) {
                customer.buyProduct(product);
                System.out.println(customer.getName() + " купил(а) " + product);
            } else {
                System.out.println(customer.getName() + " не может позволить себе " + product);
            }

            // Итоговый вывод
            System.out.println("\nИтоговые результаты:");
            customers.values().forEach(System.out::println);
        }
    }
}
