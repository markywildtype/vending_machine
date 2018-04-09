import coins.Coin;
import racks.Rack;
import vendables.IVend;
import vendables.VendableItem;

import java.util.ArrayList;

public class VendingMachine {

    private Rack rack1;
    private Rack rack2;
    private Rack rack3;
    private ArrayList<Coin> coinsPending;

    public VendingMachine(Rack rack1, Rack rack2, Rack rack3){
        this.rack1 = rack1;
        this.rack2 = rack2;
        this.rack3 = rack3;
        this.coinsPending = new ArrayList<>();
    }

    public int getCoinsPending(){
        int coinValue = 0;
        for(Coin coin: coinsPending){
            coinValue += coin.getValue().numericalValue();
        }
        return coinValue;
    }

    public void insertCoin(Coin coin) {
        this.coinsPending.add(coin);
    }

    public VendableItem selectRack(Rack rack) {
        rack.selectRack();
        VendableItem item = (VendableItem) rack.getRackContents().get(0);
        if (this.getCoinsPending() >= item.getPrice()){
        } return (VendableItem) rack.dispenseItem();
    }
}
