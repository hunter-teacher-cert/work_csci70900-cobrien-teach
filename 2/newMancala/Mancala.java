import java.io.*;
import java.util.*;

class Mancala {
  //instane var
  private ArrayList<Integer> board;

  //constructor
  public Mancala(){
    this.board = new ArrayList<Integer>(14);
    this.board = startBoard(this.board);
  }//end constructor

  public static ArrayList<Integer> startBoard(ArrayList<Integer> board){
    //ArrayList<Integer> board = new Arraylist<Integer>(14);
    for (int i = 0; i < board.size(); i++){
      if(!(i==6 || i==13)){
        board.set(i, 4);
      }
    }
    return board;
  } //end startBoard

  public String toString(){
    /*
    String topString, bottomString, fullString;
    topString = this.board.get(6) + " ";
    bottomString = " " + this.board.get(13);
    for (int i = 0; i < 6; i++){
      topString = topString + this.board.get(i) + " ";

    }
    System.out.println(topString);
    for (int i =7; i<14; i++){
      bottomString = this.board.get(i) + " " + bottomString;
    }
    fullString = topString + "\n" + bottomString;
    */
    String fullString = "yay";
    return fullString;

  }//end toString

}// end Mancala
