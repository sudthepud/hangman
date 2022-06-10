/*
Game class - Point based hangman

People try to guess a word

Author - Sudheesh

Last Updated: 5/28/2022
5/11: Created
*/

import java.util.HashMap;
import java.util.ArrayList;
public class Game {
  // Private instance variables to store the score, guesses, right answer, current answer progress, wrong letters, number of wrong guesses, and the user information in a hashmap
//The hashmap will most likely have its own class, and I will write the code for that class next
  private HashMap<String, Integer> users;
  private int score;
  private int scorehold;
  private String rightAnswer;
  private String currentGuessWord = "";
  private ArrayList<String> wrongLetters = new ArrayList<String>();
  private static String[] words = {"brownies", "water", "orange", "chair", "cookies", "polarity", "doodle", "crumbs", "surgery", "fighter", "crates", "greater", "destroy", "creation", "dominate", "menace"}; 
  
  // Constructor, to initialize the instance variable
  public Game () {
    UsersState state = UsersState.restore();
    if (state == null)
      users = new HashMap<String, Integer>();
    else
      users = state.users;
  }


  // Method to let a users play hangman
  public void play () {
    rightAnswer = Utils.randChoice(words);
    for (int i = 0; i < rightAnswer.length(); i++){
      currentGuessWord+= "*";
      }
    int z = rightAnswer.length();
    switch (z) {
      case 5:
        score = 320*2;
        break;
      case 6:
        score = 410*2;
        break;
      case 7:
        score = 610*2;
        break;
      case 8:
        score = 1440*1;
        break;
      case 9:
        score = 1620*1;
        break;
      case 10:
        score = 1800*1;
        break;
    }
    System.out.println("");
    System.out.println ("Welcome to hangman, where you will try to guess a random words, and will lose points for each wrong letter guessed. Score is based on length of word, and number of wrong guesses");
    System.out.println(" ");
    String username = Utils.inputStr ("what is your name: ");
    System.out.println("");
    username = username.toLowerCase();
    while (score > 0) {
      String x = Utils.inputStr ("please guess a letter: ");
      x = x.toLowerCase();
      if (x.length() == 1){
        for (int b = 0; b < rightAnswer.length(); b++) {
          if (x.equals(rightAnswer.substring(b, b+1))){
            currentGuessWord = (currentGuessWord.substring(0, b) + x + currentGuessWord.substring(b+1));
          }
        }
      if (rightAnswer.indexOf(x) == -1){
          wrongLetters.add(x);
          score = score - 100;
        }
      if (score/100 == 0){
        System.out.println("");
        System.out.println("Oh no, you killed hangman");
        System.out.println("The right answer was: " + rightAnswer);
        break;
      }
      if (currentGuessWord.equals(rightAnswer)) {
        System.out.println("");
        System.out.println("🥳🥳🥳🥳");
        System.out.println("Congratulations! The right answer is: " + rightAnswer);
        System.out.println("Your Score: " + score);
        scorehold = score;
        String confirmation = Utils.inputStr ("would you like to record your score? (type y or n): ");
        System.out.println("");
        if (confirmation.equals("y")) {
          users.put(username, score);
          System.out.println("");
          System.out.println("Ok " + username + ", your score of " + score + " has been recorded");
          System.out.println("");
          }
        else {
          System.out.println("Ok");
          System.out.println("");
        }
        break;
        
      }
        System.out.println("Progress: " + currentGuessWord);
        System.out.println("Wrong Guesses: " + wrongLetters);
        System.out.println("Remaining Wrong Guesses: " + score/100);
        System.out.println("");
      }
    else {
      System.out.println("please guess 1 letter at a time!");
      System.out.println(" ");
    }
   }  
  }
public void getScores () {
  String o = Utils.inputStr("Enter your name to see your high score: ");
  System.out.println("");
  System.out.println(users.get(o));
}
public void endGame () {
  System.out.println("scores: " + users);
  UsersState state = new UsersState();
  state.users = users;
  state.save();
}
public void seeLeaderboard () {
  System.out.println("scores: " + users);
}
public void clearAnswer () {
  rightAnswer = "";
  currentGuessWord = "";
  wrongLetters.clear();
}
}