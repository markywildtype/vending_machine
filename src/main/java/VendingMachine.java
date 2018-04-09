import coins.Coin;
import coins.CoinValue;
import racks.Rack;
import vendables.Crisps;
import vendables.IVend;
import vendables.VendableItem;

import java.util.ArrayList;
import java.util.BitSet;

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
        } else if(this.getCoinsPendingValue() > item.getPrice()){
            makeChange(item);
            }
            return retainCoinsDispenseItem(rack);
    }

    public VendableItem retainCoinsDispenseItem(Rack rack){
        this.coinsRetained.addAll(this.coinsPending);
        this.coinsPending.clear();
        return (VendableItem) rack.dispenseItem();
    }

    public void makeChange(VendableItem item){
        int difference = this.getCoinsPendingValue() - item.getPrice();

        switch(difference % 25){
            case 0:
                int iterations = difference / 25;
                while(iterations > 0) {
                    changeSlot.add(new Coin(CoinValue.QUARTER));
                    iterations--;
                }
                break;
            case 5:
                int iterations2 = difference / 25;
                while(iterations2 > 0){
                    changeSlot.add(new Coin(CoinValue.QUARTER));
                    iterations2--;
                }
                changeSlot.add(new Coin(CoinValue.NICKEL));
                break;
            case 10:
                int iterations3 = difference / 25;
                while(iterations3 > 0){
                    changeSlot.add(new Coin(CoinValue.QUARTER));
                    iterations3--;
                }
                changeSlot.add(new Coin(CoinValue.DIME));
                break;
            case 15:
                int iterations4 = difference / 25;
                while(iterations4 > 0){
                    changeSlot.add(new Coin(CoinValue.QUARTER));
                    iterations4--;
                }
                changeSlot.add(new Coin(CoinValue.DIME));
                changeSlot.add(new Coin(CoinValue.NICKEL));
                break;
            case 20:
                int iterations5 = difference / 25;
                while(iterations5 > 0){
                    changeSlot.add(new Coin(CoinValue.QUARTER));
                    iterations5--;
                }
                changeSlot.add(new Coin(CoinValue.DIME));
                changeSlot.add(new Coin(CoinValue.DIME));
                break;
        }
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
        if(this.serviceMode == true){
            this.coinsRetained.add(coin);
        }
    }

//Overloaded method to add multiple coins:

    public void addToCoinsRetained(ArrayList<Coin> coinArrayList){
        if(this.serviceMode == true){
            this.coinsRetained.addAll(coinArrayList);
        }
    }

    public void addToRack(Rack rack, IVend item){
        if(serviceMode == true) {
            rack.addItem(item);
        }
    }

//Overloaded method to add multiple items to a rack:

    public void addToRack(Rack rack, ArrayList<IVend> itemArrayList){
        if(serviceMode == true){
            rack.addMultiple(itemArrayList);
        }
    }

    public ArrayList<IVend> getRackContents(Rack rack){
        return rack.getRackContents();
    }
}
