/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Factorial_Digit_Sum {
	public static void main(String[] args) {
		BigInteger factorial = BigInteger.valueOf(1);

		int sum = 0;

		for(int i = 1; i <= 100; i++) {	// find product of factorial
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}

		String value = factorial.toString();	// convert factorial to string for easy traversing

		for(int i = 0; i < value.length(); i++) {	// traverse through each digit of factorial and add up
			sum += Integer.parseInt(Character.toString(value.charAt(i)));
		} 

		System.out.println("The sum of all digits in 100! is: " + sum);
	}
}