package ru.rtk.java.homeworks.homework8.test;

import ru.rtk.java.homeworks.homework8.model.Car;
import ru.rtk.java.homeworks.homework8.repository.CarsRepository;
import ru.rtk.java.homeworks.homework8.repository.CarsRepositoryImpl;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        // Создаем репозиторий
        CarsRepository repository = new CarsRepositoryImpl();

        // Добавляем тестовые данные
        initializeTestData(repository);

        // Сохраняем данные в файл
        repository.saveToFile("C:/Users/user/IdeaProjects/newJavaSchool/src/ru/rtk/java/homeworks/homework8/data/cars.txt");

        // Переменные для поиска
        String colorToFind = "Black";
        int mileageToFind = 0;
        double minPriceRange = 700000;
        double maxPriceRange = 800000;
        String modelToFind = "Toyota";

        // Выполняем операции через репозиторий
        System.out.println("=== РЕЗУЛЬТАТЫ ОПЕРАЦИЙ ===");

        // 1) Номера автомобилей по цвету или нулевому пробегу
        System.out.println("\n1) Автомобили цвета '" + colorToFind + "' или с нулевым пробегом:");
        System.out.println("Номера: " + repository.findNumbersByColorOrZeroMileage(colorToFind, mileageToFind));

        // 2) Количество уникальных моделей в ценовом диапазоне
        System.out.println("\n2) Уникальные модели в диапазоне цен от " +
                (minPriceRange/1000) + " до " + (maxPriceRange/1000) + " тыс.:");
        long uniqueCombinations = repository.countUniqueModelsInPriceRange(minPriceRange, maxPriceRange);
        System.out.println("Количество уникальных комбинаций: " + uniqueCombinations);

        System.out.println("Список уникальных комбинаций:");
        repository.getUniqueModelsInPriceRange(minPriceRange, maxPriceRange)
                .forEach(System.out::println);

        // 3) Цвет автомобиля с минимальной стоимостью
        System.out.println("\n3) Цвет автомобиля с минимальной стоимостью:");
        Optional<String> minPriceColor = repository.findColorOfMinPriceCar();
        minPriceColor.ifPresentOrElse(
                color -> System.out.println("Цвет: " + color),
                () -> System.out.println("Автомобили не найдены")
        );

        // 4) Средняя стоимость искомой модели
        System.out.println("\n4) Средняя стоимость модели '" + modelToFind + "':");
        OptionalDouble averagePrice = repository.findAveragePriceByModel(modelToFind);
        if (averagePrice.isPresent()) {
            System.out.println("Средняя цена: " + averagePrice.getAsDouble());
        } else {
            System.out.println("Модель не найдена");
        }

        // Демонстрация загрузки из файла
        System.out.println("\n=== ЗАГРУЗКА ИЗ ФАЙЛА ===");
        CarsRepository loadedRepository = new CarsRepositoryImpl();
        loadedRepository.loadFromFile("cars.txt");

        System.out.println("Загруженные автомобили:");
        loadedRepository.getAllCars().forEach(System.out::println);
    }

    private static void initializeTestData(CarsRepository repository) {
        // Добавляем тестовые данные
        repository.addCar(new Car("a123me", "Mercedes", "White", 0, 8300000));
        repository.addCar(new Car("b873of", "Volga", "Black", 0, 673000));
        repository.addCar(new Car("w487mn", "Lexus", "Grey", 76000, 900000));
        repository.addCar(new Car("p987hj", "Volga", "Red", 610, 704340));
        repository.addCar(new Car("c987ss", "Toyota", "White", 254000, 761000));
        repository.addCar(new Car("o983op", "Toyota", "Black", 698000, 740000));
        repository.addCar(new Car("p146op", "BMW", "White", 271000, 850000));
        repository.addCar(new Car("u893ii", "Toyota", "Purple", 210900, 440000));
        repository.addCar(new Car("l097df", "Toyota", "Black", 108000, 780000));
        repository.addCar(new Car("y876wd", "Toyota", "Black", 160000, 1000000));
    }
}