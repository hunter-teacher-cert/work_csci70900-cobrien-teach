import java.io.*;
import java.util.*;

public class BarGraphify{
  public static void main (String[]arg){
    int[] myList =  {0,1,2,3,4};
    int[] newList = {1,0,3,2};
  //  System.out.println(Arrays.toString(myList));
      System.out.println("first list:");
      makeGraph(myList);
      System.out.println("second list:");
      makeGraph(newList);

  }

  public static void makeGraph(int[] myList){
    //String output = makeBar(myList[1]);
  //  System.out.println("1: " + output);
    for (int var: myList){
      System.out.println(var+": " +makeBar(var));
    }
    /*
    print out makeBar
    */
  }
//method
  public static String makeBar(int x){
    String output="";
    for(int i=0; i<x; i++){
      output+= "=";
    } return output;
  }//string method


}//end class
