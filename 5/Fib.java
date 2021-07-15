// heading

public class Fib {

  //your implementation of fib(n) here
  public static int fib(int n){
    if (n == 0 || n == 1){
      return n;
    } else {
      return fib(n-1) + fib(n-2);
    }
  }
  public static int fibA(int n, int[] a){
    //finds fibonacci of n with array a for memoization
    if (a[n] != -1){
      return a[n];
    } else if (n ==0 || n == 1){
        a[n] = n;
    } else {
        a[n] = fibA(n-1, a) + fibA(n-2, a);

    }
    return a[n];
  }



  public static void main( String[] args ) {
    int[] fiba = new int[1000];
    for (int i = 0; i <fiba.length; i++){
      fiba[i] = -1;
    }
    for (int n = 0; n < 20; n++){
      System.out.println("fib("+n+") = " + fibA(n, fiba));
    }

    System.out.println( fib(0) ); // -> 0
    System.out.println( fib(1) ); // -> 1
    System.out.println( fib(2) ); // -> 1
    System.out.println( fib(3) ); // -> 2
    System.out.println( fib(4) ); // -> 3
    System.out.println( fib(5) ); // -> 5
    //now go big:
    System.out.println( fib(10) ); // -> 55
    System.out.println( fib(20) ); // -> 6765
    System.out.println( fib(40) ); // -> 102334155

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main()

}//end class Fib
