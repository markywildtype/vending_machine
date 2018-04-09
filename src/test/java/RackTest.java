import org.junit.Before;
import org.junit.Test;
import racks.Rack;
import racks.RackIdentifier;
import vendables.Crisps;
import vendables.Sweet;

import static org.junit.Assert.assertEquals;

public class RackTest {

    Rack rack1;
    Crisps crisps;
    Sweet sweet;

    @Before
    public void before(){
        rack1 = new Rack(RackIdentifier.A);
        crisps = new Crisps("Monster Munch", 0.65);
        sweet = new Sweet("Skittles", 0.80);
    }

    @Test
    public void rackHasIdentifier(){
        assertEquals(RackIdentifier.A , rack1.getIdentifier());
    }

    @Test
    public void rackStartsEmpty(){
        assertEquals(0, rack1.getRackContents().size());
    }

    @Test
    public void rackStartsUnselected(){
        assertEquals(false, rack1.getSelectedStatus());
    }

    @Test
    public void rackCanBeSelected(){
        rack1.selectRack();
        assertEquals(true, rack1.getSelectedStatus());
    }

    @Test
    public void canAddItemToRack(){
        rack1.addItem(crisps);
        assertEquals(1, rack1.getRackContents().size());
    }

    @Test
    public void canAddMultipleIVendItemsToRack(){
        rack1.addItem(crisps);
        rack1.addItem(sweet);
        assertEquals(2, rack1.getRackContents().size());
    }

    @Test
    public void rackHasCapacityOf5(){
        rack1.addItem(crisps);
        rack1.addItem(crisps);
        rack1.addItem(crisps);
        rack1.addItem(sweet);
        rack1.addItem(sweet);
        rack1.addItem(sweet);
        assertEquals(5, rack1.getRackContents().size());
    }

    @Test
    public void canDispenseItem(){
        rack1.addItem(crisps);
        rack1.addItem(crisps);
        rack1.addItem(crisps);
        rack1.addItem(sweet);
        rack1.addItem(sweet);
        assertEquals(crisps, rack1.dispenseItem());
    }

}
