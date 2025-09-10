package ru.rtk.java.homeworks.homework7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UniqueElements {

    /**
     * Метод возвращает набор уникальных элементов из ArrayList
     * @param <T> тип элементов
     * @param list входной ArrayList
     * @return Set уникальных элементов
     */
    public static <T> Set<T> getUniqueElements(ArrayList<T> list) {
        // HashSet автоматически удаляет дубликаты
        return new HashSet<>(list);
    }

    // Пример использования
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(Integer.valueOf(1));
        numbers.add(Integer.valueOf(1));
        numbers.add(Integer.valueOf(2));
        numbers.add(Integer.valueOf(3));
        numbers.add(Integer.valueOf(4));
        numbers.add(Integer.valueOf(4));
        numbers.add(Integer.valueOf(5));

        Set<Integer> uniqueNumbers = getUniqueElements(numbers);
        System.out.println("Исходный список: " + numbers);
        System.out.println("Уникальные элементы: " + uniqueNumbers);
    }
    }
