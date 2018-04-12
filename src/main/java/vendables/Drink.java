package vendables;

public class Drink implements IVend {

    private String name;
    private int price;
    private int volume;

    public Drink(String name, int price, int volume){
//        super(name, price);
        this.price = price;
        this.name = name;
        this.volume = volume;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }
    public int getVolume(){
        return this.volume;
    }
}
