/*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Truncatable_Primes {
	public static boolean isPrime(long currentNumber) {
		boolean isPrime = true;	// flag for whether the currentNumber is prime

		if(currentNumber == 1) {	// this time we have to deal with possibility of a value of 1.
			return false;
		}

		for(long i = 2; i <= Math.ceil(currentNumber/2); i++) {	// iterate from 2... currentNumber/2
			if(currentNumber % i == 0) {	// if divisible
				isPrime = false;	// the value is not prime
				break;
			}
		}

		return isPrime;
	}

	public static boolean isTruncatable(long currentNumber) {
		boolean isTruncatable = true;	// flag for whether the currentNumber is truncatable
		String currentValue = Long.toString(currentNumber);	// convert to a string

		int firstNumber = Integer.parseInt(currentValue.substring(0,1));	// checking first value to cut down on checks

		if(firstNumber == 1 || firstNumber == 4 || firstNumber == 6 || firstNumber == 8) {	// if the first number is 1, 4, 6, 8, automatically not prime (fails right truncate test)
			return false;
		}

		String currentLeftTruncate = currentValue;	// create an instance for left truncation
		while(currentLeftTruncate.length() > 0) {	// iterate until string is empty
			if(!isPrime(Long.parseLong(currentLeftTruncate))) {	// if the new value is not prime
				isTruncatable = false;	// is not truncatable
				break;	// end loop
			}

			currentLeftTruncate = currentLeftTruncate.substring(1);	// create new substring removing one from left
		}

		if(isTruncatable) {	// if we passed the first test
			String currentRightTruncate = currentValue;	// create an instance for right truncation
			while(currentRightTruncate.length() > 0) {	// iterate until string is empty
				if(!isPrime(Long.parseLong(currentRightTruncate))) {	// if the new value is not prime
					isTruncatable = false;	// is not truncatable
					break;	// end loop
				}

				currentRightTruncate = currentRightTruncate.substring(0, currentRightTruncate.length()-1);	// create substring removing one from right
			}
		}

		return isTruncatable;
	}

	public static void main(String[] args) {
		int primesFound = 0;	// variable keeping track until we find 11 truncatable primes
		long sum = 0;	// sum of all truncatable primes

		long currentNumber = 9;	// our current number - starting after 2,3,5, and 7

		while(primesFound < 11) {	// loop until we find 11 primes
			currentNumber+=2;	// increase current number by 2 (only checking odds)

			if(isPrime(currentNumber) && isTruncatable(currentNumber)) {	// if current number is prime and truncatable
				sum += currentNumber;	// add to sum
				primesFound++;	// increase primesFound
			}
		}

		System.out.println("The sum of all truncatable primes is: " + sum);
	}
}