/*
Main - this is a runner class that runs the Game class

Author - Sudheesh Dabbara
*/
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
  Game g = new Game();
  int go = 1;
  while (go > 0) {
    System.out.println("");
    int start = Utils.inputNum("Would you like to play(1), view high scores(2), or quit(3): ");
    if (start == 1) {
      g.clearAnswer();
      g.play();
    }
    if (start == 2) {
      g.seeLeaderboard();
      }
    if (start == 3) {
      System.out.println("Thank you for playing hangman!");
      g.endGame();
      break;
    }
  }
  }
}

