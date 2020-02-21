import java.util.ArrayList;
/**
 *  Dealer Class
 *  It will do the tasks like a dealer that replace, draw etc
 *
 * @author MAK CHAK WING
 * @version Nov 17, 2019
 */
public class Dealer {
    public ArrayList<Card> hand = new ArrayList<Card>();

    /**
     * Draw card in the deck
     * @param deck the deck that the player draw from
     */

    public void draw(Deck deck)
    {
        for(int i = 0;i <3;i++){
            hand.add(deck.Deck.get(i));
            deck.Deck.remove(i);
        }
    }

    /**
     *  Find the number of Special Card for the dealer
     * @return  the number of Special Cards for the dealer
     */
    public int numberofSpecialCard(){
        int answer=0;
        for(Card i:hand){
            if (i.suit > 10 && i.suit < 14){
                answer++;
            }
        }
        return answer;
    }

    /**
     *  Find the number of the remainder of cards ( except special card ) after dividing the sum by 10
     * @return the number of the remainder of cards ( except special card ) after dividing the sum by 10
     */

    public int ReminderofFaceValue(){
        int answer=0;
        for(Card i:hand){
            if (i.suit < 11){
                answer += i.suit;
            }
        }
        return answer%10;
    }
}
