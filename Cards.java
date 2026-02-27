package cardgame;
import java.util.ArrayList;

// Cardgame
// author:
// date:
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo = 0;
    int               turnOfPlayer;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        players = new ArrayList<>();
        fullPack = new Cards(true);
        // fill the array list with given players
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        fullPack.shuffle();
        for(int i = 0; i < 52; i++ ){
            p1.add(fullPack.getTopCard());
            p2.add(fullPack.getTopCard());
            p3.add(fullPack.getTopCard());
            p4.add(fullPack.getTopCard());
        }
        scoreCard = new ScoreCard(4);
    }
    
    // methods
    public boolean playTurn( Player p, Card c)
    {
        // if turn is on add the card
        if( !isTurnOf( p )){
            p.add(c);
            isTurnOf(p);
            roundNo++;
            return true;
        }
        return false;
    }
    
    public boolean isTurnOf( Player p)
    {
        if(p.getName().equals(players.get(turnOfPlayer).getName()))
        return true;
        return false;
    }
    
    public boolean isGameOver()
    {
        if(players.get(players.size() - 1).hand.valid == 0)
        return true;
        return false;
    }
    
    public int getScore( int playerNumber)
    {
        return scoreCard.getScore(playerNumber);
    }
    
    public String getName( int playerNumber)
    {
        return players.get(playerNumber).getName(); 
    }
    
    public int getRoundNo()
    {
        return roundNo;
    }
    
    public int getTurnOfPlayerNo()
    {
        return turnOfPlayer;
    }
    
    public Player[] getWinners()
    {
        Player[] winners = {players.get(0), players.get(1), players.get(2), players.get(3)};
        return winners;
    }
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
    
}