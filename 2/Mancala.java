import java.io.*;
import java.util.*;

/*
TODO:
implement turn for player 1
*/

public class Mancala {

  public static int sum(int[] pits){
    //adds up the seeds an array. Used for isGameOver.
    int mySum = 0;
    for (int pit : pits){
      mySum += pit;
    }
    return mySum;
  }
  public static Boolean isGameOver(int[] gameBoard){
    //checks if p1-p6 or p7-p12 is empty;
    Boolean gameOver = false;
    // create slice for p1:p6
    //create slice for p7:p12
    int[] pitsOne = Arrays.copyOfRange(gameBoard, 0,6);
    int[] pitsTwo = Arrays.copyOfRange(gameBoard, 7,13);
    int sumOne = sum(pitsOne);
    int sumTwo = sum(pitsTwo);
    if (sumOne + sumTwo == 0){
      gameOver = true;
    }
    return gameOver;
  }

  public static int[] startBoard(int[] gameBoard) {
    for (int i = 0; i< gameBoard.length; i++){
      if (i == 6 || i == 13){
        continue;
      } else {
          gameBoard[i] = 4;
        }

    }
    return gameBoard;

  }

  public static int[] playerOneTurn(int[] gameBoard){
    //Player one can pick p1-p6. Then the n seeds in the p are sown in the next n places.
    Scanner in = new Scanner(System.in);
    System.out.println("Current board: ");
    displayBoard(gameBoard);
    System.out.print("Player 1. Which pit (0, 1, 2, 3, 4, 5) do you choose?");
    int choice = in.nextInt();
    int numSeeds = gameBoard[choice];
    int lastIndex = choice +numSeeds + 1;
    gameBoard[choice] = 0;
    for (int i = choice + 1; i < lastIndex; i++) {
      int modI = i %14;
      if (modI == 13) {
        //skip opponents mancala
        continue;
      } else {
        //place seed in pit/ player 1's mancala
      gameBoard[modI] = gameBoard[modI] + 1;

      }

    }

    return gameBoard;
  }



  public static int[] playerTwoTurn(int[] gameBoard){
    //Player two can pick p1-p6. Then the n seeds in the p are sown in the next n places.
    Scanner in = new Scanner(System.in);
    System.out.println("Current board: ");
    displayBoard(gameBoard);
    System.out.print("Player 2. Which pit (7, 8, 9, 10, 11, 12) do you choose?");
    int choice = in.nextInt();
    int numSeeds = gameBoard[choice];
    int lastIndex = choice +numSeeds + 1;
    gameBoard[choice] = 0;
    for (int i = choice + 1; i < lastIndex; i++) {
      int modI = i %14;
      if (modI == 6) {
        //skip opponents mancala
        continue;
      } else {
        //place seed in pit/ player 1's mancala
      gameBoard[modI] = gameBoard[modI] + 1;

      }

    }

    return gameBoard;


  }

  public static void displayBoard(int[] gameBoard){
    //Displays
    /* initialize topString, bottomString
    Board will look like
    M1 p1 p2 p3 p4 p5 p6
       p7 p8 p9 p10 p11 p12 M2
    Initialize top and bottom strings for board display.
    */
    String topString, bottomString;
    topString = " ";
    bottomString = " ";
    //left concatenate p1-p6 and m1 to topString
    for (int i=0; i<7;i++){
      topString = gameBoard[i] + " " +topString;
    }
    //right concateneate p7-p12 and m2 to bottom String
    for (int i = 7; i <14; i++){
      bottomString = bottomString + " " + gameBoard[i];
    }

    //print top string and bottom string in two lines
    System.out.println(topString);
    System.out.println(bottomString);
  }
  public static void checkWinner(int[] gameBoard){
    // calculate points for player one
    int pointsOne = gameBoard[6];
    //calculate points for player two;
    int pointsTwo = gameBoard[13];
    if (pointsOne > pointsTwo){
      System.out.println("Player one, you are the winner!");
    } else if (pointsTwo > pointsOne){
      System.out.println("Player two, you are the winner!");
    } else {
      System.out.println("You tied!");
    }
  }
  public static void playGame(){
    /* create a gameBoard array,
    0-5: player one's pits, total of 6 (p1-p6)
    6: player 1's Mancala (M1)
    7-12: player two's pits, total of 6 (p7-p12)
    13: player two's Mancala (M2)
    */
    int[] gameBoard;
    gameBoard = new int[14];

    //Initialize gameboard with four seeds in each pit
    gameBoard = startBoard(gameBoard);

    /*Ask players for their name
    Scanner in = new Scanner(System.in);
    System.out.println("Hey player one, what's your name? ");
    String nameOne = in.nextLine();
    System.out.println("Welcome " + nameOne + "!");

    System.out.println("Hey player two, what's your name?");
    String nameTwo = in.nextLine();
    System.out.println("Welcome " + nameTwo +"!");
    */
    //set turn number, player one goes on even turns, player two on odd turns.
    int turn = 0;
    //play game until game is over alternating between player one and two.
    while (true){
      if(turn%2 ==0){
        gameBoard = playerOneTurn(gameBoard);

        } else {
          gameBoard = playerTwoTurn(gameBoard);
        }
        //check if gameboard has reached final state. If so, end game.
        if (isGameOver(gameBoard)){
          break;
        }
        turn++;
      }
      checkWinner(gameBoard);
  }

  public static void main(String[] args) {


    System.out.println("Welcome to CyberMancala (beta)!");
    System.out.println("Right now this is a simplified version of the classic game Mancala.");
    System.out.println("We hope to add more features in the future.");

    while (true){
      playGame();
      Scanner in = new Scanner(System.in);
      System.out.println("Do you want to play again (yes/no)");
      String playAgain = in.nextLine();
      if (playAgain == "no") {
        System.out.println("Bye! Hope you play again sometime!");
        break;
      } //end if statement

    } //end while loop


  } // end main
}
