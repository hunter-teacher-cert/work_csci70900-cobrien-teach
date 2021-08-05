import java.io.*;
import java.util.*;

/*A node indicates a syntactic phrase (e.g. noun phrase, verb, etc.).
A node contains four important values:

  phonology: the string associated with the phrase.
  Args: A stack fo features indicating the argument structure of the Node.
  For instance a verb might have
    phonology = 'eat'
  and a stack of args indicating
  that it combines with two NPs (one to the right and one to the left) and
  yields a VP.
  args: >NP, <NP, VP.




*/
public class Node{
    private String phonology;
    private Stack<Feature>  args;
    private Node left,right;



    public Node(String word){
    	phonology = word;
      args = new Stack<Feature>();
    	left = null;
    	right = null;
    }

    public void setPhon(String word){
	       this.phonology = word;
    }

    public void addArg(Feature feature){
      args.push(feature);

    }
    public void deleteArg(){
      args.pop();
    }


    public void setLeft(Node left){
	       this.left = left;
    }

    public void setRight(Node right){
	       this.right = right;
    }

    public String getPhon(){
	       return phonology;
    }

    public Stack<Feature> getArgs(){
      return args;
    }

    public Node getLeft(){
	      return left;
    }

    public Node getRight(){
	     return right;
    }
    public String stringArgs(){
    return args.toString();
    }
    //makes deep copies of argument stack
    public void  copyArgs(Node item){
      for (Feature arg : item.getArgs()  ) {
        this.addArg(arg);
      }
    }
    /*
    public void printPhon(){
      System.out.print(phonology);
    }
    final String name;
    final List<TreeNode> children;

    public TreeNode(String name, List<TreeNode> children) {
        this.name = name;
        this.children = children;
    }



    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(phonology);
        buffer.append('\n');
        for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
    */
    public Feature topFeature(){
      return this.getArgs().lastElement();
    }
}
