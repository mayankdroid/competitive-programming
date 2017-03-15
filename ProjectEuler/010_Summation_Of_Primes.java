/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

import java.io.*;
import java.util.*;

class Summation_Of_Primes {
	public static void main(String[] args) {
		long sumOfPrimes = 0L;	// sum of all primes
		long currentValue = 1;	// current value we're checking for primes

		while(currentValue < 2000000) {	// iterate until 2000000
			boolean isPrime = true;

			currentValue++;

			for(int i = 2; i < currentValue; i++) {	// iterate from 2....currentValue-1
				if(currentValue%i == 0) {	// if %i == 0; we have another divisor == not prime
					isPrime = false;
					break;
				}
			}

			if(isPrime) {	// if we find a prime number, add 1 to count of primes
				sumOfPrimes += currentValue;
			}
		}

		System.out.println(sumOfPrimes);
	}
}