import java.io.*;
import java.util.*;

/**
   The Rules of Life:
   Survivals:
   * A cell with 2 or 3 living neighbours will survive for the next generation.
   Death:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Birth:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
*/

public class Cgol
{

  //initialize empty board (all cells dead)
  public static char[][] createNewBoard(int rows, int cols) {
    char[][] board = new char[rows][cols];
    return board;
  }


  //print the board to the terminal
  public static void printBoard(char[][] board) {
    for (char[] rows : board){
      for (char cell : rows){
        if (cell == 'X'){
          System.out.print(cell+"|");
        } else{
          System.out.print(" |");
        }
      }
      System.out.print("\n");
    }
    System.out.print("\n");
  }


  //set a single cell  located at (rows, cols) to value val
  public static void setCell(char[][] board, int rows, int cols, char val){
      board[rows][cols] = val;

  }


  //return number of living neigbours of board[r][c]
  public static int countNeighbours(char[][] board, int rows, int cols) {
    //Chris: what if we treat this method as the following:
    //search the area around a given r,c by summing the space around import junit.framework.TestCase;
    //as a 3x3 2D array. (See image on slack)
    //initialize sum as zero, this will store the number of living neighbor cells.
    int sum = 0;
    //search rows about and below the cell
    for (int r = rows -1; r < rows + 2; r++){
      //make sure rows aren't outside of array
    //  System.out.println("r = " + r);
      if (r <board.length && r >= 0){
        //search 3 cells in row;
        for (int c = cols -1; c < cols+2; c++){
          //make sure cells our within array
          //  System.out.println("c = " + c);
            if (c < board[r].length && c >= 0 && !(r == rows && c ==cols)){
              //if cell ==X add 1 to sum.
              //System.out.println("This cell contains " + board[r][c]);
              if (board[r][c] == 'X'){
                sum +=1;
              }

            }
        }  //end of inner loop
      } //end of if statement for the outer loop
    } //end of outer loop
      return sum;
  }


  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell(char[][] board,int rows, int cols) {
    //
    int numNeighbors = countNeighbours(board, rows, cols);
    char newCell = ' ';
    //decide if cell is alive or dead;
    if (board[rows][cols] == 'X') {//cell is alive
      //decide if cell less than 2 or more than 3 neighbors
      if(numNeighbors > 3 || numNeighbors < 2){
        newCell = ' ';//cell dies
      } else {//otherwise cell lives
        newCell = 'X';//cell lives
      }
    } else {//cell is dead
      //decide if cell has exactly 3 countNeighbours
      if (numNeighbors == 3){
        newCell = 'X'; //cell is born
      } else {
        newCell = ' '; //cell stays dead
      }
    }
    return newCell;
  }


  //generate new board representing next generation
  public static char[][] generateNextBoard(char[][] board) {
    int numRow, numCol;
    numRow = board.length;
    numCol = board[0].length;
    char[][] newBoard = createNewBoard(numRow,numCol);
    for (int row =0; row < numRow; row++){
      for (int cell =0; cell < numCol; cell++){
        newBoard[row][cell] = getNextGenCell(board, row, cell);
      }
    }
    return newBoard;
  }
  public static char[][] genRandCells(char[][] board, int numRand){
    Random random = new Random();
    int rowRand,colRand, numRow, numCol;
    numRow = board.length;
    numCol = board[0].length;
    for (int i = 0; i<numRand; i++){
      rowRand = random.nextInt(numRow);
      colRand = random.nextInt(numCol);
      while (board[rowRand][colRand] == 'X'){
        rowRand = random.nextInt(numRow);
        colRand = random.nextInt(numCol);
      }
      setCell(board, rowRand, colRand, 'X');

    }
    return board;
  }
  public static void playGOL(){
    Scanner in = new Scanner(System.in);

    //How big an array do you want?
    //how many rows? enter an integer
    System.out.println("How many rows do you want in your array?");
    int numRows = in.nextInt();

    //how many columns?
    System.out.println("How many columns do you want in your array?");
    int numCols = in.nextInt();

    //initialize array
    char[][] board = createNewBoard(numRows, numCols);

    //How many random cells do you want to activate
    System.out.println("How many cells do you want to randomly activate?");
    int numRand = in.nextInt();
    //populate board with numRand cells in random locations
    board = genRandCells(board, numRand);
    System.out.println("Your initial board:");
    printBoard(board);
    System.out.println("How many generations do you want to watch?");
    int numGen = in.nextInt();
    //play gane for numGen generations
    for (int gen = 1; gen < numGen +1; gen++){
      System.out.println("Gen #"+gen);
      board = generateNextBoard(board);
      printBoard(board);
    }




  }
  public static void main( String[] args )
  {
    playGOL();
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    char[][] board;
    board = createNewBoard(25,25);
    //testing if board exists.
  //  System.out.println("# of rows: " + board.length);
  //  System.out.println("# of columns: " + board[0].length);

    //breathe life into some cells:
    setCell(board, 10, 10, 'X');
  //  printBoard(board);
  //  int sum = countNeighbours(board, 0 ,0);
  //  System.out.println("# of neighbors: " + sum);
    setCell(board, 10, 11, 'X');
//    printBoard(board);
  //  sum = countNeighbours(board, 0 ,0);
  //  System.out.println("# of neighbors: " + sum);
    setCell(board, 10, 12, 'X');
    setCell(board,9,12,'X');
    setCell(board,8,11,'X');
    //printBoard(board);
    //sum = countNeighbours(board, 0 ,0);


    System.out.println("# of neighbors: " + sum);
    System.out.println("Cell at 1,1 is initially a " + board[1][1]);
    char newCell  = getNextGenCell(board, 1,1);
    System.out.println("cell at (1,1) will become a " + newCell);



    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    System.out.println("Gen X:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    board = generateNextBoard(board);
    System.out.println("Gen X+1:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    int roundNum = 0;
    for (int i=0; i<5; i++){
      roundNum  = i+1;
      System.out.println("Round #" +roundNum);
      board = generateNextBoard(board);
      printBoard(board);
    }
    //make glider


    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end classd
