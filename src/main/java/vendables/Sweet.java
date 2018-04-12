package vendables;

public class Sweet implements IVend {

    private String name;
    private int price;

    public Sweet(String name, int price){
//        super(name, price);
        this.price = price;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }
}
