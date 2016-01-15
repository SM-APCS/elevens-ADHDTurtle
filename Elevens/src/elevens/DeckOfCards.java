/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevens;


import java.util.Random;
/**
 *
 * @author Ivan Day
 */
public class DeckOfCards {
    private int numCards;
    public Card[] cards;
    private int NUM_CARDS = 52;
    
    public DeckOfCards(){
        numCards = NUM_CARDS;
        int cardIndex = 52;
        
        for (int faceValue = 13; faceValue >= 0; faceValue--){
            int suitValue;
            for (suitValue =  4; suitValue >= 0; suitValue--){
                cards[cardIndex] = new Card(faceValue, suitValue);
                cardIndex--;
            }  
        }
        
    }
    
    public void shuffle(){
      Random gen = new Random();

      numCards = NUM_CARDS;

      boolean[] taken= new boolean[NUM_CARDS];
      for (int i=0; i<numCards; i++)
         taken[i] = false;

      int[] shufflePositions = new int[NUM_CARDS];
      int count = 0;

      // determine shuffled positions
      while (count < 52)
      {
         int place = gen.nextInt(NUM_CARDS);
         if (!taken[place])
         {
            shufflePositions[count] = place;
            taken[place] = true;
            count++;
         }
      }

      // move cards to shuffled positions
      Card[] temp = new Card[NUM_CARDS];

      for (int i=0; i< numCards; i++)
         temp[shufflePositions[i]] = cards[i];

      cards = temp;
    }
    
    public Card deal(){
        return cards[1];
    }
    
}