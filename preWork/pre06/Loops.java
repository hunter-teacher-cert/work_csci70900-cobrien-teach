import java.io.*;
import java.util.*;
public class Loops {
	//calculates value of x^n, where x is a float and n is an int.
	public static double power(double x, int n) {
		double answer = x;
		if (n == 0) {
			return 1;
		}
		while (n > 1) {

			answer = answer*x;
			n = n -1;
		}
		return answer;
	}
	//Calculates n!, where n is an integer.
	public static double factorial(int n) {
		double answer = n;
		if (n<= 1) {
			return 1;
		}
		while (n>1) {
			n = n - 1;
			answer = answer * n;
			//System.out.println("at n = " + n + ", answer = " + answer);
		}

		return answer;
	}
	//Recursive method for calculating n!.
	public static double fact_rec(int n) {
		//recursive version of factorial function
		if (n <= 1) {
			return 1;
		} else {
			return n*fact_rec(n-1);
		}
	}
	/*Approximates e^x using the expansion
	e^x = 1 +x + (x^2/2!) +(x^3/3!)...
	, calcualted out n terms.
	public static double myexp(double x, int n) {
		int i;
		double fact;
		double answer = 0;

		for (i = 0; i < n; i = i + 1) {
			double mypow = Math.pow(x,i);
			double myfact = fact_rec(i);
			//System.out.println(x+"^"+i +" = " +mypow);
			//System.out.println(i+"! = " + myfact);
			fact = Math.pow(x,i)/factorial(i);
			//System.out.println("The " + i + "th term is " + fact);
			answer = answer + fact;


		}
		return answer;
	}
	more efficient version of previous method.
	Num. of each successive term is the same as
	predecessor*x, denom. is same as pred.*i */
	public static double myexp(double x){
		int n = 100;
		double num = 1;
		double denom = 1;
		double term = 1;

		for (int i = 1; i<n; i+=1){
			num = num*x;
			denom = denom*i;

			term = term + num/denom;
			}
		return term;
		}


	//checks to see if myexp is working correctly
	public static void check(double x){
		double my_ans = myexp(x);
		double ans = Math.exp(x);
		System.out.println(x +"  " + my_ans + "  " + ans);
	}

	//Implements the 3rd exercise from 'Think Java' ch. 7
	public static void exthree(){
		double x, answer;
		int n;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a positive real number: ");
		x = in.nextDouble();
		System.out.print("Enter a positive integer: ");
		n = in.nextInt();
		answer = power(x,n);
		System.out.print(x +"^"+ n + " = " + answer);
	}

	//Implements the 4th exercise from 'Think Java' ch. 7
	public static void exfour() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int n = in.nextInt();
		double answer = fact_rec(n);
		System.out.print(n + "! = " + answer);

	}
	//Implements the exercise 5.1 from 'Think Java' ch. 7
	public static void exfive() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an positive number x: ");
		double x = in.nextDouble();
		//System.out.print("Enter a positive number n: ");
	//	int n = in.nextInt();
		double answer = myexp(x);
		System.out.println("e^"+x +" is approx. " + answer);
		check(x);
	}
	public static void main(String[] args) {
		for (double i = 0.1; i<101; i = i*10){
			check(i);
		}

		for (double i = -0.1; i> -101; i = i*10){
			check(i);
		}
		/*Comment: Both Math.exp() and myexp() approximate e^x
		out to the 10^-16 place.For 0.1 and -0.1, only the last digit
		is different. For 1.0 the last two are, and so on for +/-10. For +/-
		100, the numbers appear to be radically different.
		*/






	}
}
