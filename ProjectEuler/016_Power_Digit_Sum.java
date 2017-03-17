/*
215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 21000?
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Power_Digit_Sum {
	public static void main(String[] args) {
		BigInteger exponent = BigInteger.valueOf(2).pow(1000);	// create BigInteger 2^1000

		String value = exponent.toString();	// convert to String

		long sum = 0;	// create variable to store sum

		for(int i = 0; i < value.length(); i++) {	// iterate through each digit
			sum += Integer.parseInt(Character.toString(value.charAt(i)));	// add to sum
		}

		System.out.println("The sum of all of the digits in the number 2^1000 is: " + sum);
	}
}