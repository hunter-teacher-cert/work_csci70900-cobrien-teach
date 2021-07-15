import java.io.*;
import java.util.*;

class MancalaDriver {
  public static void main(String[] args){
    Mancala game = new Mancala();
    ArrayList<Integer> board = game.getBoard();
  //  System.out.println("size of board: "+ board.size());
  System.out.print(game);
  } //end main

}// end MancalaDriver
