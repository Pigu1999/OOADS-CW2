import java.io.*;
import java.util.*;

class c extends Game { 
  // Variable(s) used in the card game methods
  private static ArrayList<String> cardList = new ArrayList<String>();
  private static HashSet<String> cardsChosen=new HashSet<String>();

  public void playGame() throws Exception {
      // Play card game:

      // Initialise the game
      initialiseCardGame();

      // Play the main game phase
      mainCardGame();

      // Now see if (s)he has won!
      declareCardGameWinner();
  }

  private static void initialiseCardGame() throws Exception {
      // The initialisation phase:

      // Create a list of cards
      createAListOfCards();
      
      // Shuffle them
      shuffleCardDeck(cardList);

      // Print out the result
      System.out.println(cardList);
  }

  private static void shuffleCardDeck(ArrayList<String> cardList) throws Exception{
    for (int i=0; i<100; i++) {
        // choose two random cards at random and swap them, 100 times
        int firstIndex=((int) (r.next() * 52));
        int secondIndex=((int) (r.next() * 52));
        String temp=(String) cardList.get(firstIndex);
        cardList.set(firstIndex, cardList.get(secondIndex));
        cardList.set(secondIndex, temp); 
      }
  }

  private static void createAListOfCards() throws Exception{
    String suits[] = {"Hrts","Dmnds","Spds","Clbs"};
    String numbers[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 13; j++){
        //adds a card to the array list in suit order
        cardList.add(numbers[j]+suits[i]);

      }
    }
  }


  private static void mainCardGame() throws Exception {
      // The main game:

      // Let user select two cards from the pack
      for (int i=0; i<2; i++) {
        System.out.println("Hit <RETURN> to choose a card");
        br.readLine();

        int cardChoice=(int) (r.next() * cardList.size());
        System.out.println("You chose " + cardList.get(cardChoice));
        cardsChosen.add(cardList.remove(cardChoice));
      }

      // Display the cards chosen and remaining cards
      System.out.println("Cards chosen: " + cardsChosen);
      System.out.println("Remaining cards: " + cardList);

  }

  private static void declareCardGameWinner() throws Exception {
      // Declare the winner:

      // User wins if one of them is an Ace 
      System.out.println("Cards chosen: " + cardsChosen);
      if (cardsChosen.contains("AHrts") || cardsChosen.contains("ADmnds") ||
          cardsChosen.contains("ASpds") || cardsChosen.contains("AClbs")) {
        System.out.println("You won!");
      }
      else System.out.println("You lost!");
  }

}