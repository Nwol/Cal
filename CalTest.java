import org.junit.Test;

import org.junit.*;
import org.junit.Test; // fixes some compile problems with annotations
import static org.junit.Assert.*;
import java.util.*;
import java.beans.Transient;
import java.io.*;

public class CalTest {

    @Test
    public void calTest1_ZeroDays() {
        int month1 = 2;
        int month2 = 2;
        int day1 = 10;
        int day2 = 10;
        int year = 1956;
        int number_of_days = Cal.cal(month1, day1, month2, day2, year);
        assertEquals(0,number_of_days);
    }

    @Test
    public void calTest2_3Months(){
        int month1 = 2;
        int month2 = 5;
        int day1 = 10;
        int day2 = 10;
        int year = 1956;
        int number_of_days = Cal.cal(month1, day1, month2, day2, year);
        assertEquals(90,number_of_days);
    }

    @Test
    public void calTest3_5Days(){
        int month1 = 2;
        int month2 = 2;
        int day1 = 10;
        int day2 = 15;
        int year = 1956;
        int number_of_days = Cal.cal(month1, day1, month2, day2, year);
        assertEquals(5,number_of_days);
    }


    @Test
    public void calTest4_FebruaryLeapYear_1(){
        int month1 = 2;
        int month2 = 3;
        int day1 = 15;
        int day2 = 15;
        int year = 1956;
        int number_of_days = Cal.cal(month1, day1, month2, day2, year);
        assertEquals(29,number_of_days);
    }

    @Test
    public void calTest5_FebruaryLeapYear_2(){
        int month1 = 1;
        int month2 = 2;
        int day1 = 16;
        int day2 = 15;
        int year = 1956;
        int number_of_days = Cal.cal(month1, day1, month2, day2, year);
        assertEquals(30,number_of_days);
    }

    // Fault - Not caught, we purposefully put day as zero to see if it catches the fault or not

    @Test
    public void caltest6_FebruaryLeapYear_3(){
        int month1 = 1;
        int month2 = 2;
        int day1 = 0;
        int day2 = 29;
        int year = 1957;
        int number_of_days  = Cal.cal(month1,day1,month2,day2,year);
        assertFalse("The answer calculated is wrong",59 == number_of_days);
    }
    
    //Fault - Not caught, we purposefully put day as zero to see if it catches the fault or not

    @Test
    public void calTest7_FebruaryNormalYear(){
        int month1 = 2;
        int month2 = 2;
        int day1 = 0;
        int day2 = 28;
        int year = 1957;
        int number_of_days = Cal.cal(month1, day1, month2, day2, year);
        assertEquals(28,number_of_days);
    }

    // Fault - Not Caught
    @Test
    public void calTest8_WrongMonths_1(){
        int month1 = 22;
        int month2 = 22;
        int day1 = 15;
        int day2 = 16;
        int year = 1956;
        int number_of_days = Cal.cal(month1, day1, month2, day2, year);
        assertTrue("Out of Bound Months don't get Caught",1==number_of_days);
    }


    // Fault - Not Caught
    @Test
    public void calTest9_WrongMonths_2(){
        int month1 = 12;
        int month2 = 11;
        int day1 = 15;
        int day2 = 11;
        int year = 1956;
        int number_of_days = Cal.cal(month1, day1, month2, day2, year);
        assertFalse("Month/Day 2 comes before Month/Day 1 don't get caught",0==number_of_days);
    }

    // Fault that does get caught
    @Test
    public void calTest10_AssertionErrorCaught(){
        int month1 = 0;
        int month2 = 0;
        int day1 = 1;
        int day2 = 5;
        int year = 10001;
        try {
            int number_of_days = Cal.cal(month1, day1, month2, day2, year);
        }
        catch( AssertionError e){
           assertTrue("Assertion Error is Caught",true);
        }

    }

     //possible fault of cal() that test find
   @Test
   public void calTest_364(){
      int month1 = 1;
      int month2 = 12;
      int day1 = 1;
      int day2 = 31;
      int year = 2018;
   
      int actual = Cal.cal(month1,day1,month2,day2,year);
   
      assertEquals(364, actual);
   
   }
    
   //possible fault of cal() that test finds, if it was 364 instead of 365 since 2016 is a leap year then the fault is caught in this test case.
   @Test
   public void calTest_365(){
    int month1 = 1;
    int month2 = 12;
    int day1 = 1;
    int day2 = 31;
    int year = 2016;

    int actual = Cal.cal(month1,day1,month2,day2,year);

    assertEquals(365, actual);
   }
    

    public static void main(String[] args){
        org.junit.runner.JUnitCore.main("CalTest");
    }

}
