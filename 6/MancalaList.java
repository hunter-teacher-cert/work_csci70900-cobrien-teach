import java.io.*;
import java.util.*;

class MancalaList {
  public static void startBoard(ArrayList<Integer> gameboard) {
    //sets all pits to 4; ignores mancalas
    for (int i = 0; i < gameboard.size(); i++){
      if (!(i == 6 || i == 13)){
        gameboard.set(i, 4);
      }//end if
    }// end for
  }//end startboard
  public static void displayBoard(ArrayList<Integer> gameboard){
    String topString, bottomString, elem;
    //initialize top string with M1 in front
    topString = gameboard.get(6) + " ";
    bottomString = " " + gameboard.get(13);
    elem = "";
    //set p1-p6 to 4;
    for (int i = 0; i < 6; i++) {
      elem = gameboard.get(i);
      System.out.println(" " + elem);
    }
    //set p7-p13 to 4
    for (int i =7; i< 14; i++){
      elem = gameboard.get(i);
      System.out.print(elem + " ");
    }
  }//end displayboard


  public static void Main(String[] args) {
    /* create a gameBoard array,
    0-5: player one's pits, total of 6 (p1-p6)
    6: player 1's Mancala (M1)
    7-12: player two's pits, total of 6 (p7-p12)
    13: player two's Mancala (M2)
    */
    ArrayList<Integer> gameboard =   new ArrayList<Integer>(14);
    //startBoard(gameboard);
  //  displayBoard(gameboard);
  } // end Main
}
