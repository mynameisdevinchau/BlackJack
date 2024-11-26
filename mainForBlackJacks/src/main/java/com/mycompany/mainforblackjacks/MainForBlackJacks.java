/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mainforblackjacks;

/**
 *
 * @author devinchau
 */
import java.util.Scanner;
import java.util.Random;

public class MainForBlackJacks {

    public static void main(String[] args) {
        String input;
        char reDo;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();
        int card1 = random.nextInt(10) + 1;
        int card2 = random.nextInt(10) + 1;
        int card = random.nextInt(10) + 1;
        int total1 = card1 + card2;

        System.out.print("First One's Cards: " + card1 + ", " + card2 + "\n");
        System.out.print("Total: " + total1 + "\n");

        boolean loop = true;
        while (loop) {
            System.out.print("Do you want another card? (y/n): ");
            input = keyboard.nextLine();
            reDo = input.charAt(0);
            if (reDo == 'y' || reDo == 'Y') {
                System.out.print("Card: " + card + "\n");
                int total2 = total1 + card;
                System.out.print("Total: " + total2 + "\n");
            } else if (reDo == 'n' || reDo == 'N') {
                loop = false;
            }
        }
    }
}
