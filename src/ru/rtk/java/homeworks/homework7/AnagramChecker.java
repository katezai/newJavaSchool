package ru.rtk.java.homeworks.homework7;

import java.util.Scanner;
import java.util.Arrays;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String s = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        System.out.print("Введите вторую строку: ");
        String t = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        boolean result = isAnagram(s, t);
        System.out.println(result);

        scanner.close();
    }

    public static boolean isAnagram(String s, String t) {
        // Если длины строк разные, это не может быть анаграмма
        if (s.length() != t.length()) {
            return false;
        }

        // Преобразуем строки в массивы символов и сортируем их
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Сравниваем отсортированные массивы
        return Arrays.equals(sArray, tArray);
    }
}
