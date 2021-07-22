import java.io.*;
import java.util.*;
/**
Creates a class of lexical items (LIs). Each LI contains pieces of information:
phonology = the strings making up the word
args = an ordered list of features, indicating argument structure
*/
public class LexItem{
  private String phonology = null;
  private Stack<Feature> args = null;

  //construct an LI given a string. Args are added using addArgs().
  public LexItem(String word){
    phonology = word;
    args = new Stack<Feature>();

  }
  public void setPhon(String string){
    phonology = string;
  }
  public String getPhon(){
    return phonology;
  }

  public Stack<Feature> getArgs(){
    return args;
  }

  public void addArgs(Feature feature){
    args.addElement(feature);
  }


  public void  copyArgs(LexItem item){
    for (Feature arg : item.getArgs()  ) {
      this.addArgs(arg);
    }
  }

  public void deleteArg(){
    args.pop();
  }
  public Feature topFeature(){
    return this.getArgs().lastElement();
  }
  public String toString(){
    return phonology +": " + args;

  }

}//end class
