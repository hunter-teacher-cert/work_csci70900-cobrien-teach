import java.io.*;
import java.util.*;

public class Driver{
  public static void main(String[] args){

    //instantiate grammar
    Grammar simpleEnglish = new Grammar();
    System.out.println("lexicon of simple English: ");
    //print lexicon
    System.out.println(simpleEnglish);

    Parser parser = new Parser(simpleEnglish);

    String sentence  = "the student  the class";
    System.out.println("Sentence: " + sentence);
    parser.parse(sentence);


    //
  //  String sentence = "the student read the book";
    //System.out.println("Good Sentence: " + sentence +"\n");
    //Parser parsifal = new Parser(simpleEnglish);
//    Boolean output = parsifal.parse(sentence);

  //  sentence = "the read student the book";
  //  System.out.println("Bad sentence:" + sentence +"\n");
  //  output = parsifal.parse(sentence);

  //  System.out.println(simpleEnglish.getLexicon());
  //  System.out.println("parse of sentence \n \n");
    //Parser parsifal = new Parser(simpleEnglish);
    //parsifal.parse(sentence);



    /*
    //instantiate the: NP. N>
    LexItem the  = new LexItem("the");
    Feature dotNP = new Feature("NP", ".");
    Feature rightN = new Feature("N", ">");
    the.addArgs(dotNP);
    the.addArgs(rightN);


    //instantiate dog: N.
    LexItem dog = new LexItem("dog");
    Feature dotN = new Feature("N", ".");
    dog.addArgs(dotN);

    System.out.println("The dog = " + simpleEnglish.apply(the,dog));
    System.out.println("dog the = " + simpleEnglish.apply(dog,the));



    //instantiate the: NP. N>
    LexItem the  = new LexItem("the");
    Feature dotNP = new Feature("NP", ".");
    Feature rightN = new Feature("N", ">");
    the.addArgs(dotNP);
    the.addArgs(rightN);


    //instantiate dog: N.
    LexItem dog = new LexItem("dog");
    Feature dotN = new Feature("N", ".");
    dog.addArgs(dotN);

    //instantiate grammar
    Grammar simpleEnglish = new Grammar();
    simpleEnglish.addLex(the);
    simpleEnglish.addLex(dog);
    System.out.println(simpleEnglish);

    //System.out.println("first feature of the: " + the.topFeature());
    System.out.println("Can I apply 'the' to 'dog'? " + simpleEnglish.compatible(the, dog));

    System.out.println("Can I apply 'dog' to 'the'? " + simpleEnglish.compatible(dog, the));
    //print first word in lexicon
    String word = simpleEnglish.getWord(0);
    System.out.println("first word in lexicon: " + "<"+ word+">");
    System.out.println( word.getClass());

    //split sentence to array
    String sentence = "the student read the book";
    String[] arr = sentence.split(" ");

    //print first word
    System.out.println("First word of sentence array: " + "<"+arr[0]+">");
    System.out.println( arr[0].getClass());

    //are words the same?
    Boolean isSame = word == arr[0];
    System.out.println("Is " +"<" +word+">" + " the same word as " + "<"+arr[0]+">"+"?  " + isSame);

    isSame = word.equals(arr[0]);
    System.out.println("Is " +"<" +word+">" + " the same word as " + "<"+arr[0]+">"+"?  " + isSame);



    */
  }
}
