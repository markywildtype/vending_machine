import vendables.Crisps;
import vendables.IVend;
import vendables.Sweet;

import java.util.ArrayList;
import java.util.BitSet;

public class Rack {

    private ArrayList<IVend> rackContents;
    private boolean selectedStatus;

    public Rack(){
        this.rackContents = new ArrayList<>(5);
        this.selectedStatus = false;

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
}
