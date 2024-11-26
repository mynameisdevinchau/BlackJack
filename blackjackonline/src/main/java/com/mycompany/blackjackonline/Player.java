/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackonline;

/**
 *
 * @author devinchau
 */
import java.util.ArrayList;

//Player class
public class Player {

    private final String vem;

    private final ArrayList<Card> hand;

    public Player(String vem) {
        this.vem = vem;
        this.hand = new ArrayList<Card>();
    }

    public String getVem() {
        return vem;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getHandSum() {
        int handSum = 0;
        for (Card card : hand) {
            handSum += card.getFace().getValue();
        }
        return handSum;
    }

    public String getHandAsString(boolean b) {
        StringBuilder build = new StringBuilder();
        build.append(vem); //'s'\
        build.append('\n');
        for (int i = 0; i < hand.size(); i++) {
            if (i == 0 && b) {
                build.append('\n');
            } else {
                build.append(hand.get(i));
                build.append('\n');
            }
        }
        return build.toString();
    }
}