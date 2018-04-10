package coins;

public class Nickel implements ICoin {

    private int coinValue;

    public Nickel(){
        this.coinValue = 5;
    }

    public int getCoinValue(){
        return this.coinValue;
    }

}
