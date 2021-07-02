import java.io.*;
import java.util.*;
public class Date {
	public static void main(String[] args){
		String day, month;
		int date, year;
		day = "Wednesday";
		month = "February";
		date = 17;
		year = 2021;
		System.out.println("American Format:");
		System.out.print(day);
		System.out.print(", ");
		System.out.print(month);
		System.out.print(" ");
		System.out.print(date);
		System.out.print(",  ");
		System.out.print(year);
		System.out.println(".");
		System.out.println("European Format:");
		System.out.println(day + " " + date + " " +  month + " " + year);
	}
}

