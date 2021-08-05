import java.io.*;
import java.util.*;

public class Parser{
  private Grammar grammar = null;
  private Stack<Tree> stack = null;
  private Stack<Tree> memory = null;

  public Parser(Grammar grammar){
    this.grammar = grammar;
    stack = new Stack<Tree>();
    memory = new Stack<Tree>();

  } //end constructor

  public  Tree makeTerm(Node node){
    String argsString = node.stringArgs();
    Node root = new Node(argsString);
    root.copyArgs(node);
    Tree termTree = new Tree(root);
  //  System.out.println("root = " + root);
  //  System.out.println("term = " + node);
    root.setRight(node);
    //termTree.toString();
    return termTree;

  }
  public void setStack(String string){
    String[] sentence = string.split(" ");

    //  System.out.println("words of sentence: " + Arrays.toString(sentence));
      Node Node = null;
      String phon = null;
      for (String word : sentence){
      //  System.out.println("word: " + "<" + word+ ">");
        for ( int i=0; i< grammar.getLexicon().size();i++){
          Node = grammar.getWord(i);
          phon = Node.getPhon();
        //  System.out.println("lexical item: " + "<" + phon+ ">") ;
        //  Boolean isSame = phon.equals(word);
        //  System.out.println("Is " +  "<" + word+ ">" +" the same as " + "<" + phon+ ">? " + isSame);
          if (phon.equals(word)){
            Tree newTree = makeTerm(Node);
            stack.push(newTree);
            break;
          }//end if
          if (i == grammar.getLexicon().size() - 1){
            //change to raise exception later.********
            System.out.println(word + " is not a valid word in simpleEnglish");

          }
        }//inner for

      ///  break;
      }//end for
    }// end setStack

    public Tree merge(Tree left, Tree right){
      Node leftRoot = left.getRoot();
      Node rightRoot = right.getRoot();
      String direction = grammar.compatible(leftRoot, rightRoot);
      if (direction == null){
        return null;
      }
      Node root = null;
      if (direction == ">"){
        leftRoot.deleteArg();
         root = new Node(leftRoot.stringArgs());
        root.copyArgs(leftRoot);
        root.setLeft(leftRoot);
        root.setRight(rightRoot);
        Tree newTree = new Tree(root);
        newTree.toString();
        return newTree;

      } else{
        rightRoot.deleteArg();
         root = new Node(rightRoot.stringArgs());
        root.copyArgs(rightRoot);
        root.setLeft(leftRoot);
        root.setRight(rightRoot);
        Tree newTree = new Tree(root);
        newTree.toString();
        return newTree;
      }


    }



      public Boolean parse(String sentence){
        stack.clear();
        memory.clear();
        setStack(sentence);
      //  System.out.println("current state of stack" + stack);
      //  System.out.println("top of stack: " + stack.lastElement());
      System.out.println("inital stack: " + stack);
      System.out.println("initial memory: " + memory);
      while (!stack.empty()){

        if (stack.size() == 1){
          System.out.println("Only one element left in stack.");
          System.out.println(stack);
          System.out.println("Is it an S?");
          if (stack.lastElement().getRoot().topFeature().getCat() == "S"){
            System.out.println("Yes! This is a sentence of simple English. We're done!");
            System.out.println("structure:");
            stack.lastElement().toString();
            //System.out.println(stack.lastElement().getRoot().getPhon());
            return true;
          } else if(grammar.compatible(stack.lastElement().getRoot(), memory.lastElement().getRoot()) != null){
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
        Tree arg2 = stack.lastElement();
        stack.pop();
        Tree arg1 = stack.lastElement();
        stack.pop();
        System.out.println("merge("+arg1+","+arg2+")");
        Tree output = merge(arg1, arg2);
        if (output == null){
          stack.push(arg1);
          stack.push(arg2);
          System.out.println("Parse failed. Can we move element from memory to stack?");
          if(!memory.empty() && grammar.compatible(stack.lastElement().getRoot(), memory.lastElement().getRoot()) != null) {
            System.out.println("yes, let's do it.");
            stack.push(memory.lastElement());
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







}//end parser class
