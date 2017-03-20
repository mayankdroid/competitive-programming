/*
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/

import java.io.*;
import java.util.*;

class Digit_Fifth_Powers {
	public static void main(String[] args) {
		long sum = 0;	// overall sum

		for(long number = 2; number < 1000000; number++) {	// Arbitrarily large stopping point
			String stringNumber = Long.toString(number);	// convert to string

			long currentSum = 0;	// create variable to hold currentSum

			for(int i = 0; i < stringNumber.length(); i++) {	// iterate through each number
				currentSum += (long) Math.pow(Integer.parseInt(Character.toString(stringNumber.charAt(i))),5);	// take each number to the fifth power
			}

			if(currentSum == number) {	// if the currentSum is equal to the number
				sum += number;	// add the number to the overall sum
			}
		}

		System.out.println("The sum of all numbers where the sum of their digits to the fifth power is equal to the number is: " + sum);
	}
}