package attestation.attestation01;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> customers = new LinkedHashMap<>();
        List<Product> availableProducts = new ArrayList<>();

        // Ввод покупателей
        System.out.println("Введите покупателей в формате 'Имя = Баланс'");
        System.out.println("Для завершения введите 'CUSTOMERS END'");
        while (true) {
            System.out.print("Введите покупателя> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("CUSTOMERS END")) {
                break;
            }

            // Разделяем по знаку '='
            String[] parts = input.split("=");
            if (parts.length != 2) {
                System.out.println("Неверный формат. Используйте: Имя = баланс");
                continue;
            }

            try {
                String name = parts[0].trim();
                double balance = Double.parseDouble(parts[1].trim());
                customers.put(name, new Person(name, balance));
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Используйте: Имя = баланс");
            }
        }

        // Ввод продуктов
        System.out.println("\nВведите продукты в формате 'Название = Цена'");
        System.out.println("Для завершения введите 'PRODUCTS END'");
        while (true) {
            System.out.print("Введите продукт> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("PRODUCTS END")) {
                break;
            }

            String[] parts = input.split("=");
            if (parts.length != 2) {
            System.out.println("Неверный формат. Используйте: 'Название = Цена'");
            continue;
            }
            try {
                String name = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());
                availableProducts.add(new Product(name, price));
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Используйте: Название = цена");
            }
        }

        System.out.println("\nСписок покупателей:");
        customers.values().forEach(customer ->
                System.out.println(customer.getName() + ": " + customer.getMoney() + " руб."));

        // Вывод списка продуктов
        System.out.println("\nСписок продуктов:");
        availableProducts.forEach(product ->
                System.out.println(product.getName() + ": " + product.getPrice() + " руб."));

        // Обработка покупок
        System.out.println("\nВводите покупки в формате 'Имя Покупателя - Название Продукта'");
        System.out.println("Для завершения введите 'END'");
        while (true) {
            System.out.print("Введите покупку> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) {
                break;
            }

            String[] parts = input.split("-");
            if (parts.length != 2) {
                System.out.println("Неверный формат. Используйте: Имя покупателя - Название продукта");
                continue;
            }

            String customerName = parts[0].trim();
            String productName = parts[1].trim();

            Person customer = customers.get(customerName);
            if (customer == null) {
                System.out.println("Покупатель '" + customerName + "' не найден");
                continue;
            }

            Product product = availableProducts.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(productName))
                    .findFirst()
                    .orElse(null);

            if (product == null) {
                System.out.println("Продукт '" + productName + "' не найден");
                continue;
            }

            if (customer.canAfford(product)) {
                customer.buyProduct(product);
                System.out.println(customerName + " купил(а) " + productName);
            } else {
                System.out.println(customerName + " не может позволить себе " + productName);
            }
        }

        // Итоговый вывод
        System.out.println("\nИтоговые результаты:");
        customers.values().forEach(System.out::println);
    }
}