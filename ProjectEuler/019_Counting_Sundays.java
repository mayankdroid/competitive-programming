/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/

import java.io.*;
import java.util.*;

class Counting_Sundays {
	public static void main(String[] args) {
    	int numOfSundays = 0;	// array to hold number of Sundays

    	int year = 1900;	// current year
    	int month = 1;	// current month
    	int date = 1;	// current date

    	int day = 1;	// day of the week

    	int daysInMonth = 31;	// days in the month

    	while(!((year == 2000) && (month == 12) && (date == 31))) {	// loop till end
    		if(day == 6) {	// if Saturday
    			day = 0;	// go to Sunday
    		} else {	// otherwise
    			day++;	// increase day by one
    		}

    		if(date == daysInMonth) {	// finding the new daysInMonth
    			date = 1;

    			if(month == 12) {
    				month = 1;
    				year++;
    			} else {
    				month++;
    			}

    			if(month == 4 || month == 6 || month == 9 || month == 11) {	// 30 days
    				daysInMonth = 30;
    			} else if (month == 2) {	// logic for feb
    				if(year % 4 == 0) {
    					if(year % 100 == 0) {
    						if(year % 400 == 0) {
    							daysInMonth = 29;
    						} else {
    							daysInMonth = 28;
    						}
    					} else {
    						daysInMonth = 29;
    					}
    				} else {
    					daysInMonth = 28;
    				}
    			} else {	// 31 days
    				daysInMonth = 31;
    			}

    		} else {
    			date++;
    		}

    		if(date == 1 && day == 0 && year >= 1901) {	// add to count if the 1st and a Sunday and >=1901
    			numOfSundays++;
    		}
    	}

    	System.out.println("Between Jan 1 1901 and Dec 31 2000, there were " + numOfSundays + " Sundays on the 1st of the month.");
	}
}