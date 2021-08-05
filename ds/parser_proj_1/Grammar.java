import java.io.*;
import java.util.*;
/* In a Combinatory categorial grammar, a grammar is just a lexicon and a set of  rules.
For convenice I here only implement one rule, called merge(). The other possible
rules are unnecessary for the restricted fragment of English this parser can analyze.

In this model, the lexicon consists of a set of leaf nodes. Each node is associated
with a string (its 'phonology'), as well as a stack of features, indicating its categor and arguments.

For instance the article (in linguistics called a determiner) 'the' will take
one argument to its right (a noun), and yield an object of category NP (noun phrase).

This is accomplished below by adding two features as arguments to the stack. First dotNP,
which means the object will be of category NP, and second rightN, which indicates
the lexical item is looking for a noun to its right (in many ways this grammar
is a lexicalized equivalent to a grammar consisting of context free rewrite
rules, in this case NP -> det N).

In this case, rightN is at the top of the stack, indicating that the lexical item must combine with a
noun. Then dotNP is at the top of the stack Other features are similarly
named.

In this grammar, we have a single rule labelled merge. This rule applies to nodes or trees.
For nodes, if two nodes are compatible, it outputs a tree where the root has the two
original nodes as daughters.

 Here's how it would work for the
following lexical items:

the : .NP >N

boy : .N

Merge(the : .NP >N, boy: .N) = the boy : .NP

In this case, these two phrases are compatible (the left argument is looking for a N to the right, the
right argument is a N). It yields a NP. Here the root node of the new
tree has the phonology 'the boy'. It removes the >N argument from the selecting phrase ('the')
and adds it to its arg stack, which will simply contain .NP.


For convenience, I implemented the  merge() rule in the parser.java file.


*/
public class Grammar{
  LinkedList<LexItem> lexicon  = null;

  public Grammar(){
    lexicon = new LinkedList<LexItem>();
    instantiateGrammar();
  }

  public void addLex(LexItem lex){
    lexicon.add(lex);
  }

  public void instantiateGrammar(){
    //instantiate that: .S >S
    LexItem that = new LexItem("that");
    Feature dotS = new Feature("S",".");
    Feature Sright = new Feature("S", ">");
    that.addArgs(dotS);
    that.addArgs(Sright);
    this.addLex(that);

    //instantiate determiner the: NP. N>
    LexItem the  = new LexItem("the");
    Feature dotNP = new Feature("NP", ".");
    Feature rightN = new Feature("N", ">");
    the.addArgs(dotNP);
    the.addArgs(rightN);
    this.addLex(the);

    //instantiate simple common nouns
    String[] nouns = {"student", "sandwich", "book", "class", "kingdom", "thief", "detective"};
    Feature Ndot = new Feature("N", ".");
    for (String noun : nouns){
      LexItem newWord = new LexItem(noun);
      newWord.addArgs(Ndot);
      this.addLex(newWord);

    } //end common noun looping

    //instantiate relational noun queen: .N >PP
    String[] fancyNouns = {"queen", "king", "viscount","mother", "father", "brother", "veracity", "origin"};
    Feature PPright = new Feature("PP", ">");
    for (String fancyNoun : fancyNouns){
      LexItem newWord = new LexItem(fancyNoun);
      newWord.addArgs(Ndot);
      newWord.addArgs(PPright);
      this.addLex(newWord);

    } //end fancy noun looping


    //instantiate nouns with sentential complements
    String[] fanciestNouns = {"proof", "claim"};
    for (String noun : fanciestNouns){
      LexItem newWord = new LexItem(noun);
      newWord.addArgs(Ndot);
      newWord.addArgs(Sright);
      this.addLex(newWord);

    } //end fancy noun looping


    //instantiate adjectives
    String[] adjectives = {"red", "blue", "bored", "difficult", "wiley"};
    Feature Nright = new Feature("N", ">");
    for (String adjective : adjectives){
      LexItem newWord = new LexItem(adjective);
      newWord.addArgs(Ndot);
      newWord.addArgs(Nright);
      this.addLex(newWord);
    }//end adj loop
    //instantiate transitive verbs
    String[] verbs =  {"ate", "cooked", "read", "skipped", "surprised"};
    Feature Vdot = new Feature("S",".");
    Feature NPleft = new Feature("NP","<");
    Feature NPright = new Feature("NP",">");
    for (String verb : verbs){
      LexItem newWord = new LexItem(verb);
      newWord.addArgs(Vdot);
      newWord.addArgs(NPleft);
      newWord.addArgs(NPright);
      this.addLex(newWord);

    } //end verb loop

    //instatiate instransitive verbs
    String[] iVerbs = {"escaped", "disappeared", "lied"};
    for (String verb : iVerbs){
      LexItem newWord = new LexItem(verb);
      newWord.addArgs(Vdot);
      newWord.addArgs(NPleft);
      this.addLex(newWord);
    }//end iverb loop
    //preposition of: .PP >NP
    LexItem of = new LexItem("of");
    Feature dotPP = new Feature("PP", ".");
    of.addArgs(dotPP);
    of.addArgs(NPright);
    this.addLex(of);

  }//end instantiate grammar

  //tests if two lexical items are 'compatible', i.e. they can be combined together in a larger phrase
  //if compatible returns direction application occurs (i.e. wither left argument applies to right or vice versa), null otherwise.
  public String compatible(LexItem arg1, LexItem arg2){
    if (arg1 == null || arg2 == null){
      return null;
    }
    //retrieve top features from each LI.
    Feature feature1 = arg1.topFeature();
    Feature feature2 = arg2.topFeature();
    //System.out.println("top feature of arg 1: " + feature1);
    //System.out.println("top feature of arg 2: " + feature2);
    //make sure features have identical categories
    if (feature1.getCat() != feature2.getCat()){
      return null;
    }
    //make sure one feature points to the other, and the other is a head (indicated by a '.').
    if (feature1.getDir() == ">" && feature2.getDir() =="."){
      return ">";
    } else if (feature1.getDir() == "." && feature2.getDir() =="<"){
      return "<";
    } else {
      return null;
    }

  }
  //combines two items into new phrase
  public LexItem apply(LexItem arg1, LexItem arg2){
    String dir = compatible(arg1, arg2);
    if (dir == ">"){
      LexItem argNew = new LexItem("["+arg1.getPhon()+" " + arg2.getPhon()+"]");
      argNew.copyArgs(arg1);
      argNew.deleteArg();
      System.out.println("-->" + argNew);
      return argNew;

    } else if (dir == "<"){
      LexItem arg3 = new LexItem("["+arg1.getPhon() +" "+ arg2.getPhon() +"]");
      arg3.copyArgs(arg2);
      arg3.deleteArg();
      System.out.println("-->" + arg3);
      return arg3;
    }
    System.out.println("-->" + null);
    return null;
  }
  public LinkedList<LexItem> getLexicon(){
    return lexicon;
  }

  public LexItem  getWord(int i){
    LexItem word = lexicon.get(i);
  //  String phon = word.getPhon();
    return word;
  }

  public String toString(){
    String string = "";
    for (LexItem lex : lexicon){
      string += lex + "\n";
    }
    return string;
  }
}
