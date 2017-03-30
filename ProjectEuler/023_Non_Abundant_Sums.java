/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Non_Abundant_Sums {
	public static boolean isAbundant(int value) {
		int sum = 0;	// sum to hold sum of all divisors

		for(int i = 1; i <= Math.sqrt(value); i++) {	// iterate from 1....sqrt(value) + 1
			if(value % i == 0) {	// if divisible
				sum += i;

				if(i != Math.sqrt(value) && i != 1) {	// if we are not dealing with the sqrt or 1
					sum += value/i;	// add the quotient as well
				}
			}
		}

		if(sum > value) {	// if abundant
			return true;
		} else {	// if not abundant
			return false;
		}
	}

	public static boolean isNonAbundantSum(int value) {
		boolean isNonAbundantSum = true;	// flag to hold validity of isNonAbundantSum

		for(int i = 12; i <= value/2; i++) {	// iterate from 12... halfway through value
			if(isAbundant(i) && isAbundant(value-i)) {	// if i and value-i are both abundant
				isNonAbundantSum = false;	// value is a sum of two abundant numbers
				break;	// end loop
			}
		}

		return isNonAbundantSum;
	}

	public static void main(String[] args) {
		long sum = 0;	// hold sum of all nonabundant sums

		for(int i = 1; i <= 28123; i++) {	// iterate from lower to upper bound
			if(isNonAbundantSum(i)) {	// if non abundant sum
				sum += i;	// add to sum
			}
		}

		System.out.println("The sum of all positive integers which cannot be written as the sum of two abundant numbers is: " + sum);
	}
}