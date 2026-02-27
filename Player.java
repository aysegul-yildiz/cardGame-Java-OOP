package cardgame;

import java.util.Random;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author:
// date:
public class Cards
{
    final int NOOFCARDSINFULLPACK = 52;
    
    // properties
    Card[] cards;
    int    valid;  // number of cards currently in collection
    
    // constructors
    public Cards( boolean fullPack)
    {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if (fullPack)
            createFullPackOfCards();
    }
    
    // methods
    public Card getTopCard()
    {
        Card tmp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned?
            valid++;
            return true;
        }
        return false;
    }
    
    public void createFullPackOfCards()
    {
        // for loop to ceate full pack of cards
        for(int i = 0; i < 52; i++ ){
            addTopCard( new Card(i) );
        }
    }
    
    public void shuffle()
    {
        // swap cards with random number of cards
        Random rand = new Random();
        for(int i = 0; i < cards.length; i++ ){
            int num = rand.nextInt(0, cards.length);
            Card card = new Card(i);
            card =  cards[i];
            cards[i] = cards[num];
            cards[num] = card;
        }
    }
    
} // end class Cards
