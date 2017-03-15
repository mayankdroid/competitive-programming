/*
The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?
*/

import java.io.*;
import java.util.*;

class Highly_Divisible_Triangular_Number {
	public static void main(String[] args) {
		int maxDivisors = 0;
		long currentNumber = 0;	// holds the current index (nth triangular number)
		double triangularNumber = 0;	// holds the current value of the triangular number

		while(maxDivisors <= 500) {	// loop until we have over 500 divisors

			currentNumber++;

			triangularNumber += currentNumber;	// add current number to get next triangularNumber

			int currentDivisors = 0;

			for(int j = 1; j <= Math.ceil(Math.sqrt(triangularNumber)); j++) {	// iterate from 1...sqrt(triangularNumber)
				if(triangularNumber % j == 0) {	// find all divisors
					if(triangularNumber == j*j) {
						currentDivisors++;	// one divisor (the perfect squareroot)
					} else {
						currentDivisors += 2;	// two divisors (one before, one after the sqrt)
					}
				}
			}

			if(currentDivisors > maxDivisors) {	// if new max, write to maxDivisors
				maxDivisors = currentDivisors;
			}
		}

		System.out.printf("The first triangular number with over 500 divisors is: %.0f\n", triangularNumber);
	}
}