import java.io.*;
import java.util.*;

class Mancala {
  //instane var
  private ArrayList<Integer> board;

  //constructor
  public Mancala(){
    this.board = new ArrayList<Integer>(14);
    startBoard();
  }//end constructor
  //populates board with 4 in pits and
  private void startBoard(){

    for (int i = 0; i < 14; i++){
      if(i==6 || i==13){
        this.board.add(0);
      } else{
        this.board.add(4);
      }
    }

  } //end startBoard

  public String toString(){
    String  boardString = this.board.get(6) + " ";

    for (int i = 0; i < this.board.size(); i++){
      if (i ==6){
        boardString += "\n  ";
      } else{
        boardString += this.board.get(i) + " ";
      }
    }
    return boardString;


  }//end toString

  public ArrayList<Integer> getBoard(){
    return this.board;
  }

}// end Mancala
