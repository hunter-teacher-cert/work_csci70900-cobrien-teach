import java.io.*;
import java.util.*;
public class Time {
	public static void main(String[] args){
		int hour, minute, second;
		hour = 8;
		minute = 24;
		second = 39;
		minute = minute + (60*hour);
		second = second + (60*minute);
		System.out.print("Number of seconds since midnight (start of exercise): ");
		System.out.println(second);
		int seconds_in_day = 24*60*60;
		int remaining = seconds_in_day - second;
		System.out.print("Remaining seconds in the day (start of exercise): ");
		System.out.println(remaining);
		int new_hour, new_minute, new_second, new_time, elapsed_time;
		new_hour = 8;
		new_minute = 32;
		new_second = 51;
		new_time = (8*60*60) + (32*60) + 51;
		elapsed_time = new_time - second;
		System.out.print("Time elapsed since start of exercise (in sec): ");
		System.out.println(elapsed_time);
	}
}

