import java.util.*;
import java.io.*;

public class 02_lesson {
//1st question: How do we find the factorial of, let's say, 4?
//Ans: 4! = 4*3*2*1
//So if we want to find n!, we need to multiply n by (n-1), (n-2)...1.
//we want to construct two programs for finding the factorial of n. let's start
//off with a non recursive method.
  public static int fact(int n){
    //how could we generate (n-1)...n? Ans: for loop
    for (int i = n-1; i>0; i--){
      n = n*i;
    }
    return n;
  }
// next let's try a recursive method.
//First we'll need a base case, what will be the base case for this?
//ans: if n=0, return 1
  public fact_rec(int n){
    if (n ==0){
      return 1;
    } else {
      //what do we do otherwise?
      // multiply n by fact(n-1);
     return n*fact(n-1);
    }
  }

  public static void main(String[] args){
    int ans = fact(4);
    System.out.println(ans);
  }
}
