package ru.rtk.java.homeworks.homework3;

import java.util.Scanner;
import java.util.Random;

public class homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Привет, имя_пользователя: ");
        String name = sc.nextLine();
        System.out.println("Привет, " + name + "!");
    }

    // это ИИ, а не я, просто было интересно попробовать, сама я так не напишу пока

    public static class RockPaperScissors {
        public static void main(String[] args) {
            // Создаем генератор случайных чисел
            Random random = new Random();

            // Генерируем выбор Васи и Пети (0 - камень, 1 - ножницы, 2 - бумага)
            int vasyaChoice = random.nextInt(3);
            int petyaChoice = random.nextInt(3);

            // Выводим выбор игроков
            System.out.println("Вася показал: " + getChoiceName(vasyaChoice));
            System.out.println("Петя показал: " + getChoiceName(petyaChoice));

            // Определяем победителя
            if (vasyaChoice == petyaChoice) {
                System.out.println("Ничья!");
            } else if ((vasyaChoice == 0 && petyaChoice == 1) ||
                    (vasyaChoice == 1 && petyaChoice == 2) ||
                    (vasyaChoice == 2 && petyaChoice == 0)) {
                System.out.println("Вася выиграл!");
            } else {
                System.out.println("Петя выиграл!");
            }
        }

        // Вспомогательный метод для преобразования числа в название фигуры
        private static String getChoiceName(int choice) {
            switch (choice) {
                case 0: return "камень";
                case 1: return "ножницы";
                case 2: return "бумага";
                default: return "неизвестно";
            }
        }
    }
}

