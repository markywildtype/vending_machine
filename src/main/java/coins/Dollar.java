package coins;

public class Dollar implements ICoin {

    private int coinValue;

    public Dollar(){
        this.coinValue = 100;
    }

    public int getCoinValue(){
        return this.coinValue;
    }

}
