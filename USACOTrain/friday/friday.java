/*
ID: Wilson Ding
LANG: JAVA
PROG: friday
*/

import java.io.*;
import java.util.*;

class friday {
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

    	int numOfYears = Integer.parseInt(f.readLine());	// read in the number of years

    	int[] numOfThirteen = new int[7];	// array of counts Sun -> Sat

    	int year = 1900;	// current year
    	int month = 1;	// current month
    	int date = 1;	// current date

    	int day = 1;	// day of the week

    	int daysInMonth = 31;	// days in the month

    	int finalYear = 1900+numOfYears-1;	// stopping year
    	int finalMonth = 12;	// stopping month
    	int finalDate = 31;	// stopping date

    	while(!((finalYear==year) && (finalMonth==month) && (finalDate == date))) {	// loop till end
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

    		if(date == 13) {	// add to count if the thirteenth
    			numOfThirteen[day]++;
    		}
    	}
    	// output
    	out.println(numOfThirteen[6] + " " + numOfThirteen[0] + " " + numOfThirteen[1] + " " + numOfThirteen[2] + " " + numOfThirteen[3] + " " + numOfThirteen[4] + " " + numOfThirteen[5]);
		out.close();
	}
}