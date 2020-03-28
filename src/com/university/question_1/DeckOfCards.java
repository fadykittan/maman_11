package com.university.question_1;
// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards
{
   private ArrayList<Card> deck; // array of Card objects
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
   // random number generator
   private static final Random randomNumbers = new Random();

   // constructor fills deck of Cards
   public DeckOfCards()
   {
      String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
      int[] values = {0,2,3,4,5,6,7,8,9,10,10,10,10};

      deck = new ArrayList<Card>(); // create array of Card objects

      // populate deck with Card objects
      for ( int count = 0; count < NUMBER_OF_CARDS; count++ ) {
         Card card = new Card(faces[count % 13], values[count % 13], (count % 13) == 0? true : false);
         deck.add(card);
      }
   } // end DeckOfCards constructor

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      Object[] arr = deck.toArray();
      // for each Card, pick another random Card (0-51) and swap them
      for ( int first = 0; first < arr.length; first++ )
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
         
         // swap current Card with randomly selected Card
         Object temp = arr[ first ];
         arr[ first ] = arr[ second ];
         arr[ second ] = temp;
      } // end for


      deck = new ArrayList<Card>();

      for(int i=0 ; i<arr.length ; i++){
         deck.add( (Card) arr[i] );
      }

   } // end method shuffle


   // deal one Card
   public Card dealCard()
   {
      Card c = deck.get(0);
      deck.remove(0);
      return c;
   } // end method dealCard
} // end class DeckOfCards


/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
