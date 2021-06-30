import java.io.*;
import java.util.*;

public class Nim {

  public static int playerRound(int bag){
    int pick;
    Scanner in = new Scanner(System.in);
    System.out.println("How many stones (1-3)do you want to remove? ");
    pick = in.nextInt();
    while (pick < 1 || pick > 3){
      in = new Scanner(System.in);
      System.out.println("Pick again! Choose 1-3. ");
      pick = in.nextInt();
    }
    System.out.println("You are taking " + pick + " stones.");

    bag -= pick;
    return bag;
  }
  public static int aiRound(int bag){
    int pick;
    Random random = new Random();
    if (bag < 3){
      pick = random.nextInt(bag)+1;
    } else {
      pick = random.nextInt(3) +1;
    }
    System.out.println("The computer is taking " + pick + " stones.");
    bag -= pick;
    return bag;
    }




  public static void main(String[] args){
    int bag, turn;
    bag = 12;
    turn = 0;
    while (bag > 0){
      turn++;
      if (turn % 2 == 0){
        System.out.println("It's your turn.");
        bag = playerRound(bag);
      } else {
        System.out.println("It's the computer's turn.");
        bag = aiRound(bag);
      }
      System.out.println("There are " + bag + " stones left in the bag.");

    }
    if (turn % 2 == 0){
      System.out.println("Hooray! you won :) ");
    } else {
      System.out.println("Sorry, you lost :( ");
    }
  }
}
