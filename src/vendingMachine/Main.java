package vendingMachine;

import java.util.Scanner;

/*
1. Machine displays a welcome message
2. asks the user to select the product
3. ask the user to enter the coins
4. calculates the amount entered by user
5. it calculates the change
6. it calculates the minimum number of coins
7. displays a message with the change
8. say bye


 1- VENDING MACHINE,
 2- PRODUCTS,
 3- COINS,
 4- COIN BUNDLE
 5- CALCULATOR

 */
public class Main {

    public static void main(String[] args) {
        // write your code here Nuno
        VendingMachineFeatures vendingMachine = new VendingMachineFeatures();
        vendingMachine.displayProducts();
        Scanner scan = new Scanner(System.in);

        int selectedProduct = VendingMachineFeatures.inputProductID();

        vendingMachine.selectProduct(selectedProduct);
        vendingMachine.displayEnterCoinsMessage();

        String userEnteredCoins = scan.nextLine();
        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);

        vendingMachine.enterCoins(enteredCoins);
        vendingMachine.displayChangeMessage();
        vendingMachine.displayByeMessage();
    }
}

//    String selectedProduct =
//     int selectProductNumber = Integer.parseInt(selectedProduct); // converts a string to an int