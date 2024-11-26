/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.blackjacks;

/**
 *
 * @author devinchau
 */
import java.util.Scanner;
import java.util.Random;

public class BlackJacks {
    //Total of the cards 
    int total = 0;
    char option;

    public void Card() {
        Scanner input = new Scanner(System.in);
        //Initializing the suites in arrays
        int diamond[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11};
        int spade[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11};
        int clover[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11};
        int heart[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11};
        //Jacks for all Suites
        if (diamond[10] == 10) {
            System.out.print("You drew a jack!");
            total += diamond[10];
        } else if (spade[10] == 10) {
            System.out.print("You drew a jack!");
            total += spade[10];
        } else if (clover[10] == 10) {
            System.out.print("You drew a jack!");
            total += clover[10];
        } else if (heart[10] == 10) {
            System.out.print("You drew a jack!");
            total += heart[10];
        }
        //Queens for all Suites
        if (diamond[11] == 10) {
            System.out.print("You drew a queen!");
            total += diamond[11];
        } else if (spade[11] == 10) {
            System.out.print("You drew a queen!");
            total += spade[11];
        } else if (clover[11] == 10) {
            System.out.print("You drew a queen!");
            total += clover[11];
        } else if (heart[11] == 10) {
            System.out.print("You drew a queen!");
            total += heart[11];
        }
        //Kings for all Suites
        if (diamond[12] == 10) {
            System.out.print("You drew a king!");
            total += diamond[12];
        } else if (spade[12] == 10) {
            System.out.print("You drew a king!");
            total += spade[12];
        } else if (clover[12] == 10) {
            System.out.print("You drew a king!");
            total += clover[12];
        } else if (heart[12] == 10) {
            System.out.print("You drew a king!");
            total += heart[12];
        }
        //For the Aces
        if (diamond[12] == 11) {
            System.out.print("Would you like to have a 1 or an 11?");
            int temp = input.nextInt();
            temp = diamond[12];
            total += temp;

        } else if (spade[12] == 11) {
            System.out.print("Would you like to have a 1 or an 11?");
            int temp = input.nextInt();
            temp = diamond[12];
            total += temp;
        }
        if (clover[12] == 11) {
            System.out.print("Would you like to have a 1 or an 11?");
            int temp = input.nextInt();
            temp = diamond[12];
            total += temp;

        } else if (heart[12] == 11) {
            System.out.print("Would you like to have a 1 or an 11?");
            int temp = input.nextInt();
            temp = diamond[12];
            total += temp;
        }

    }

    public static void totalValue(int total) {
        Random r = new Random();
        int suite = r.nextInt(4);
        
        int card1 = r.nextInt(13);
        int card2 = r.nextInt(13);
        total = card1 + card2;
        if (total == 21) {
            System.out.print("You win!");
           
        }
        if (total < 21) {
            System.out.print("Would you like another card? (y/n)");

            int card3 = r.nextInt();
        } else {
            System.out.print("Your total is over 21. You lose!");
        }

    }

    public static void main(String[] args) {

    }

}
