package racks;

import vendables.IVend;

import java.util.ArrayList;

public class Rack {

    private ArrayList<IVend> rackContents;
    private boolean selectedStatus;
    private RackIdentifier rackIdentifier;

    public Rack(RackIdentifier rackIdentifier){
        this.rackContents = new ArrayList<>(5);
        this.selectedStatus = false;
        this.rackIdentifier = rackIdentifier;

    }


    public ArrayList<IVend> getRackContents(){
        return this.rackContents;
    }

    public boolean getSelectedStatus(){
        return this.selectedStatus;
    }

    public void selectRack(){
        this.selectedStatus = true;
    }

    public void addItem(IVend item){
        if(this.rackContents.size() < 5) {
            this.rackContents.add(item);
        }
    }

    public IVend dispenseItem(){
        IVend dispensedItem = this.rackContents.remove(0);
        return dispensedItem;
    }

    public RackIdentifier getIdentifier(){
        return this.rackIdentifier;
    }

    public void addMultiple(ArrayList<IVend> itemArray){
        this.rackContents.addAll(itemArray);
    }
}
