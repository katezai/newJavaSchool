package ru.rtk.java.homeworks.homework8.repository;

import ru.rtk.java.homeworks.homework8.model.Car;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface CarsRepository {
    // Основные операции
    void addCar(Car car);
    void removeCar(String number);
    Optional<Car> findCarByNumber(String number);
    List<Car> getAllCars();

    // Методы для Stream API операций
    List<String> findNumbersByColorOrZeroMileage(String color, int mileage);
    long countUniqueModelsInPriceRange(double minPrice, double maxPrice);
    List<String> getUniqueModelsInPriceRange(double minPrice, double maxPrice);
    Optional<String> findColorOfMinPriceCar();
    OptionalDouble findAveragePriceByModel(String model);

    // Методы для работы с файлами
    void saveToFile(String filename);
    void loadFromFile(String filename);
}
