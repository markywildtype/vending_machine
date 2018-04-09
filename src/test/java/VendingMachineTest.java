import coins.Coin;
import coins.CoinValue;
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
    Coin nickel;
    Coin dime;
    Coin quarter;
    Coin dollar;

    @Before
    public void before(){
        crisps = new Crisps("Nik Naks", 65);
        sweets = new Sweet("Double Decker", 100);
        drink = new Drink("Irn Bru", 90, 150);
        nickel = new Coin(CoinValue.NICKEL);
        dime = new Coin(CoinValue.DIME);
        quarter = new Coin(CoinValue.QUARTER);
        dollar = new Coin(CoinValue.DOLLAR);
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
        assertEquals(0, vendingMachine.getCoinsPendingValue());
    }

    @Test
    public void canAddCoinsToCoinsPending(){
        vendingMachine.insertCoin(quarter);
        vendingMachine.insertCoin(quarter);
        vendingMachine.insertCoin(dime);
        vendingMachine.insertCoin(nickel);
        assertEquals(65, vendingMachine.getCoinsPendingValue());
    }

    @Test
    public void canSelectRack(){
        vendingMachine.selectRack(rack1);
        assertEquals(true, rack1.getSelectedStatus());
    }

    @Test
    public void canDispenseItemIfCorrectCoinValueAndRackSelected(){
        vendingMachine.insertCoin(quarter);
        vendingMachine.insertCoin(quarter);
        vendingMachine.insertCoin(dime);
        vendingMachine.insertCoin(nickel);
        assertEquals(crisps, vendingMachine.selectRack(rack1));
    }

    @Test
    public void changeSlotStartsEmpty(){
        assertEquals(0, vendingMachine.getChangeSlot().size());
    }

    @Test
    public void canReturnCoins(){
        vendingMachine.insertCoin(quarter);
        vendingMachine.insertCoin(quarter);
        vendingMachine.insertCoin(dime);
        vendingMachine.insertCoin(nickel);
        vendingMachine.coinReturn();
        assertEquals(4, vendingMachine.getChangeSlot().size());
        assertEquals(65, vendingMachine.getChangeSlotValue());
        assertEquals(0, vendingMachine.getCoinsPendingValue());
    }

//    @Test
//    public void changeAddedToChangeSlotIfOverpaid(){
//        vendingMachine.insertCoin(quarter);
//        vendingMachine.insertCoin(quarter);
//        vendingMachine.insertCoin(quarter);
//        vendingMachine.insertCoin(dime);
//        vendingMachine.insertCoin(nickel);
//        vendingMachine.selectRack(rack1);
//        assertEquals(quarter, vendingMachine.getChangeSlot().get(0));
//    }

}
