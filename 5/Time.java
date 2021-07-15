import java.io.*;
import java.util.*;

public class Time {

  // your implementation of class Time here
  //declare instance variables
    private int hour;
    private int minute;
    private double second;
    //default constructor
    public Time(){
      this.hour = 0;
      this.minute = 0;
      this.second = 0.0;
    }

    //value constructor
    public Time(int hour, int minute, double second){
      this.hour = hour;
      this.minute = minute;
      this.second = second;
    }

    //getters
    public int getHour(){
      return this.hour;
    }

    public int getMinute(){
      return this.minute;
    }
    public double getSecond(){
      return this.second;
    }

    //setters

    public void setHour(int hour) {
      this.hour = hour;
    }

    public void setMinute(int minute){
      this.minute = minute;
    }

    public void setSecond(double second){
      this.second = second;
    }
    public static void printTime(Time t){
      System.out.printf("%02d:%02d:%04.1f\n",
        t.hour, t.minute, t.second);
    }
    public String toString(){
      return String.format("%02d:%02d:%04.1f\n",
        this.hour, this.minute, this.second);
    }
    public boolean equals(Time that){
      return this.hour == that.hour && this.minute == that.minute
      && this.second == that.second;
    }
    public static Time add(Time t1, Time t2){
      Time sum = new Time();
      sum.hour = t1.hour + t2.hour;
      sum.minute = t1.minute + t2.minute;
      sum.second = t1.second + t2.second;
      return sum;
    }

    public Time add(Time t){
      Time sum = new Time();
      sum.hour = this.hour + t.hour;
      sum.minute = this.minute + t.minute;
      //deal with situations where there are more than 60 minutes;

      if (sum.minute > 60){
        sum.hour += sum.minute/60;
        sum.minute  = sum.minute%60;
      }
      sum.second = this.second + t.second;
      //deal with >60 seconds
      if (sum.second >60){
        sum. minute += sum.second/60;
        sum.second = sum.second%60;
      }
      return sum;
    }


}//end class
