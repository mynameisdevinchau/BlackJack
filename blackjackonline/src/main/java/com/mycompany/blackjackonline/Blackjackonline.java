/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.blackjackonline;

import java.util.Scanner;

class Card {
    private final Face face;

    private final Suit suit;

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace() {
        return face;
    }
    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
}

enum Face {
    Ace(11), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10);

    private final int value;

    private Face(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}

enum Suit {
    hearts, spades, diamonds, clubs;
}

public class Blackjackonline {
    public static void main(String[] args) {

        int wins = 0;
        int losses = 0;

        Scanner scanner = new Scanner(System.in);
        String input;
        
        //Clear Terminal from file paths
        System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");
        
        //Start loop
        do {

            //Clear Terminal from last game
            System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");

            //Create players, shuffle deck and turn gameOver off
            Player player = new Player("You");
            Player dealer = new Player("Dealer");
            Deck deck = new Deck();
            deck.shuffle();
            boolean gameOver = false;

            //Get cards for player
            player.addCard(deck.draw());
            player.addCard(deck.draw());
            System.out.print(player.getHandAsString(false));
            System.out.println("Total: " + player.getHandSum());
            System.out.println("");System.out.println("");

            //Get cards for dealer
            dealer.addCard(deck.draw());
            dealer.addCard(deck.draw());

            

            //Player turn
            do {
                if (player.getHandSum() == 21) {
                    System.out.println("Super lucky Blackjack! You win.");
                    wins = wins + 1;
                    gameOver = true;
                    break;
                }
                if (player.getHandSum() > 21) {
                    System.out.println("Super unlucky! You lost.");
                    losses = losses + 1;
                    gameOver = true;
                    break;
                }

                System.out.println("");System.out.println("");
                System.out.println("Draw or stay?");
                do {
                    input = scanner.nextLine();
                } while (!input.equalsIgnoreCase("Draw") && !input.equalsIgnoreCase("Stay"));

                //Draw
                if (input.equalsIgnoreCase("Draw")) {
                    player.addCard(deck.draw());
                    System.out.println("");
                    System.out.print(player.getHandAsString(false));
                    System.out.println("Total: " + player.getHandSum());
                    System.out.println("");System.out.println("");
                    if (player.getHandSum() == 21) {
                        System.out.println("Blackjack! You win.");
                        wins = wins + 1;
                        gameOver = true;
                    }
                    if (player.getHandSum() > 21) {
                        System.out.println("You busted with " + player.getHandSum() + " in your hand. Dealer wins!");
                        losses = losses + 1;
                        gameOver = true;
                    }
                }
                //Stay
                if (input.equalsIgnoreCase("stay")) {
                    System.out.println("You have chosen to stay. Your hand: " + player.getHandSum());
                }
            } while (input.equalsIgnoreCase("Draw") && !gameOver);

            //Dealer turn
            if (!gameOver) {
                System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");
                System.out.println("________________________________________________________________________");
                System.out.println("Dealers turn");
                System.out.println("________________________________________________________________________");
                
                System.out.println("");
                System.out.print(dealer.getHandAsString(false));
                
                System.out.println(dealer.getHandSum());
                System.out.println("");System.out.println(""); 

                if (dealer.getHandSum() == 21) {
                    System.out.println("Blackjack! Dealer won.");
                    losses = losses + 1;
                    gameOver = true;
                }
            }
            while (!gameOver) {
                if (dealer.getHandSum() <= 17) {
                    //Draw card
                    dealer.addCard(deck.draw());
                    System.out.println(dealer.getVem() + " drew another card");
                    System.out.println("");
                    System.out.print(dealer.getHandAsString(false));
                    System.out.println(dealer.getHandSum());
                    System.out.println("");System.out.println(""); 
                    
                    if (dealer.getHandSum() == 17) {
                        if (player.getHandSum() == 17) {
                            System.out.println("Dealer won.");
                            losses = losses + 1;
                            gameOver = true;
                        }
                    }

                    if (dealer.getHandSum() == 18) {
                        if (player.getHandSum() == 18) {
                            System.out.println("Dealer won.");
                            losses = losses + 1;
                            gameOver = true;
                        }
                    }

                    if (dealer.getHandSum() == 19) {
                        if (player.getHandSum() == 19) {
                            System.out.println("Dealer won.");
                            losses = losses + 1;
                            gameOver = true;
                        }
                    }
                    
                    if (dealer.getHandSum() == 20) {
                        if (player.getHandSum() == 20) {
                            System.out.println("It's a draw!");
                            gameOver = true;
                        }
                    }

                    if (dealer.getHandSum() == 21) {
                        System.out.println("Blackjack! Dealer won.");
                        losses = losses + 1;
                        gameOver = true;
                    }
                    if (dealer.getHandSum() > 21) {
                        System.out.println("Dealer busted with " + dealer.getHandSum() + " in their hand. You win!");
                        wins = wins + 1;
                        gameOver = true;
                    }

                } else {
                    //Stay
                    System.out.println("Dealer chose to stay!");
                    System.out.println("");
                    int totalDealerSum = dealer.getHandSum();
                    int totalPlayerSum = player.getHandSum();

                    if (totalDealerSum > totalPlayerSum) {
                        System.out.println("Both players decided to stay. The Dealer won with a total of " + totalDealerSum + " in their hand.");
                        losses = losses + 1;
                    } else {
                        System.out.println("Both players decided to stay. You win with a total of " + totalPlayerSum + " in your hand.");
                        wins = wins + 1;
                    }
                    gameOver = true;
                }
            }

            //New game? And Score
            System.out.println("");System.out.println("");System.out.println("");
            
            if(wins==1 && losses==0){
                System.out.println("You have won " + wins + " time and lost " + losses + " times.");
            }
            if(wins==0 && losses==1){
                System.out.println("You have won " + wins + " times and lost " + losses + " time.");
            }
            
            if(wins>1 && losses>1){
                System.out.println("You have won " + wins + " times and lost " + losses + " times.");
            }
            if(wins==0 && losses>1){
                System.out.println("You have won " + wins + " times and lost " + losses + " times.");
            }
            if(wins>1 && losses==0){
                System.out.println("You have won " + wins + " times and lost " + losses + " times.");
            }

            if(wins>1 && losses==1){
                System.out.println("You have won " + wins + " times and lost " + losses + " time.");
            }
            if(wins==1 && losses==1){
                System.out.println("You have won " + wins + " time and lost " + losses + " time.");
            }
            if(wins==1 && losses>1){
                System.out.println("You have won " + wins + " time and lost " + losses + " times.");
            }

            System.out.println("");
            System.out.println("Play again?");
            do {
                input = scanner.nextLine();
            } while (!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No"));
            

        } while (input.equalsIgnoreCase("Yes"));
        
        scanner.close();
    }
}