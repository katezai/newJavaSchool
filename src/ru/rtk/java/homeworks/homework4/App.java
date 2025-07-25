package ru.rtk.java.homeworks.homework4;

import java.util.Scanner;

class TV {
    // поля
    private String name1, name2;
    private String size1, size2;
    // конструктор
    public TV() {
        this.name1 = "LG";
        this.name2 = "Березка";
        this.size1 = "большой";
        this.size2 = "маленький";
    }
    // методы для вывода из приватных полей
    public String getName1() {
        return name1;
    }
    public String getName2() {
        return name2;
    }
    public String getSize1() {
        return size1;
    }

    public String getSize2() {
        return size2;
    }
}


public class App {
    public static void main(String[] args) {
        App app = new App();
TV tv = new TV();// создаем объект класса TV
System.out.println("В нашем магазине представлены следующие телевизоры: ");
System.out.println(tv.getName1() + "," + " " + tv.getSize1());
System.out.println(tv.getName2() + "," + " " + tv.getSize2());


Scanner scan = new Scanner(System.in);
System.out.print("Введите название телевизора, чтобы проверить его наличие: ");
String input = scan.nextLine();
if ("LG".equalsIgnoreCase(input)) {
    System.out.println("Данная модель в наличии");
}
else if ("Березка".equalsIgnoreCase(input)) {
    System.out.println("К сожалению, на данный момент модели нет на складе");
}
else {
    System.out.println("Данная модель не представлена в нашем магазине");
}
    }
}