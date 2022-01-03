package mainPackage;

// import vendingMachine.*;
// import listenToMusic.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("1- Play an adventure game");
        System.out.println("2- Go to the vending machine");
        System.out.println("3- Listen to music");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
             input = scan.nextLine();
        }

        if (input.equals("1")) {
            adventureGame.Main.main(args);
        }

        else if (input.equals("2")) {
            vendingMachine.Main.main(args);
        }

        else {
            listenToMusic.Main.main(args);
        }
    }
}
