package coins;

public class Coin {

    private CoinValue coinValue;

    public Coin(CoinValue coinValue){
        this.coinValue = coinValue;
    }

    public CoinValue getValue() {
        return this.coinValue;
    }
}
