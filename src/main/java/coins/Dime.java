package coins;

public class Dime implements ICoin {

    private int coinValue;

    public Dime(){
        this.coinValue = 10;
    }

    public int getCoinValue(){
        return this.coinValue;
    }

}
