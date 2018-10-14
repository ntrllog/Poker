import java.util.*;
import java.io.IOException;

public class GameManager {
  private Hashtable<Card, Boolean> cards = new Hashtable<Card, Boolean>();
  private Random random = new Random();

  public ArrayList<Card> makeDeck() {
    ArrayList<Card> deck = new ArrayList<Card>();

    while (deck.size() < 9) {
      int rank = random.nextInt(13);
      int suit = random.nextInt(4);
      Card card = new Card(rank, suit);
      
      if (!cards.containsKey(card)) {
        cards.put(card, true);
        deck.add(card);
      }
    }
    return deck;
  }

  public void clearScreen() {
    String os = System.getProperty("os.name");
    try {
      if (os.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }
      else {
        Runtime.getRuntime().exec("clear");
      }
    }
    catch(IOException | InterruptedException ex) {}
  }

  /**
   * time: number of milliseconds to pause program
   */
  public void printDelay(int time) {
    try {
      Thread.sleep(time);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  /**
   * return: true if p1 goes first
   */
  public boolean decideTurn() {
    Random random = new Random();
    int n = random.nextInt(2);
    if (n == 0) {
      return true;
    }
    return false;
  }
}
