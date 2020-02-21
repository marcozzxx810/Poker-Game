import java.util.ArrayList;
import java.util.Collections;

/**
 *  Deck Class
 *  Deck class that perform task like shuffle and filldeck.
 *
 * @author MAK CHAK WING
 * @version Nov 17, 2019
 */

public class Deck {
    public ArrayList<Card> Deck = new ArrayList<Card>();

    /**
     * Fill the deck with 52 card with different rank and suit
     */
    public void fillDeck()
    {
        int counter = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int rank = 1; rank <= 13; rank++)
            {
                Deck.add(new Card(suit, rank));
            }
        }
    }

    /**
     * shuffle and randomize the card
     */
    public void shuffle(){
        Collections.shuffle(Deck);
    }

}
