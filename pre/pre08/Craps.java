import java.io.*;
import java.util.*;
public class Craps {
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

  public static String round(){
    int numDice, maxVal, myRoll, point, newRoll;
    numDice = 2;
    maxVal = 6;
    myRoll = 0;
    point = 0;
    String result = "You're not finished playing yet!";
    myRoll = shoot(numDice, maxVal);

    if (myRoll == 2 || myRoll == 3 || myRoll == 12){
      result = "You rolled a " + myRoll + " on your first roll, You lose!";

    } else if( myRoll == 7 || myRoll == 11) {
      result = "You rolled a " + myRoll + " on your first roll, You win!";

    }
    else {
      point = myRoll;
      System.out.println("Your point is " + point);
      while (true){
        newRoll = shoot(numDice, maxVal);
        if (point == newRoll){
          result = " You rolled your point, You win!";
          break;
        }
        if (newRoll == 7) {
          result = "You rolled a 7, You Lose!";
          break;
        }

      }
    }

    return result;
  }
  public static void main(String[] args){
    int numRound;
    String result;
    Scanner in = new Scanner(System.in);
    System.out.println("How many rounds do you want to play?");
    numRound = in.nextInt();
    for (int i=1; i < numRound +1; i++){
      result = round();
      System.out.println("Result of Round #"+i + ": " + result);
    }


  }
}
