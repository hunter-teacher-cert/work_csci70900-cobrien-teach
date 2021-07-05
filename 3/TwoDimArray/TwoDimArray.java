  /** skeleton file for
 class twoDimArray
  ...practice working with 2D arrays

*/

public class TwoDimArray
{

  //print each row of 2D integer array a on its own line,
  // using a FOR loop
  public static void print1( int[][] a ) {
    for (int h = 0; h < a.length; h++){
      for (int i = 0; i < a[h].length; i++ ){
        System.out.print(a[h][i] + " ");
      }
      System.out.print("\n");
    }
    System.out.print("\n");
  }


  //print each row of 2D integer array a on its own line,
  // using a FOREACH loop
  public static void print2( int[][] a ) {
    for (int[] arr: a){
      for (int n : arr){
      System.out.print(n + " ");

      }
      System.out.print("\n");
    }
    System.out.print("\n");

  }


  //return sum of all items in 2D integer array a
  public static int sum1( int[][] a ) {
    int sum = 0;
    for (int[] row: a){
      for (int cell: row) {
        sum += cell;
      }
    }
    return sum;
  }
  //return sum of all items in 2D integer array a
  // using helper fxn sumRow

  public static int sum2( int [][] m ) {
    int sum = 0;
    for (int row = 0; row <m.length; row ++){
      sum +=  sumRow2(row, m);
    }
    return sum;
  }





  //return sum of all items on row r of 2D integer array a
  // using a FOR loop
  public static int sumRow( int r, int[][] a ) {
    int[] row = a[r];
    int sum = 0;
    for (int cell =0; cell < row.length; cell++){
      sum += row[cell];
    }
    return sum;
  }


  //return sum of all items on row r of 2D integer array a
  // using a FOREACH loop
  public static int sumRow2( int r, int[][] m ) {
    int[] row = m[r];
    int sum = 0;
    for (int cell : row){
      sum += cell;
    }
    return sum;
  }


  public static void main( String [] args ){



       int [][] m1 = new int[4][2];
       int [][] m2 = { {2,4,6}, {3,5,7} };
       int [][] m3 = { {2}, {4,6}, {1,3,5} };
       print1(m1);
       print1(m2);
       print1(m3);

       print2(m1);
       print2(m2);
       print2(m3);

       System.out.print("testing sum1...\n");
       System.out.println("sum m1 : " + sum1(m1));
       System.out.println("sum m2 : " + sum1(m2));
       System.out.println("sum m3 : " + sum1(m3));

       System.out.print("testing sum2...\n");
       System.out.println("sum m1 : " + sum2(m1));
       System.out.println("sum m2 : " + sum2(m2));
       System.out.println("sum m3 : " + sum2(m3));
       /*~~~v~~~~~slide~me~down~as~you~test~~~~~~~~~~~~~~~v~~~
       ~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~

       */
  }//end main()

}//end class TwoDimArray
