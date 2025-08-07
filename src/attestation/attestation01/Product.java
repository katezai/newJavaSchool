package attestation.attestation01;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Название продукта не может быть пустым");
            System.exit(1);
        }
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Цена не может быть отрицательной");
            System.exit(1);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (цена: " + price + ")";
    }
}
