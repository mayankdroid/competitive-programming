/*
The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Double_Base_Palidromes {
	public static boolean isPalindrome(String stringValue) {	// input a string, return a boolean for whether or not it is a palindrome
		boolean isPalindrome = true;	// boolean variable default to true

		for(int i = 0; i < stringValue.length()/2; i++) {	// go through half of the string
			if(!(stringValue.charAt(i) == stringValue.charAt(stringValue.length() - 1 - i))) {	// if value != "mirrored" value at end of string
				isPalindrome = false;	// isPalindrome = false
				break;	// exit loop
			}
		}

		return isPalindrome;	// return boolean value
	}

	public static BigInteger convertToBaseTwo(long value) {
		StringBuilder baseTwoValue = new StringBuilder();	// StringBuilder to create base two string

		int baseTwoDivisor = 1;	// divisor to generate base two

		while(value >= baseTwoDivisor) {	// multiply by two until we get over the number
			baseTwoDivisor *= 2;
		}

		boolean ended = false;	// boolean flag to check if looped all the way to baseTwoDivisor = 1

		while(value != 0 || !ended) {	// loop until value is empty

			baseTwoDivisor /= 2;	// lower the place value of the divisor

			if(baseTwoDivisor == 1) {	// if divisor == 1
				ended = true;	// change end flag to true
			}

			if(value >= baseTwoDivisor) {	// value > place value
				value -= baseTwoDivisor;	// subtract baseTwoDivisor from value
				baseTwoValue.append("1");	// append a 1
			} else {	// place value > value
				baseTwoValue.append("0");	// did not subtract from value, append a 0
			}
		}

		return new BigInteger(baseTwoValue.toString());	// return the parsed BigInteger from StringBuilder
	}

	public static void main(String[] args) {
		long sum = 0;	// variable holding sum of all double base palindromes

		for(long i = 1; i < 1000000; i++) {	// iterate through all numbers 1...1000000
			if(isPalindrome(Long.toString(i)) && isPalindrome(convertToBaseTwo(i).toString())) {	// if both base 10 and base 2 are palindromes
				sum += i;	// add i to sum
			}
		}

	System.out.println("The sum of all numbers less than one million which are palindromic in base 10 and base 2 is: " + sum);
	}
}