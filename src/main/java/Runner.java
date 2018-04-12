import coins.*;
import racks.Rack;
import racks.RackIdentifier;
import vendables.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

//Vending Machine setup:
        Crisps crisps = new Crisps("Nik Naks", 65);
        Sweet sweets = new Sweet("Double Decker", 100);
        Drink drink = new Drink("Irn Bru", 90, 150);
        Rack rackA = new Rack(RackIdentifier.A);
        rackA.addItem(crisps);
        rackA.addItem(crisps);
        rackA.addItem(crisps);
        Rack rackB = new Rack(RackIdentifier.B);
        rackB.addItem(sweets);
        rackB.addItem(sweets);
        rackB.addItem(sweets);
        Rack rackC = new Rack(RackIdentifier.C);
        rackC.addItem(drink);
        rackC.addItem(drink);
        rackC.addItem(drink);
        VendingMachine vendingMachine = new VendingMachine(rackA, rackB, rackC);
        Nickel nickel = new Nickel();
        Dime dime = new Dime();
        Quarter quarter = new Quarter();
        Dollar dollar = new Dollar();
        vendingMachine.toggleServiceMode();
        vendingMachine.addToCoinsRetained(dollar);
        vendingMachine.addToCoinsRetained(quarter);
        vendingMachine.addToCoinsRetained(quarter);
        vendingMachine.addToCoinsRetained(quarter);
        vendingMachine.addToCoinsRetained(quarter);
        vendingMachine.addToCoinsRetained(quarter);
        vendingMachine.addToCoinsRetained(quarter);
        vendingMachine.addToCoinsRetained(quarter);
        vendingMachine.addToCoinsRetained(quarter);
        vendingMachine.addToCoinsRetained(dime);
        vendingMachine.addToCoinsRetained(dime);
        vendingMachine.addToCoinsRetained(dime);
        vendingMachine.addToCoinsRetained(dime);
        vendingMachine.addToCoinsRetained(dime);
        vendingMachine.addToCoinsRetained(dime);
        vendingMachine.addToCoinsRetained(dime);
        vendingMachine.addToCoinsRetained(dime);
        vendingMachine.addToCoinsRetained(dime);
        vendingMachine.addToCoinsRetained(dime);
        vendingMachine.addToCoinsRetained(nickel);
        vendingMachine.addToCoinsRetained(nickel);
        vendingMachine.addToCoinsRetained(nickel);
        vendingMachine.addToCoinsRetained(nickel);
        vendingMachine.addToCoinsRetained(nickel);
        vendingMachine.addToCoinsRetained(nickel);
        vendingMachine.addToCoinsRetained(nickel);
        vendingMachine.addToCoinsRetained(nickel);
        vendingMachine.addToCoinsRetained(nickel);
        vendingMachine.addToCoinsRetained(nickel);
        vendingMachine.toggleServiceMode();
//User available coins setup:
        ArrayList<ICoin> userAvailableCoins = new ArrayList<>();
        userAvailableCoins.add(dollar);
        userAvailableCoins.add(quarter);
        userAvailableCoins.add(quarter);
        userAvailableCoins.add(dime);
        userAvailableCoins.add(dime);
        userAvailableCoins.add(dime);
        userAvailableCoins.add(nickel);
        userAvailableCoins.add(nickel);
        userAvailableCoins.add(nickel);
        userAvailableCoins.add(nickel);

        String acceptedCoins = "Accepted coins are 5, 10, 25 and 100";
        System.out.println("Welcome to the Trendy Vendy!");
        System.out.println("Today's items are:");
        System.out.println("A - " + crisps.getName() + ": 65c");
        System.out.println("B - " + sweets.getName() + ": $1");
        System.out.println("C - " + drink.getName() + ": $1.50");
        System.out.println("Please choose an item!");
        System.out.println(acceptedCoins);

        Scanner reader = new Scanner(System.in);
        String item = reader.next().toUpperCase();

        Boolean selectionMade = false;

        IVend selectedItem = new Sweet("placeholder", 12);

        do {
            switch(item){
                case "A":
                    selectionMade = true;
                    vendingMachine.selectRack(rackA);
                    selectedItem = rackA.getRackContents().get(0);
                    System.out.println("Please insert " + selectedItem.getPrice() + "c");
                    break;
                case "B":
                    selectionMade = true;
                    vendingMachine.selectRack(rackB);
                    selectedItem = rackB.getRackContents().get(0);
                    System.out.println("Please insert " + selectedItem.getPrice() + "c");
                    break;
                case "C":
                    selectionMade = true;
                    vendingMachine.selectRack(rackC);
                    selectedItem = rackC.getRackContents().get(0);
                    System.out.println("Please insert " + selectedItem.getPrice() + "c");
                    break;
                case "X":
                    selectionMade = true;
                    vendingMachine.toggleServiceMode();
                    System.out.println("Welcome, authorised technician! Service Mode activated!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again!");
                    item = reader.next().toUpperCase();
            }
        } while(selectionMade == false);

        int totalInserted = 0;

        Scanner coinReader = new Scanner(System.in);
        int coinValue = Integer.parseInt(coinReader.next());

        System.out.println(selectedItem.getName());

        do {
            totalInserted += coinValue;
            if(!checkAgainstPrice(totalInserted, selectedItem.getPrice())){
                System.out.println(totalInserted + " inserted, please insert more coins.");
                coinValue = Integer.parseInt(coinReader.next());
            } else break;
        }
        while(!checkAgainstPrice(totalInserted, selectedItem.getPrice()));

//        ICoin coin1 = createCoin(coinValue);
//        totalInserted += coinValue;
//        System.out.println("You have inserted " + totalInserted + "c");

    }

    public static ICoin createCoin(int denomination){
        switch(denomination){
            case 5:
                return new Nickel();
            case 10:
                return new Dime();
            case 25:
                return new Quarter();
            case 100:
                return new Dollar();
            default:
            break;
        }
    return null;
    }

    public static boolean checkAgainstPrice(int inserted, int price){
        return inserted >= price;
    }
//
//    public static void systemResponse(selectedItem){
//        int totalInserted = 0;
//
//        Scanner coinReader = new Scanner(System.in);
//        int coinValue = Integer.parseInt(coinReader.next());
//
////        System.out.println(selectedItem);
//        do {
//            totalInserted += coinValue;
//            System.out.println(totalInserted);
//        }
//        while(checkAgainstPrice(totalInserted, selectedItem.getPrice));
//
//        ICoin coin1 = createCoin(coinValue);
//        totalInserted += coinValue;
//        System.out.println("You have inserted " + totalInserted + "c");
//    }

}
