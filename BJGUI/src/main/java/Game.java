import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JFrame {

    boolean drawStay;
    boolean dealerTurn;
    boolean playMore;

    boolean gameEnd;
    JButton bHit = new JButton();
    JButton bStay = new JButton();
    JButton bRestart = new JButton();

    int cardEdge = 10;
    int cardWidth = 760 / 6;
    int cardHeight = 340 / 2;
    int cardSpacing = 5;
    int cardActualWidth = cardWidth - cardSpacing;
    int cardActualHeight = cardHeight - cardSpacing;

    int playerTotal = 0;

    int dealerTotal = 0;

    String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    ArrayList<Card> totalCards = new ArrayList<Card>();
    ArrayList<Card> playerCards = new ArrayList<Card>();
    ArrayList<Card> dealerCards = new ArrayList<Card>();

    //int random = new Random().nextInt(52);
    Random random = new Random();
    Board board = new Board();

    public Game(BJGUI bjgui) {

        gameEnd = false;
        setLayout(new FlowLayout());

        this.setTitle("BlackJack");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(1280, 800);
        this.setLocation(500, 0);
        this.setVisible(true);

        this.setContentPane(board);
        this.setLayout(null);

        HitAct aHit = new HitAct();
        bHit.addActionListener(aHit);
        bHit.setBounds(340, 650, 200, 60);
        bHit.setBackground(new Color(0, 102, 0));
        bHit.setFont(new Font("Apple Casual", Font.BOLD, 16));
        bHit.setForeground(new Color(255, 255, 255));
        bHit.setText("DRAW");
        board.add(bHit);

        StayAct aStay = new StayAct();
        bStay.addActionListener(aStay);
        bStay.setBounds(640, 650, 200, 60);
        bStay.setBackground(new Color(0, 102, 0));
        bStay.setFont(new Font("Apple Casual", Font.BOLD, 16));
        bStay.setForeground(new Color(255, 255, 255));
        bStay.setText("STAY");
        board.add(bStay);

        F5Act aRestart = new F5Act();
        bRestart.addActionListener(aRestart);
        bRestart.setBounds(1165, 0, 100, 40);
        bRestart.setBackground(new Color(0, 102, 0));
        bRestart.setFont(new Font("Apple Casual", Font.BOLD, 13));
        bRestart.setForeground(new Color(255, 255, 255));
        bRestart.setText("RESTART");
        board.add(bRestart);

        String ashape = null;
        int QR = 0;
        for (int s = 0; s < SUITS.length; s++) {
            if (s == 0) {
                ashape = "Clubs";
            } else if (s == 1) {
                ashape = "Diamonds";
            } else if (s == 2) {
                ashape = "Hearts";
            } else {
                ashape = "Spades";
            }
            for (int i = 2; i < RANKS.length + 2; i++) {
                totalCards.add(new Card(i, ashape, QR));
                QR++;
            }
        }
        for(int i = 0; i < 2; i++)
        {
            playerCards.add(totalCards.remove(random.nextInt(totalCards.size())));
            dealerCards.add(totalCards.remove(random.nextInt(totalCards.size())));
        }

        System.out.println("Dealer got some unknown amount!");

        for (Card c : playerCards) {
            System.out.println("Your card is " + c.name + " of " + c.shape);
        }
        dealerTotal = findTotalCardValue(dealerCards);
        playerTotal = findTotalCardValue(playerCards);
        System.out.println("You have a starting value of: " + findTotalCardValue(playerCards));
        if (playerTotal == 21){
            System.out.println("You got lucky! You automatically win with 21!");
            gameEnd = true;
            dealerTurn = true;
        }
    }

    public void refresher() {
        if (drawStay == true) {
            bHit.setVisible(true);
            bStay.setVisible(true);
            bRestart.setVisible(false);
        } else if (dealerTurn == true) {
            bHit.setVisible(false);
            bStay.setVisible(false);
            bRestart.setVisible(false);
        } else if (playMore == true) {
            bHit.setVisible(false);
            bStay.setVisible(false);
            bRestart.setVisible(true);
        }
    }
    public int findTotalCardValue(ArrayList<Card> list)
    {
        int total = 0;
        for(Card c : list)
            total += c.value;
        return total;
    }
    public void printAllCards(ArrayList<Card> list, String name)
    {
        int total = 0;
        System.out.println(name + "currently has: ");
        for(Card c : list)
            System.out.println(c.name + " of " + c.shape);
    }
    public class Board extends JPanel {

        public void paintComponent(Graphics graphics) {

            graphics.setColor(new Color(0, 153, 0));
            graphics.fillRect(0, 0, 1280, 800);

            graphics.setColor(Color.BLACK);
            graphics.drawRect(970, 50, 292, 290);
            graphics.drawRect(200, 0, 760, 340);
            graphics.drawRect(200, 420, 760, 340);
            graphics.drawRect(970, 420, 292, 340);


            for (int i = 0; i < 6; i++) {
                graphics.drawRect(200 + i * cardWidth + cardSpacing, cardSpacing, cardActualWidth, cardActualHeight);
                graphics.drawRect(200 + i * cardWidth + cardSpacing, 420 + cardSpacing, cardActualWidth, cardActualHeight);
            }

            int index = 0;
            for (Card c : playerCards) {
                graphics.setColor(Color.WHITE);
                graphics.fillRect(200+index*cardWidth+cardSpacing,420+cardSpacing+cardEdge,cardActualWidth,cardActualHeight-2*cardEdge);
                graphics.fillRect(200+index*cardWidth+cardSpacing+cardEdge,420+cardSpacing,cardActualWidth-2*cardEdge,cardActualHeight);
                graphics.fillOval(200+index*cardWidth+cardSpacing,420+cardSpacing,2*cardEdge,2*cardEdge);
                graphics.fillOval(200+index*cardWidth+cardSpacing+cardActualWidth-2*cardEdge,420+cardSpacing,2*cardEdge,2*cardEdge);
                graphics.fillOval(200+index*cardWidth+cardSpacing,420+cardSpacing+cardActualHeight-2*cardEdge,2*cardEdge,2*cardEdge);
                graphics.fillOval(200+index*cardWidth+cardSpacing+cardActualWidth-2*cardEdge,420+cardSpacing+cardActualHeight-2*cardEdge,2*cardEdge,2*cardEdge);
                graphics.setColor(Color.BLACK);

                if (c.shape.equalsIgnoreCase("Hearts") || c.shape.equalsIgnoreCase("Diamonds")) {
                    graphics.setColor(Color.RED);
                }
                graphics.setFont(new Font("Apple Casual",Font.BOLD,30));
                graphics.drawString(c.symbol,200+index*cardWidth+cardSpacing*2,420+cardSpacing+cardActualHeight-4);

                if (c.shape.equalsIgnoreCase("Spades")) {
                    graphics.setColor(Color.BLACK);
                    graphics.fillOval(200+index*cardWidth+30,420+cardActualHeight-95,40,40);
                    graphics.fillOval(200+index*cardWidth+62,420+cardActualHeight-95,40,40);
                    graphics.fillArc(200+index*cardWidth+21,420+12,90,70,230,80);
                    graphics.fillRect(200+index*cardWidth+62,420+87,10,35);
                } else if (c.shape.equalsIgnoreCase("Hearts")) {
                    graphics.setColor(Color.red);
                    graphics.fillOval(200+index*cardWidth+30,420+cardActualHeight-115,40,40);
                    graphics.fillOval(200+index*cardWidth+62,420+cardActualHeight-115,40,40);
                    graphics.fillArc(200+index*cardWidth+21, (int) (420+78.5),90,70,50,80);
                } else if (c.shape.equalsIgnoreCase("Diamonds")) {
                    graphics.setColor(Color.red);
                    int x1=75+191+index*cardWidth;
                    int y1=60+400;

                    int x2=50+191+index*cardWidth;
                    int y2=100+400;

                    int x3=75+191+index*cardWidth;
                    int y3=140+400;

                    int x4=100+191+index*cardWidth;
                    int y4=100+400;

                    int[] xPts = {x1,x2,x3,x4};
                    int[] yPts = {y1,y2,y3,y4};

                    graphics.fillPolygon(xPts,yPts,4);
                } else if (c.shape.equalsIgnoreCase("Clubs")) {
                    graphics.setColor(Color.BLACK);
                    graphics.fillOval(200+index*cardWidth+27,420+cardActualHeight-95,40,40);
                    graphics.fillOval(200+index*cardWidth+65,420+cardActualHeight-95,40,40);
                    graphics.fillOval(200+index*cardWidth+47,420+cardActualHeight-121,40,40);
                    graphics.fillRect(200+index*cardWidth+62,420+77,10,43);
                }
                index++;
            }

            if (dealerTurn==true) {
                index = 0;
                for (Card c : dealerCards) {
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(200 + index * cardWidth + cardSpacing, cardSpacing + cardEdge, cardActualWidth, cardActualHeight - 2 * cardEdge);
                    graphics.fillRect(200 + index * cardWidth + cardSpacing + cardEdge, cardSpacing, cardActualWidth - 2 * cardEdge, cardActualHeight);
                    graphics.fillOval(200 + index * cardWidth + cardSpacing, cardSpacing, 2 * cardEdge, 2 * cardEdge);
                    graphics.fillOval(200 + index * cardWidth + cardSpacing + cardActualWidth - 2 * cardEdge, cardSpacing, 2 * cardEdge, 2 * cardEdge);
                    graphics.fillOval(200 + index * cardWidth + cardSpacing, cardSpacing + cardActualHeight - 2 * cardEdge, 2 * cardEdge, 2 * cardEdge);
                    graphics.fillOval(200 + index * cardWidth + cardSpacing + cardActualWidth - 2 * cardEdge, cardSpacing + cardActualHeight - 2 * cardEdge, 2 * cardEdge, 2 * cardEdge);
                    graphics.setColor(Color.BLACK);

                    if (c.shape.equalsIgnoreCase("Hearts") || c.shape.equalsIgnoreCase("Diamonds")) {
                        graphics.setColor(Color.RED);
                    }
                    graphics.setFont(new Font("Apple Casual", Font.BOLD, 30));
                    graphics.drawString(c.symbol, 200 + index * cardWidth + cardSpacing * 2, cardSpacing + cardActualHeight - 4);
                    if (c.shape.equalsIgnoreCase("Spades")) {
                        graphics.setColor(Color.BLACK);
                        graphics.fillOval(200 + index * cardWidth + 30, cardActualHeight - 95, 40, 40);
                        graphics.fillOval(200 + index * cardWidth + 62, cardActualHeight - 95, 40, 40);
                        graphics.fillArc(200 + index * cardWidth + 21, 12, 90, 70, 230, 80);
                        graphics.fillRect(200 + index * cardWidth + 62, 87, 10, 35);
                    } else if (c.shape.equalsIgnoreCase("Hearts")) {
                        graphics.setColor(Color.red);
                        graphics.fillOval(200 + index * cardWidth + 30, cardActualHeight - 115, 40, 40);
                        graphics.fillOval(200 + index * cardWidth + 62, cardActualHeight - 115, 40, 40);
                        graphics.fillArc(200 + index * cardWidth + 21, (int) (78.5), 90, 70, 50, 80);
                    } else if (c.shape.equalsIgnoreCase("Diamonds")) {
                        graphics.setColor(Color.red);
                        int x1 = 75 + 191 + index * cardWidth;
                        int y1 = 40;

                        int x2 = 50 + 191 + index * cardWidth;
                        int y2 = 80;

                        int x3 = 75 + 191 + index * cardWidth;
                        int y3 = 120;

                        int x4 = 100 + 191 + index * cardWidth;
                        int y4 = 80;

                        int[] xPts = {x1, x2, x3, x4};
                        int[] yPts = {y1, y2, y3, y4};

                        graphics.fillPolygon(xPts, yPts, 4);
                    } else if (c.shape.equalsIgnoreCase("Clubs")) {
                        graphics.setColor(Color.BLACK);
                        graphics.fillOval(200 + index * cardWidth + 27, cardActualHeight - 95, 40, 40);
                        graphics.fillOval(200 + index * cardWidth + 65, cardActualHeight - 95, 40, 40);
                        graphics.fillOval(200 + index * cardWidth + 47, cardActualHeight - 121, 40, 40);
                        graphics.fillRect(200 + index * cardWidth + 62, 77, 10, 43);
                    }
                    index++;
                }
            }
        }
    }

    public class HitAct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("DRAW!");
            if (gameEnd == false) {
                playerCards.add(totalCards.remove(random.nextInt(totalCards.size())));
                playerTotal += playerCards.get(playerCards.size()-1).value;
                printAllCards(playerCards, "Player");
                System.out.println("Your total is now: " + playerTotal);
                if (playerTotal > 21)
                {
                    System.out.println("You busted! Your total is " + playerTotal);
                    System.out.println("The dealer had: " + dealerTotal);
                    gameEnd = true;
                    dealerTurn = true;
                }
                else if(playerTotal == 21)
                {
                    System.out.println("You won! You got a total of 21!");
                    gameEnd = true;
                    dealerTurn = true;
                }
                board.paintComponent(board.getGraphics());
            }
            else{
                System.out.println("Restart the game to play again!");
            }
        }
    }

    public class StayAct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("STAY!");

            drawStay = false;
            dealerTurn = true;
            board.paintComponent(board.getGraphics());
            if (gameEnd == false)
            {
                gameEnd = true;
                if (playerTotal > dealerTotal)
                    System.out.println("You win! The dealer has " + dealerTotal + " whereas you have " + playerTotal);
                else
                    System.out.println("You lost! The dealer has " + dealerTotal + " whereas you have " + playerTotal);
            }
            else
                System.out.println("Restart the game to play again!");
        }
    }

    public class F5Act implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("The game has been restarted!");
            gameEnd = false;
            dealerTurn = false;
            playerTotal = 0;
            dealerTotal = 0;
            playerCards.clear();
            dealerCards.clear();
            totalCards.clear();
            String ashape = null;
            int QR = 0;
            for (int s = 0; s < SUITS.length; s++) {
                if (s == 0) {
                    ashape = "Clubs";
                } else if (s == 1) {
                    ashape = "Diamonds";
                } else if (s == 2) {
                    ashape = "Hearts";
                } else {
                    ashape = "Spades";
                }
                for (int i = 2; i < RANKS.length + 2; i++) {
                    totalCards.add(new Card(i, ashape, QR));
                    QR++;
                }
            }
            for(int i = 0; i < 2; i++)
            {
                playerCards.add(totalCards.remove(random.nextInt(totalCards.size())));
                dealerCards.add(totalCards.remove(random.nextInt(totalCards.size())));
            }
            for (Card c : playerCards) {
                System.out.println("Your card is " + c.name + " of " + c.shape);
            }
            dealerTotal = findTotalCardValue(dealerCards);
            playerTotal = findTotalCardValue(playerCards);
            System.out.println("You have a starting value of: " + findTotalCardValue(playerCards));
            if (playerTotal == 21){
                System.out.println("You got lucky! You automatically win with 21!");
                gameEnd = true;
                dealerTurn = true;
            }
            board.paintComponent(board.getGraphics());
        }
    }
}



