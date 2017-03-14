/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/

import java.io.*;
import java.util.*;

class TenThousandAndOne_Prime {
	public static void main(String[] args) {
		int numOfPrimes = 0;	// counting primes
		long currentValue = 1;	// current value we're checking for primes

		while(numOfPrimes < 10001) {	// iterate until we find our 10001'th prime
			boolean isPrime = true;

			currentValue++;

			for(int i = 2; i < currentValue; i++) {	// iterate from 2....currentValue-1
				if(currentValue%i == 0) {	// if %i == 0; we have another divisor == not prime
					isPrime = false;
					break;
				}
			}

			if(isPrime) {	// if we find a prime number, add 1 to count of primes
				numOfPrimes++;
			}
		}

		System.out.println(currentValue);
	}
}