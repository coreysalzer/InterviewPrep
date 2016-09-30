import java.util.*;

enum Suit {
    SPADES,
    CLUBS,
    DIAMONDS,
    HEARTS
}

class Card implements Comparable<Card> {
    private int rank; /** 0-12 **/
    private Suit suit;
    
    Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public int compareTo(Card c) {
        if (this.rank == c.rank) {
            return (this.suit).compareTo(c.suit);
        }
        else {
            return this.rank - c.rank;
        }
    }
}

class Hand {
    protected Card[] cards;
    
    Hand(Card[] cards) {
        this.cards = cards;
    }

}

class Deck {
    protected List<Card> cards;
    
    Deck() {
        cards = new ArrayList<>();
        this.addCards();
    }
    
    private void addCards() {
        for(int i = 0; i < Suit.values().length; i++) {
            for(int j = 0; j < 13; j++) {
                this.cards.add(new Card(j, Suit.values()[i]));
            }
        }
    }

    Card dealCard() {
        Random r = new Random();
        int rand = r.nextInt(cards.size());
        return cards.remove(rand);
    }


}

class TexasHoldem {
    protected Deck deck;
    protected Hand[] playerHands;

    public TexasHoldem(int numPlayers) {
        this.deck = new Deck();
        this.playerHands = new Hand[numPlayers];
    }

    public void playRound() {
        this.dealHands();
    }

    private void dealHands() {
        for (int handNum = 0; handNum < playerHands.length; handNum++) {
            Card[] cards = new Card[5];

            for (int cardNum = 0; cardNum < cards.length; cardNum++) {
                cards[cardNum] = deck.dealCard();
            }

            playerHands[handNum] = new Hand(cards);
        }
    }
}