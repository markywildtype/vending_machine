package vendables;

public abstract class VendableItem {

    private String name;
    private int price;

    public VendableItem(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
