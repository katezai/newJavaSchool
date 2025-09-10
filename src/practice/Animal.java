package practice;

public class Animal {
    private String name;

public Animal(String name) {
    this.name = name; /* указали что поле name явно относится к объекту данного класса
    или можно сделать (String n) {
    name = n;
    } */
}

private Animal() {} // конструктор становится приватным

    public Animal createClass() {
    return new Animal(); // таким образом ссылаемся на приватный конструктор
    }

    public void setName(String name) {
    this.name = name;
    }

    public String getName() {
    return name;
    }
    }

