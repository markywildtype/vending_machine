package vendables;

public class Drink extends VendableItem {

    private int volume;

    public Drink(String name, double price, int volume) {
        super(name, price);
        this.volume = volume;
    }

    public int getVolume() {
        return this.volume;
    }
}
