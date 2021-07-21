import java.util.*;
import java.io.*;
public class Driver{
  public static void main(String[] args){
    SortDemo sortDemo  = new SortDemo();
    ArrayList<Integer> unSorted = sortDemo.makeRand(10);
    System.out.println("Unsorted list:");
    System.out.println(unSorted);
    ArrayList<Integer> sorted = sortDemo.msort(unSorted);
    System.out.println("Sorted list:");
    System.out.println(sorted);

  }
}
