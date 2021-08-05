import java.io.*;
 import java.util.*;

public class Tree{
  private Node root;

  public Tree(Node node){
    root = node;
  }

  public Node getRoot(){
    return root;
  }
  public String toString(){
    return root.toString();
  }
  /*
  public void showTree(){
     TreeOperation.show(root);
  }

  public String toString(){
    return root.getPhon();
  }
  */
}
