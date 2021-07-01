import java.util.Scanner;

/**
*Converts temperature in celsius to temerature in Fahrenheit.
*/

public class CtoF {
	public static void main(String[] args) {
		double cel, fahr;
		Scanner in = new Scanner(System.in);
		//Prompt temperture from user, get value
		System.out.print("What's the current temp. (in Celsius)? ");
		cel = in.nextDouble();
		// convert tempt to Fahrenheit, using formula F = C*(9/5) + 32
		
		fahr = cel*(9.0/5.0) + 32.0; 
		System.out.printf("%.1f C = %.1f F\n", cel, fahr); 
	}

}
