import java.io.*;
import java.util.*;

public abstract class Game {
  // The BufferedReader used throughout
  public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

  // The random number generator used throughout
  public static RandomInterface r = LinearCongruentialGenerator.getInstance();

  public void playGame() throws Exception {}

  public static void main(String[] args) throws Exception {
    // Ask whether to play a card game or a die game

    System.out.print("Card (c) or Die (d) game? ");
    String ans=br.readLine();

    GameFactory gameFactory = new GameFactory();
    Game currentGame = gameFactory.getGame(ans);
    currentGame.playGame();

  }
}



