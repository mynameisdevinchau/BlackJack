/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackonline;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private final ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        // populate deck with cards
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                cards.add(new Card(face, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(i + 1);
            sb.append('/');
            sb.append(cards.size());
            sb.append(' ');
            sb.append(cards.get(i));
            sb.append('\n');
        }
        return sb.toString();
    }
}