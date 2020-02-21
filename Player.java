import java.util.ArrayList;
/**
 *  Player Class
 *  It will do the tasks like a player that replace, draw etc
 *
 * @author MAK CHAK WING
 * @version Nov 17, 2019
 */
public class Player {
    private int replace_time =2;
    private boolean rp_1 = true;
    private boolean rp_2 = true;
    private boolean rp_3 = true;
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
     * Replace the hand with the deck card
     * @param deck the arraylist of the deck
     * @param pos the position of the current hand cards that wanted to replcae
     */
    public void replace (Deck deck,int pos){
        if(pos == 1){
            if ( rp_1 && replace_time >0){
                hand.set(0,deck.Deck.get(0));
                deck.Deck.remove(0);
                rp_1 = false;
                replace_time --;
            }
        } else if(pos == 2){
            if ( rp_2 && replace_time >0){
                hand.set(1,deck.Deck.get(0));
                deck.Deck.remove(0);
                rp_2 = false;
                replace_time --;
            }
        } else if(pos == 3){
            if ( rp_3 && replace_time >0){
                hand.set(2,deck.Deck.get(0));
                deck.Deck.remove(0);
                rp_3 = false;
                replace_time --;
            }
        }
    }

    /**
     *  Find the number of Special Card for the player
     * @return  the number of Special Cards for the player
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

    /**
     * get the replace time that the player have
     * @return the replace time that the player have
     */
    public int getReplace_time() {
        return replace_time;
    }
}
