/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
*/

import java.io.*;
import java.util.*;

class Digit_Factorials {
	public static void main(String[] args) {
		long sum = 0;	// total sum

		for(long num = 3; num < 1000000; num++) {	// iterate from 3...arbitrarily large number
			long currentSum = 0;	// store sum of factorials

			String value = Long.toString(num);	// convert num to string for easier iteration

			for(int index = 0; index < value.length(); index++) {	// iterate through all numbers
				long currentFactorial = 1;	// var to store factorial of current number

				int currentNumber = Integer.parseInt(Character.toString(value.charAt(index)));	// convert current index to integer

				for(int i = 1; i <= currentNumber; i++) {	// find the factorial of the current number
					currentFactorial *= i;
				}

				currentSum += currentFactorial;	// add the factorial to currentSum
			}

			if(currentSum == num) {	// if currentSum is the same as the number
				sum += num;	// add number to sum
			}
		}

		System.out.println("The sum of all numbers which are equal to the sum of the factorial of their digits is: " + sum);
	}
}