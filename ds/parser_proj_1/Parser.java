import java.io.*;
import java.util.*;
/*
This implements a bottom up right-to-left parser. It contains two stack objects.
One of these stacks  I (confusingly) named 'the stack', the other is the memory.
The Parser works by:
(i) taking a string and splitting it into an array of "words" (substrings
seprated by " "
(ii) A search is conducted through the lexicon for lexical items (see grammar)
that match a word. If one is found, a copy of the lexical item is placed on the
stack. because this occurs in order. The first word of the sentence is on the
bottom of the stack, the last word on top.


(iii)The parser works as follows:
  (a) Pop one tree from the stack, tree A. Then another tree B.
  (b)Apply merge(A,B). If this is successful, push the output onto the stack.
  Otherwise push A and B back onto stack in original order, then:
    (i) see if the top of memory (tree C) can successfully merge with tree A.
    If yes push ouput of that onto stack.
    If no, pop A from stack, push onto memory.
  (c) Keep doing this until you can't do any further moves. In that case there
  are two possibilities (i) memory is empty, and stack contains just a tree
  whose root is category S. In that case, you have a sentence of English or (ii)
  the conditions in (i) do not obtain. In that case you do not have a sentence of
  English.

There's probably (hopefully) a mathematical proof that this can parser any sentence in the
grammar, but I haven't worked it out. In any case, it's worked for every
sentence and non-sentence I've tried.

*/
public class Parser{
  private Grammar grammar = null;
  private Stack<LexItem> stack = null;
  private Stack<LexItem> memory = null;

  public Parser(Grammar grammar){
    this.grammar = grammar;
    stack = new Stack<LexItem>();
    memory = new Stack<LexItem>();

  }

  public void makeStack(String string){
    String[] sentence = string.split(" ");
  //  System.out.println("words of sentence: " + Arrays.toString(sentence));
    LexItem lexItem = null;
    String phon = null;
    for (String word : sentence){
    //  System.out.println("word: " + "<" + word+ ">");
      for ( int i=0; i< grammar.getLexicon().size();i++){
        lexItem = grammar.getWord(i);
        phon = lexItem.getPhon();
      //  System.out.println("lexical item: " + "<" + phon+ ">") ;
      //  Boolean isSame = phon.equals(word);
      //  System.out.println("Is " +  "<" + word+ ">" +" the same as " + "<" + phon+ ">? " + isSame);
        if (phon.equals(word)){
          stack.push(lexItem);
          break;
        }//end if
        if (i == grammar.getLexicon().size() - 1){
          //change to raise exception later.********
          System.out.println(word + " is not a valid word in simpleEnglish");

        }
      }//inner for

    ///  break;
    }//end for
  }// end makeStack

  public void makeStackBackward(String string){
    String[] sentence = string.split(" ");
  //  System.out.println("words of sentence: " + Arrays.toString(sentence));
    LexItem lexItem = null;
    String phon = null;
    String word = null;
    for (int j = sentence.length - 1; j>= 0; j--){
      word = sentence[j];
  //  for (String word : sentence){
    //  System.out.println("word: " + "<" + word+ ">");
      for ( int i= 0; i < grammar.getLexicon().size()  ;i++){
        lexItem = grammar.getWord(i);
        phon = lexItem.getPhon();
      //  System.out.println("lexical item: " + "<" + phon+ ">") ;
      //  Boolean isSame = phon.equals(word);
      //  System.out.println("Is " +  "<" + word+ ">" +" the same as " + "<" + phon+ ">? " + isSame);
        if (phon.equals(word)){
          stack.push(lexItem);
          break;
        }//end if

      }//inner for

    ///  break;
    }//end for

  }//end make stack backward
  public Boolean parse(String sentence){
    stack.clear();
    memory.clear();
    makeStack(sentence);
  //  System.out.println("current state of stack" + stack);
  //  System.out.println("top of stack: " + stack.lastElement());
  System.out.println("inital stack: " + stack);
  System.out.println("initial memory: " + memory);
  while (!stack.empty()){
    //top LI in stack
    LexItem topLS = stack.lastElement();
    //top feature in topL;
    Feature topFS = topLS.topFeature();

    LexItem topLM = null;
    //top feature in top LM
    Feature topFM = null;
    if (!memory.empty()){
      //top LI in memory;
       topLM = memory.lastElement();
      //top feature in top LM
       topFM = topLM.topFeature();
    }

    if (stack.size() == 1){
      System.out.println("Only one element left in stack.");
      System.out.println(stack);
      System.out.println("Is it an S?");
      if (stack.lastElement().topFeature().getCat() == "S"){
        System.out.println("Yes! This is a sentence of simple English. We're done!");
        System.out.println("structure:");
        System.out.println(stack.lastElement().getPhon());
        return true;
      } else if(grammar.compatible(topLS, topLM) != null){
        System.out.println("No, but we can move element from memory to stack.");
        stack.push(memory.lastElement());
        memory.pop();
        System.out.println("Current memory" + memory);
        System.out.println("Current stack" + stack);

      } else {
        System.out.println("No, this is not a sentence of simple English!!!");
        return false;
      }
    } //end check if stack has one element
    LexItem arg2 = stack.lastElement();
    stack.pop();
    LexItem arg1 = stack.lastElement();
    stack.pop();
    System.out.println("apply("+arg1+","+arg2+")");
    LexItem output = grammar.apply(arg1, arg2);
    if (output == null){
      stack.push(arg1);
      stack.push(arg2);
      System.out.println("Parse failed. Can we move element from memory to stack?");
      if(!memory.empty() && grammar.compatible(stack.lastElement(), memory.lastElement()) != null) {
        System.out.println("yes, let's do it.");
        stack.push(topLM);
        memory.pop();
      } else{
        System.out.println("no, let's move element from stack to memory.");
        memory.push(stack.lastElement());
        stack.pop();
      }
    } else {
      stack.push(output);
    }
  System.out.println("current stack: " + stack);
  System.out.println("current memory: " + memory);
  } //end while

  return false;
} //end parse

} //end class
