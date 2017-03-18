/*
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Digit_Fibonacci_Number {
	public static void main(String[] args) {
		BigInteger firstNumber = BigInteger.valueOf(1);	// first number
		BigInteger secondNumber = BigInteger.valueOf(1);	// second number

		BigInteger sum = BigInteger.valueOf(2);	// sum of the first two numbers (third number)

		int index = 3;	// current index = 3

		while(sum.toString().length() < 1000) {	// length of sum < 1000
			index++;

			firstNumber = secondNumber;
			secondNumber = sum;

			sum = BigInteger.valueOf(0).add(firstNumber).add(secondNumber);	// find next number
		}

		System.out.println("The index of the first fibonacci number that has 1000 digits is: " + index);
	}
}