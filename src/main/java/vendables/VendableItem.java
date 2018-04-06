package vendables;

public abstract class VendableItem {

    private String name;
    private double price;

    public VendableItem(String name, double price){
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
