package vendingMachine;

public enum Coin {
    FIVE_CENTS(5),
    TEN_CENTS(10),
    TWENTY_CENTS(20),
    FIFTY_CENTS(50),
    HUNDRED_CENTS(100);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    // convert "0,0,0,0,0" to [0, 0, 0, 0, 0]
    public static int[] parseCoins(String coins) { // analisar moedas
        String[] numberOfCoinsInText = coins.split(",");
        int[] result = new int[numberOfCoinsInText.length];

        for (int i = 0; i < numberOfCoinsInText.length; i++) {
            result[i] = Integer.parseInt(numberOfCoinsInText[i]);
        }
        return result;
    }

    public int getValue() {
        return this.value;
    }
}
