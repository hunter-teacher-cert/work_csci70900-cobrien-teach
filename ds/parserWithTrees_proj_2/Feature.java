import java.io.*;
import java.util.*;
/*
  feature to be included in Lexical item's args list.
  contains:
  cat = {N, NP, VP, etc.}
  dir = {<,>, .}
  A feature with, e.g. category NP and direction > wants means that the phrase wants to combine with
  a phrase of category NP. A feature with NP and '.' is of category NP.

*/
public class Feature{
  private String cat = null;
  private String dir = null;

  public Feature(String cat, String dir){
    this.cat = cat;
    this.dir = dir;
  }
  public String getCat(){
    return cat;
  }
  public String getDir(){
    return dir;
  }
  public String toString(){
    return dir+cat+" ";
  }
}
