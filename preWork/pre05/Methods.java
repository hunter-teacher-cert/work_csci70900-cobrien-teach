import java.io.*;
import java.util.*;
public class Methods {
	public static boolean isDivisible(int m, int n) {
		int value = n % m;
		return value == 0;
	}
	public static boolean isTriangle(int a, int b, int c) {
		boolean answer;
		if (a <= c && b <= c ) {
			answer = a + b > c;
		} else if ( a <= b && c <= b) {
			answer = a + c > b;
		} else if (b <= a && c <= a) {
			answer = b + c > a;
		} else {
			answer = true;
		}
		return answer;
	}
	public static int ack(int m, int n) {
		// m,n must be >= 0.
		if (m == 0) {
			return n + 1;
		} else if (n==0) { 
			return ack(m-1, 1);	
		} else {
			return ack(m-1, ack(m,n-1));
		}
	}
	public static void extwo() {
		int num_a, num_b;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the divisor: ");
		num_a = in.nextInt();
		System.out.print("Enter the dividend: ");
		num_b = in.nextInt();
		boolean my_value = isDivisible(num_a, num_b);
		System.out.println("Is the dividend "+ num_b + " divisible by the divisor " + 			num_a + "?: " + my_value);
		
		
	}
	public static void exthree(){
		int a,b,c;
		boolean answer;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number a: ");
		a = in.nextInt();
		System.out.print("Enter a number b: ");
		b = in.nextInt();
		System.out.print("Enter a number c: ");
		c = in.nextInt();
		answer = isTriangle(a,b,c);
		System.out.println("Can lengths " + a + ", " + b + ", " + c + " be lengths of a triangle? " + answer);
	}
	public static void exeight(){
		int m,n, answer;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a non-negative integer value for m: ");
		m = in.nextInt();
		System.out.print("Enter a non-negative integer value for n: ");
		n = in.nextInt();
		answer = ack(m,n);
		System.out.println("Final return value: " + answer);
	}
	public static void main(String[] args) {
		exeight();
		
	}
}
