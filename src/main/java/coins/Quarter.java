package coins;

public class Quarter implements ICoin {

    private int coinValue;

    public Quarter(){
        this.coinValue = 25;
    }

    public int getCoinValue(){
        return this.coinValue;
    }

}
