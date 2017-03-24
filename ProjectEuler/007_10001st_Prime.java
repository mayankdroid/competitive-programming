/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/

import java.io.*;
import java.util.*;
import java.math.*;

class TenThousandAndOne_Prime {
	public static boolean isPrime(long value) {
		boolean isPrime = true;

		for(int i = 2; i < Math.ceil(value/2); i++) {	// iterate from 2....Math.ceil(value/2)
			if(value % i == 0) {	// if %i == 0; we have another divisor == not prime
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}

	public static void main(String[] args) {
		int numOfPrimes = 0;	// counting primes
		long currentValue = 1;	// current value we're checking for primes

		while(numOfPrimes <= 10001) {	// iterate until we find our 10001'th prime
			currentValue++;

			if(isPrime(currentValue)) {	// if we find a prime number, add 1 to count of primes
				numOfPrimes++;
			}
		}

		System.out.println("The 10,001st prime number is: " + currentValue);
	}
}