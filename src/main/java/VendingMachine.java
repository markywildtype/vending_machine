import coins.Coin;
import racks.Rack;
import vendables.VendableItem;

import java.util.ArrayList;

public class VendingMachine {

    private Rack rack1;
    private Rack rack2;
    private Rack rack3;
    private ArrayList<Coin> coinsPending;
    private ArrayList<Coin> coinsRetained;
    private ArrayList<Coin> changeSlot;
    private boolean serviceMode;

    public VendingMachine(Rack rack1, Rack rack2, Rack rack3){
        this.rack1 = rack1;
        this.rack2 = rack2;
        this.rack3 = rack3;
        this.coinsPending = new ArrayList<>();
        this.coinsRetained = new ArrayList<>();
        this.changeSlot = new ArrayList<>();
        this.serviceMode = false;
    }


    public ArrayList<Coin> getCoinsPending(){
        return this.coinsPending;
    }

    public int getCoinsPendingValue(){
        int coinValue = 0;
        for(Coin coin: coinsPending){
            coinValue += coin.getValue().numericalValue();
        }
        return coinValue;
    }

    public ArrayList<Coin> getCoinsRetained(){
        return this.coinsRetained;
    }

    public int getCoinsRetainedValue(){
        int coinValue = 0;
        for(Coin coin: coinsRetained){
            coinValue += coin.getValue().numericalValue();
        }
        return coinValue;
    }

    public void insertCoin(Coin coin) {
        this.coinsPending.add(coin);
    }

//Overloaded method for selecting rack first then adding coins:

    public VendableItem insertCoin(Coin coin, Rack rack) {
        this.coinsPending.add(coin);
        VendableItem item = (VendableItem) rack.getRackContents().get(0);
        if(rack.getSelectedStatus() == true && this.getCoinsPendingValue() >= item.getPrice()){
            return retainCoinsDispenseItem(rack);
        }
        return null;
    }

    public VendableItem selectRack(Rack rack){
        rack.selectRack();
        VendableItem item = (VendableItem) rack.getRackContents().get(0);
        if(this.getCoinsPendingValue() == item.getPrice()){
            return retainCoinsDispenseItem(rack);
        }
        return null;
    }

    public VendableItem retainCoinsDispenseItem(Rack rack){
        this.coinsRetained.addAll(this.coinsPending);
        this.coinsPending.clear();
        return (VendableItem) rack.dispenseItem();
    }

    public ArrayList<Coin> getChangeSlot(){
        return this.changeSlot;
    }

    public int getChangeSlotValue(){
        int coinValue = 0;
        for(Coin coin: this.changeSlot){
            coinValue += coin.getValue().numericalValue();
        }
        return coinValue;
    }

    public void coinReturn(){
        this.changeSlot.addAll(this.coinsPending);
        this.coinsPending.clear();
    }

    public boolean getServiceMode(){
        return this.serviceMode;
    }

    public void toggleServiceMode(){
        if(this.serviceMode == false){
            this.serviceMode = true;
        } else {
            this.serviceMode = false;
        }
    }

    public void addToCoinsRetained(Coin coin){
        if(this.serviceMode == true) {
            this.coinsRetained.add(coin);
        }
    }
}
