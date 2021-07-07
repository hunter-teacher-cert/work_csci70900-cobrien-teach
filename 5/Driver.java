import java.io.*;
import java.util.*;

//TEAMWORK: Chris, Lyuba, Marina

public class Driver {

  public static void main(String[] args) {

    //declare a var of appropriate type to assign an instance of Time to
    Time t;

    //assign var the address of a newly-apportioned Time object
    //instantiate a newly-created Time object (aka "instance of class Time") with default value(s)
    t = new Time();
  	Time.printTime(t);

  	//instantiate a newly-created Time object with specified value(s)
  	Time t1;
  	t1 = new Time(10, 32, 54.3);

  	//assign a Time var the value null
  	t=null;


  	//assign a Time var the value of an existing Time var
  	t=t1;

  	//print all of the above (See multiple ways to do this? Try all -- and document in comments!)
  	Time.printTime(t);

  	//print using toString
  	String printString = t1.toString();
  	System.out.print("Time printed as a string: " + printString);

  	System.out.print("Time printed by implicitly invoking toString method: " + t1);

  	//test for equality of each of the Time instances above. Print results.
  	boolean isEqual=t1.equals(t);
  	System.out.println("is Time equal?: " + isEqual);

  	//add two Time objects and print results
  	Time sum = Time.add(t, t1);
  	System.out.print("Adding using a static method and 2 parameters: " + sum);
  	Time sum1 = t.add(t1);
  	System.out.print("Adding using an instance method and 1 parameter: " + sum1);


//add two Time objects and print results
//add two Time objects and save the result in another Time object
  }//end main()

}//end class
