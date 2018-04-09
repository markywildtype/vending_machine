package vendables;

public class Drink extends VendableItem implements IVend {

    private int volume;

    public Drink(String name, int price, int volume) {
        super(name, price);
        this.volume = volume;
    }

    public int getVolume() {
        return this.volume;
    }
}
