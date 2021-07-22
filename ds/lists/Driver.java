/*
Data Structures
7/15-16/21
Linked List methods assignment
by
Chris O'Brien
Marina Moshchenko
Liam Baum

*/


import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
/*
  Node n;
	n = new Node();
	n.setData("Eduardo");


	Node n2 = new Node("Brian");
	n.setNext(n2);

	System.out.println(n);

	System.out.println(n2);

	System.out.println(n.getNext());
	n.getNext().setNext(new Node("Steph"));
	System.out.println(n2.getNext());
	System.out.println(n.getNext().getNext());
*/
  String[] data = {"e", "d", "c", "b", "a"};
  Llist myList = new Llist();
  boolean test = myList.isEmpty();
  System.out.println("How many items? " + myList.length());
  System.out.println("Is myList empty? " + test);
  for (String datum: data){
    myList.addFront(datum);
    System.out.println(myList);
  }

  test = myList.isEmpty();
  System.out.println("Is myList Empty? " + test);
  System.out.println("How many items? " + myList.length());
  String item = myList.get(0);
  System.out.println("0th item is " + item);
  item = myList.get(4);
  System.out.println("4th item is " + item);
  System.out.println("10th item is " + myList.get(10));

  //test set() method, expect 'a->b->x->d->e->null'
  int index = 2;
  String value = "x";
  //myList.set(index, value);
  //test insert(), expect a->b->x ->c->d->e->null'
 myList.insert(index,value);



  System.out.println("list w/ x at 2: " + myList);
  System.out.println("Length(): " + myList.length());
  System.out.println("getSize(): " + myList.getSize());
  myList.remove(2);
  System.out.println("List after removing x:" + myList);
  myList.remove(10);
  System.out.println("Length(): " + myList.length());
  System.out.println("getSize(): " + myList.getSize());

  //test search
//  int keySearch = myList.search("e");

//System.out.println("keySearch =  " +keySearch);
/*

	Node L;
	// 1.Create a new  list that looks like:
	//   L->"a"->"b"->"c"->"d"
  L = new Node("a");

  Node L2 = new Node("b");
  L.setNext(L2);
  Node L3 = new Node("c");
  L2.setNext(L3);
  Node L4 = new Node("d");
  L3.setNext(L4);



  // 2. Write the code to insert an "x"
	//    between the b and the c
//  Node LX = new Node("x");
  L2.setNext(new Node("x"));
  L2.getNext().setNext(L);
  String output = L.printList();
  System.out.println(output);
	// 3. Write the code to delete the c

*/
  }// main
}//end class
