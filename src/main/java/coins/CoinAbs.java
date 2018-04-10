package coins;

public abstract class CoinAbs {

    private int coinValue;

    public CoinAbs(){
        this.coinValue = 0;
    }

    public int getValue() {
        return this.coinValue;
    }
}
