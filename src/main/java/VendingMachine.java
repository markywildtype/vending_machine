import coins.*;
import racks.Rack;
import vendables.IVend;
import vendables.VendableItem;

import java.util.ArrayList;
import java.util.Iterator;

public class VendingMachine {

    private ArrayList<Rack> racks;
    private ArrayList<ICoin> coinsPending;
    private ArrayList<ICoin> coinsRetained;
    private ArrayList<ICoin> changeSlot;
    private boolean serviceMode;

    public VendingMachine(Rack rack1, Rack rack2, Rack rack3){
        this.racks = new ArrayList<>();
        this.racks.add(rack1);
        this.racks.add(rack2);
        this.racks.add(rack3);
        this.coinsPending = new ArrayList<>();
        this.coinsRetained = new ArrayList<>();
        this.changeSlot = new ArrayList<>();
        this.serviceMode = false;
    }

//Getters:

    public ArrayList<Rack> getRacks(){
        return this.racks;
    }

    public Rack getSelectedRack(){
        for(Rack rack: racks){
            if(rack.getSelectedStatus()){
                return rack;
            }
        }
        return null;
    }

    public ArrayList<ICoin> getCoinsPending(){
        return this.coinsPending;
    }

    public int getCoinsPendingValue(){
        int coinValue = 0;
        for(ICoin coin: coinsPending){
            coinValue += coin.getCoinValue();
        }
        return coinValue;
    }

    public ArrayList<ICoin> getCoinsRetained(){
        return this.coinsRetained;
    }

    public int getCoinsRetainedValue(){
        int coinValue = 0;
        for(ICoin coin: coinsRetained){
            coinValue += coin.getCoinValue();
        }
        return coinValue;
    }

    public ArrayList<ICoin> getChangeSlot(){
        return this.changeSlot;
    }

    public int getChangeSlotValue(){
        int coinValue = 0;
        for(ICoin coin: this.changeSlot){
            coinValue += coin.getCoinValue();
        }
        return coinValue;
    }

    public void insertCoin(ICoin coin) {
        this.coinsPending.add(coin);
    }

//Methods for paying/dispensing items:
//Overloaded method for selecting rack first then adding coins:

    public IVend insertCoin(ICoin coin, Rack rack) {
        this.coinsPending.add(coin);
        IVend item = rack.getRackContents().get(0);
        if(rack.getSelectedStatus() && this.getCoinsPendingValue() >= item.getPrice()){
            return retainCoinsDispenseItem(rack);
        }
        return null;
    }

    public IVend selectRack(Rack rack){
        rack.selectRack();
        IVend item = rack.getRackContents().get(0);
        if(this.getCoinsPendingValue() == item.getPrice()){
            return retainCoinsDispenseItem(rack);
        } else if(this.getCoinsPendingValue() > item.getPrice()){
            makeChange(item);
            return retainCoinsDispenseItem(rack);
        }
            return null;
    }

    public IVend retainCoinsDispenseItem(Rack rack){
        this.coinsRetained.addAll(this.coinsPending);
        this.coinsPending.clear();
        return rack.dispenseItem();
    }

//Methods for generating change and removing it from coinsRetained:

    public void makeChange(IVend item){
        int difference = this.getCoinsPendingValue() - item.getPrice();
        int iterations = difference / 25;
        switch(difference % 25){
            case 0:
                changeWhileLoop(iterations);
                break;
            case 5:
                changeWhileLoop(iterations);
                this.changeSlot.add(new Nickel());
                coinsRetainedChangeRemover(5);
                break;
            case 10:
                changeWhileLoop(iterations);
                this.changeSlot.add(new Dime());
                coinsRetainedChangeRemover(10);
                break;
            case 15:
                changeWhileLoop(iterations);
                this.changeSlot.add(new Dime());
                coinsRetainedChangeRemover(10);
                this.changeSlot.add(new Nickel());
                coinsRetainedChangeRemover(5);
                break;
            case 20:
                changeWhileLoop(iterations);
                this.changeSlot.add(new Dime());
                coinsRetainedChangeRemover(10);
                this.changeSlot.add(new Dime());
                coinsRetainedChangeRemover(10);
                break;
        }
    }

    public void changeWhileLoop(int iterations){
        while(iterations > 0) {
            changeSlot.add(new Quarter());
            coinsRetainedChangeRemover(25);
            iterations--;
        }
    }

    public void coinsRetainedChangeRemover(int coinValue) {
        Iterator<ICoin> iter = this.coinsRetained.iterator();
        while (iter.hasNext()) {
            ICoin c = iter.next();
            if (c.getCoinValue() == coinValue) iter.remove();
        }
    }

    public void coinReturn(){
        this.changeSlot.addAll(this.coinsPending);
        this.coinsPending.clear();
    }


//Service mode methods:

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

    public void addToCoinsRetained(ICoin coin){
        if(this.serviceMode == true){
            this.coinsRetained.add(coin);
        }
    }

//Overloaded method to add multiple coins:

    public void addToCoinsRetained(ArrayList<ICoin> coinArrayList){
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
