import java.io.*;
import java.util.*;
public class Craps2 {
  public static int roll(int maxInt){
    Random random = new Random();
    int myRoll = random.nextInt(maxInt) +1;
    return myRoll;
  }

  public static int shoot(int numDice, int maxVal){
    int myRoll, result =  0;
    for (int i= 0;i< numDice; i++){
      myRoll = roll(maxVal);
      result += myRoll;
    }
    System.out.println("You rolled a " + result);
    return result;


  }

  public static Boolean round(){
    int numDice, maxVal, myRoll, point, newRoll;
    Boolean result;
    numDice = 2;
    maxVal = 6;
    myRoll = 0;
    point = 0;
    result = null;
    myRoll = shoot(numDice, maxVal);
    if (myRoll == 2 || myRoll == 3 || myRoll == 12){
      System.out.println("You rolled a " + myRoll + " on your first roll, You lose!");
      result = true;
    } else if( myRoll == 7 || myRoll == 11) {
      System.out.println("You rolled a " + myRoll + " on your first roll, You win!");
      result = false;

    }
    else {
      point = myRoll;
      System.out.println("Your point is " + point);
      while (true){
        newRoll = shoot(numDice, maxVal);
        if (point == newRoll){
          System.out.println(" You rolled your point, You win!");
          result = true;
          break;
        }
        if (newRoll == 7) {
          result = false;
          System.out.println("You rolled a 7, You Lose!");
          break;
        }

      }
    }
    System.out.println("Did you win? " + result);
    return result;
  }
  public static void stats(Boolean[] results){
    int wins = 0;
    int numGames = results.length;
    for (Boolean result : results) {
      if (result){
        System.out.println(result);
        wins++;
      }
    }
    double percentage;
    percentage = (wins/numGames)*100;
    System.out.println("You won" + percentage + "% games.");
  }

  public static void main(String[] args){
    int numRound, roundNum;
    Boolean result;
    Scanner in = new Scanner(System.in);
    System.out.println("How many rounds do you want to play?");
    numRound = in.nextInt();
    Boolean[] results = new Boolean[numRound];
    for (int i=0; i < numRound; i++){
      roundNum = i+1;
      System.out.println("Round #"+roundNum + ": ");
      result = round();
      results[i] = result;
    }
    System.out.println(Arrays.toString(results));

    //stats(results);


  }
}
