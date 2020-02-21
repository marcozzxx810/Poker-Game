import java.util.ArrayList;
/**
 *  Gamee Class
 *  It is used to hold the game mainly do the start and result
 *
 * @author MAK CHAK WING
 * @version Nov 17, 2019
 */
public class Game {
    private int game_bet;
    public  boolean gameStatus = false;

    Deck deck = new Deck();
    Player player = new Player();
    Dealer dealer = new Dealer();

    /**
     * setting the bet of the game
     * @param game_bet the bet of the game
     */
    public void setGame_bet(int game_bet) {
        this.game_bet = game_bet;
    }

    /**
     * getting the bet of the game
     * @return the bet of the game
     */
    public int getGame_bet() {
        return game_bet;
    }

    /**
     * Empty constructor for game
     */
    public Game() {

    }

    /**
     * Starting the game and initialize the game and settle all the things for the player and dealer
     */
    public void Start(){
        gameStatus = true;
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();

        deck.fillDeck();
        deck.shuffle();

        player.draw(deck);
        dealer.draw(deck);


    }

    /**
     *  Finding out who is the winner of this game
     * @return player win or not ( true : win , false : lose )
     */
    public Boolean result(){
        gameStatus = false;
        if(player.numberofSpecialCard()>dealer.numberofSpecialCard()){
            return true;
        } else if (player.numberofSpecialCard()==dealer.numberofSpecialCard()) {
            if (player.ReminderofFaceValue()>dealer.ReminderofFaceValue()){
                return true;
            }
        } else {
            return false;
        }

        return false;
    }

    /**
     * Replacing the player current hand card
     * @param pos position of hand card that want to replcae
     */
    public void replacePlayerCard(int pos){
        player.replace(this.deck, pos);
    }

    /**
     * Getting the player hand card
     * @return the arraylist of player hand card
     */
    public ArrayList<Card> getPlayerHand(){
        return this.player.hand;
    }

    /**
     * Getting the dealer hand card
     * @return the arraylist of dealer hand card
     */
    public ArrayList<Card> getDealerhand() {
        return this.dealer.hand;
    }


}
