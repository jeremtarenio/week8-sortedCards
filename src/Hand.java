
import java.util.ArrayList;
import java.util.Collections;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jerem
 */
public class Hand implements Comparable<Hand> {

    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public int compareTo(Hand hand) {
        int thisTotalValue = 0;
        int paramTotalValue = 0;
        int thisValueOnly = 0;
        int paramValueOnly = 0;

        for (Card card : this.cards) {
            thisTotalValue += card.getValue() + card.getSuit();
            thisValueOnly += card.getValue();
        }

        for (Card card : hand.getCards()) {
            paramTotalValue += card.getValue() + card.getSuit();
            paramValueOnly += card.getValue();
        }

        if (thisValueOnly == paramValueOnly) {
            return 0;
        }

        return thisTotalValue - paramTotalValue;
    }
    
    public void sortAgainstSuit() {
        
        Collections.sort(cards, new SortAgainstSuitAndValue());
    }

}
