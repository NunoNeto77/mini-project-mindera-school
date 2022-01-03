package vendingMachine;

public interface VendingMachine {

     void displayProducts();
     void selectProduct(int product);
     void displayEnterCoinsMessage();
     void enterCoins(int[] coins);
     void displayChangeMessage();
     void displayByeMessage();

}
