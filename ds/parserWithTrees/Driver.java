import java.io.*;
import java.util.*;

public class Driver{
  public static void main(String[] args){

    //instiate grammar
    Grammar simpleEnglish = new Grammar();
    Parser parser = new Parser(simpleEnglish);
    String sentence = "the student read the book";
    parser.parse(sentence);


  }
}
