/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

import java.io.*;
import java.util.*;

class Largest_Palindrome_Product {
	public static boolean isPalindrome(long value) {
		boolean isPalindrome = true;

		String stringValue = Long.toString(value);	// create a string of the result

		for(int i = 0; i <= stringValue.length()/2; i++) {	// iterate through the first and last number, then go in
			if(stringValue.charAt(i) != stringValue.charAt(stringValue.length()-i-1)) {	// if the numbers are not the same
				isPalindrome = false;	// it is not a palindrome
				break;
			}
		}

		return isPalindrome;
	}

	public static void main(String[] args) {
		boolean valueFound = false;

		for(long valueOne = 999; valueOne >= 900; valueOne--) {	// first three digit number

			if(valueFound) {	// if we find the value, end the looping
				break;
			}

			for(long valueTwo = 999; valueTwo >= 900; valueTwo--) {	// second three digit number
				long product = valueOne * valueTwo;

				if(isPalindrome(product)) {	// if we find the palindrome, print out the result and return
					System.out.println("The largest palindrome created from the product of two three digit numbers is: " + product);
					valueFound = true;
					break;
				}
			}
		}
	}
}