/**
 Program: DayOfWeek.java
 Author: Miguel Mejias Amparo
 Date: 05/06/2024
 Description: Program that computes the day of the week for any date entered by the user.
 History:
         05/06/2024 File created. MLMA
         05/06/2024: adding return String.format in each case inside Zellercongruence() 
         ----------------------------------------------------------------------------------
         ----------------------------------------------------------------------------------
         ----------------------------------------------------------------------------------
         Program: GUI.java
 Author: Miguel Mejias Amparo
 Date: 05/06/2024
 Description: Day of Week GUI is a program that shows you what day of the week was based on the date selected in the program.
 History:
         05/06/2024: File created. MLMA
         05/06/2024: implementing exception handling 
         05/06/2024: implementing JcomboBox and making it work
         05/06/2024: implementing maximum days in a month. Example: February has 28 days
 */

package edu.pupr.gui;

import java.util.Scanner;

public class DayOfWeek{
    private int month;
    private int day;
    private int year;

    public DayOfWeek(){
        this(0,0,0);
    }

    /**
     *DayOfWeek()- parameter constructor
     * @param month coefficient
     * @param day coefficient
     * @param year coefficient
     */
    
    public DayOfWeek(int month,int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
    public void ask(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter month(1-12):");
        month = (input.nextInt());
        System.out.print("Enter day(1-31):");
        day = (input.nextInt());
        System.out.print("Enter year:");
        year =(input.nextInt());
    }

    public String Zellercongruence(){
        {
            if (month == 1)
            {
                month = 13;
                year--;
            }
            if (month == 2)
            {
                month = 14;
                year--;
            }
            int q = day;
            int m = month;
            int k = year % 100;
            int j = year / 100;
            int h = q + 13*(m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
            h = h % 7;
            switch (h)
            {
                case 0 : return String.format("The day of the week is Saturday"); 
                case 1 : return String.format("The day of the week is Sunday");
                case 2 : return String.format("The day of the week is Monday"); 
                case 3 : return String.format("The day of the week is Tuesday"); 
                case 4 : return String.format("The day of the week is Wednesday");
                case 5 : return String.format("The day of the week is Thursday"); 
                case 6 : return String.format("The day of the week is Friday");
            }
        }
		return null;
    }
    
}

