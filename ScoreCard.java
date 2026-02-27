package cardgame;

// Player - Simple card game player with name and hand of cards
// author:
// date:
public class Player
{
    // properties
    String name;
    Cards hand = new Cards(false);
    
    // constructors
    public Player( String name)
    {
        // initialize player name
        this.name = name;
    }
    
    // methods
    public String getName()
    {
        return name;
    }
    
    public void add( Card c)
    {
        hand.addTopCard(c);
    }
    
    public Card playCard()
    {
        return hand.getTopCard();
    }
    
} // end class Player
