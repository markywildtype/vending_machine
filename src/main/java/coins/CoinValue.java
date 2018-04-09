package coins;

public enum CoinValue {
    NICKEL(5),
    DIME(10),
    QUARTER(25),
    DOLLAR(100);

    private final int value;

    CoinValue(int value){
        this.value = value;
    }

    public int numericalValue() {
        return value;
    }
}
