package ru.rtk.java.homeworks.homework8.repository;

import ru.rtk.java.homeworks.homework8.model.Car;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CarsRepositoryImpl implements CarsRepository {
    private List<Car> cars = new ArrayList<>();

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void removeCar(String number) {
        cars.removeIf(car -> car.getNumber().equals(number));
    }

    @Override
    public Optional<Car> findCarByNumber(String number) {
        return cars.stream()
                .filter(car -> car.getNumber().equals(number))
                .findFirst();
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public List<String> findNumbersByColorOrZeroMileage(String color, int mileage) {
        return cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color) || car.getMileage() == mileage)
                .map(Car::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public long countUniqueModelsInPriceRange(double minPrice, double maxPrice) {
        return cars.stream()
                .filter(car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice)
                .map(car -> car.getModel() + " | " + car.getColor() + " | " + car.getMileage())
                .distinct()
                .count();
    }

    @Override
    public List<String> getUniqueModelsInPriceRange(double minPrice, double maxPrice) {
        return cars.stream()
                .filter(car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice)
                .map(car -> car.getModel() + " | " + car.getColor() + " | " + car.getMileage())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<String> findColorOfMinPriceCar() {
        return cars.stream()
                .min(Comparator.comparingDouble(Car::getPrice))
                .map(Car::getColor);
    }

    @Override
    public OptionalDouble findAveragePriceByModel(String model) {
        return cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(model))
                .mapToDouble(Car::getPrice)
                .average();
    }

    @Override
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Car car : cars) {
                writer.println(carToCsv(car));
            }
            System.out.println("Данные успешно сохранены в файл: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile(String filename) {
        cars.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Car car = csvToCar(line);
                if (car != null) {
                    cars.add(car);
                }
            }
            System.out.println("Данные успешно загружены из файла: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке из файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка формата данных в файле: " + e.getMessage());
        }
    }

    private String carToCsv(Car car) {
        return String.join(",",
                car.getNumber(),
                car.getModel(),
                car.getColor(),
                String.valueOf(car.getMileage()),
                String.valueOf(car.getPrice())
        );
    }

    private Car csvToCar(String csvLine) {
        try {
            String[] parts = csvLine.split(",");
            if (parts.length != 5) {
                throw new IllegalArgumentException("Неверный формат строки: " + csvLine);
            }

            return new Car(
                    parts[0].trim(),
                    parts[1].trim(),
                    parts[2].trim(),
                    Integer.parseInt(parts[3].trim()),
                    Double.parseDouble(parts[4].trim())
            );
        } catch (Exception e) {
            System.err.println("Ошибка преобразования строки: " + csvLine + " - " + e.getMessage());
            return null;
        }
    }
}
