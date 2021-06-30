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
    System.out.println("pitsOne: " + Arrays.toString(pitsOne));
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
    System.out.print("Current board: ");
    displayBoard(gameBoard);
    System.out.print("Player 1. Which pit (0, 1, 2, 3, 4, 5) do you choose?");
    int choice = in.nextInt();
    int numSeeds = gameBoard[choice];
    gameBoard[choice] = 0;
    for (int i = choice + 1; i < choice + numSeeds + 1; i++) {
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
    System.out.print("Current board: ");
    displayBoard(gameBoard);
    System.out.print("Player 2. Which pit (7, 8, 9, 10, 11, 12) do you choose?");
    int choice = in.nextInt();
    int numSeeds = gameBoard[choice];
    gameBoard[choice] = 0;
    for (int i = choice + 1; i < choice + numSeeds + 1; i++) {
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
    System.out.println(Arrays.toString(gameBoard));

  }

  public static void main(String[] args) {
    /* create a gameBoard array,
    0-5: player one's pits, total of 6 (p1-p6)
    6: player 1's Mancala (M1)
    7-12: player two's pits, total of 6 (p7-p12)
    13: player two's Mancala (M2)
    */
    int[] gameBoard;
    gameBoard = new int[14];
    gameBoard = startBoard(gameBoard);
    //place 20 stones in p6
    Boolean gameOver = isGameOver(gameBoard);
    System.out.println("Is game over? " + gameOver);
    //gameBoard = playerOneTurn(gameBoard);
    //displayBoard(gameBoard);


  }
}
