package vendables;

public abstract class Vendable {

    private String name;
    private double price;

    public Vendable(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
