package vendingMachine;

import java.util.Scanner;

public class VendingMachineFeatures implements VendingMachine {


    private int selectedProduct;
    private CoinBundle change;

    @Override
    public void displayProducts() {
        System.out.println(" ************************************************");
        System.out.println("          WELCOME TO THE VENDING MACHINE!              ");
        System.out.println(" ************************************************");
        System.out.println("             Products available:                  ");
        System.out.println("");

        for (Product product : Product.values()) {
            System.out.println("           " + product.getId() + " - " + product.name() + " | Price: " + product.getPrice() + " cents");
        }

        System.out.println("");
        System.out.println(" Please select your product: (Select the ID)");
    }

    @Override
    public void selectProduct(int product)   {
        this.selectedProduct = product;
    }

    @Override
    public void displayEnterCoinsMessage() {
        System.out.println(" Please enter coins as follows: ");
        System.out.println(" num of 5 cents coins, num of 10 cents coins, num of 20 cents coins, num of 50 cents coins, num of 100 cents coins  ");
        System.out.println("");
        System.out.println(" Example: If you would like to enter 2 ten cents coins: 0,2,0,0,0");
        System.out.println();
        System.out.println("Please enter coins:");
    }

    @Override
    public void enterCoins(int[] coins) {
        SimpleCalculator calculator = new SimpleCalculator();

        Product product = Product.valueOf(this.selectedProduct);

        int total = calculator.calculateTotal(new CoinBundle(coins));

        int changeAmount = total - product.getPrice();
        this.change = calculator.calculateChange(changeAmount);
    }

    @Override
    public void displayChangeMessage() {
        System.out.println();
        System.out.println("Your change is : " + change.getTotal() + " cents splitted as follows: ");
        System.out.println("    100 cents coins: " + change.number100CentsCoins);
        System.out.println("    50 cents coins: " + change.number50CentsCoins);
        System.out.println("    20 cents coins: " + change.number20CentsCoins);
        System.out.println("    10 cents coins: " + change.number10CentsCoins);
        System.out.println("    5 cents coins: " + change.number5CentsCoins);
    }

    @Override
    public void displayByeMessage() {
        System.out.println();
        System.out.println("Here is your Product!");
        System.out.println("Goodbye! Thank you for coming!");

    }

    public static int inputProductID() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int selectedProduct = scan.nextInt();

            if (selectedProduct > 0 && selectedProduct < 5) {
                return selectedProduct;
            }

            System.out.println("PUT A VALID ID");
        }
    }



}