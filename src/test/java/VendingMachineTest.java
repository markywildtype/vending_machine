import org.junit.Before;
import org.junit.Test;
import racks.Rack;
import racks.RackIdentifier;
import vendables.Crisps;
import vendables.Drink;
import vendables.Sweet;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    VendingMachine vendingMachine;
    Rack rack1;
    Rack rack2;
    Rack rack3;
    Crisps crisps;
    Sweet sweets;
    Drink drink;

    @Before
    public void before(){
        crisps = new Crisps("Nik Naks", 65);
        sweets = new Sweet("Double Decker", 100);
        drink = new Drink("Irn Bru", 90, 150);
        rack1 = new Rack(RackIdentifier.A);
        rack1.addItem(crisps);
        rack1.addItem(crisps);
        rack1.addItem(crisps);
        rack2 = new Rack(RackIdentifier.B);
        rack2.addItem(sweets);
        rack2.addItem(sweets);
        rack2.addItem(sweets);
        rack3 = new Rack(RackIdentifier.C);
        rack3.addItem(drink);
        rack3.addItem(drink);
        rack3.addItem(drink);
        rack3.addItem(drink);
        vendingMachine = new VendingMachine(rack1, rack2, rack3);
    }

    @Test
    public void coinsPendingStartsAtZero(){
        assertEquals(0, vendingMachine.getCoinsPending());
    }

}
