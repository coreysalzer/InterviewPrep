import TexasHoldem;
import Deck;
import Hand;
import Card;

//TODO - get this working with Groovy
class CardStructuresTest {
    void testTexasHoldem() {
        TexasHoldem game = new TexasHoldem(6);
        game.playRound();

        assertLength(6, game.playerHands);
        assertOnlyOneOfEachCardInTheGame(game);
    }

    private static void assertOnlyOneOfEachCardInTheGame(TexasHoldem game) {
        Deck deck = new Deck();
        for (Card card : deck.cards) {
            boolean cardFound = false;
            cardFound = game.deck.cards.contains(card);

            for(Hand hand : game.playerHands) {
                if(hand.cards.contains(card)) {
                    assert(!cardFound);
                    cardFound = true;
                }
            }
        }
    }
}
