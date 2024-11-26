public class Card {
    int number;
    String shape;
    boolean cardUsed;
    String symbol;
    String name;
    int QRCode;
    int value;
    Card(int n, String s, int q) {
        this.number = n;
        this.shape = s;
        this.QRCode = q;
        if (number < 11) {
            symbol = Integer.toString(number);
            name = Integer.toString(number);
            value = number;
        } else if (number == 11) {
            symbol = "J";
            name = "Jack";
            value = 10;
        } else if (number == 12) {
            symbol = "Q";
            name = "Queen";
            value = 10;
        } else if (number==13) {
            symbol = "K";
            name = "King";
            value = 10;
        } else if (number==14) {
            symbol = "A";
            name = "Ace";
            value = 11;
        }
    }
}

