package attestation.attestation01;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private double money;
    private List<Product> bag;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.bag = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Имя не может быть пустым");
            System.exit(1);
        }
        if (name.length() < 3) {
            System.out.println("Имя не может быть короче 3 символов");
            System.exit(1);
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        if (money < 0) {
            System.out.println("Деньги не могут быть отрицательными");
            System.exit(1);
        }
        this.money = money;
    }

    public List<Product> getBag() {
        return bag;
    }

    public boolean canAfford(Product product) {
        return money >= product.getPrice();
    }

    public void buyProduct(Product product) {
        bag.add(product);
        money -= product.getPrice();
    }

    @Override
    public String toString() {
        if (bag.isEmpty()) {
            return name + " (баланс: " + money + ") - Ничего не куплено";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (баланс: ").append(money).append(") - Купленные продукты:\n");
        for (Product product : bag) {
            sb.append("- ").append(product).append("\n");
        }
        return sb.toString();
    }
}
