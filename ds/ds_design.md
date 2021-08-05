# Data Structure design challenge
//michel

## Group 1
Brian M., Michele P, Peter T, Stephannia K, Chris O

## Methods
1. add - you should be able to add new people in to the PhoneBook by lastName.
This operation should be optimized to be as fast as possible.
2. find - you should be able to find a person by lastName.
For example, pb.find("Smith") would return the person in the phone book with last name "Smith".
Assume that last names are unique. Find should return null if the person is not in the phone book.
This operation should be optimized to be as fast as possible.
3. remove - remove a person from the list based on lastName.
This operation does not have to be optimized.
4. printList - this would print out an entire phone book.
This operation does not have to be optimized.
Add a file or files into your repo describing this data structure and the algorithms for the operations.
## Brainstorm
1. add Methods: we would use the linked list add method we created in Llists using the Person class. LinkedList<Person>
2. find method: use a for loop to search through the linked list, once we find the designated lastname, we will break out of the loop. We would nested if else statement inside the for loop.
3. Remove - linked list remove Methods
4. printList - tostring to print the list
5. add a sort method, which would allow us to use a binary search method to help reduce runtime.
6. we can transfer the linked list to an array and sort it and then put it back into the linked list
Time will vary depending on the length of the phoneBook.

## Additional questions:
Answer these in the same or an additional file.
What is the runtime for add, constant (if added at front)
What is the runtime for find =  O(n);.  If list is sorted we could use binary search O(log n);
What is the runtime for remove = order N
What is the runtime for printList

## instructions
Private Linked list variable of persons (call it phoneBook?);
## (Pseudo)Code

```Java
//You are going to create a data structure to represent a phone book.
//The phone book will store names and phone numbers of individuals.
//Each individual will be stored using the following class specification:

public class Person {
  private String lastName;
  private String firstName;
  private String phoneNumber;

  // other members not shown
}
//Design a data structure to store a phone book.
//The entry class should be named PhoneBook, that is,
//if you were writing a complete, coded solution your program would contain:
public class PhoneBook{
	// implementation not shown
      private Person front; // point to the front of the list
      private Person back;  // point to the back of the list
      private LinkedList<Person> phoneBook;
      private int size; //how many items there are in the list
                        //TODO update size every time we add or delete
      public  Llist(){
  	    front = null;
        size = 0;
      }



}

String s = "ABC";
int i = s.charAt(a); // i will now hold 65


'''
