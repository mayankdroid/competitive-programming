/*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Circular_Primes {
	public static boolean isPrime(long number) {
		boolean isPrime = true;	// flag holding whether number is prime

		for(long i = 2; i < Math.ceil(number/2) + 1; i++) {	// iterate from 2....number/2+1
			if(number % i == 0) {	// if divisible
				isPrime = false;	// number is not prime
				break;	// exit loop
			}
		}

		return isPrime;
	}

	public static boolean isCircularPrime(long number) {
		String stringValue = Long.toString(number);	// convert number to string
		boolean isCircularPrime = true;	// flag holding whether number is a circular prime

		// as we do circular primes, all values will eventually be in the ones place. meaning any 2,4,6,8,0 in the number will become an even number (not prime). Also, 5 will always be divisible by 5.
		if(stringValue.contains("2") || stringValue.contains("4") || stringValue.contains("6") || stringValue.contains("8") || stringValue.contains("0") || stringValue.contains("5") ) {
			isCircularPrime = false;
		} else {
			if(isPrime(number)) {	// if the original number is prime
				stringValue = stringValue.substring(1,stringValue.length()) + stringValue.substring(0,1);	// move first number to end

				while(Long.parseLong(stringValue) != number) {	// iterate until stringValue == number
					if(!isPrime(Long.parseLong(stringValue))) {	// if not prime
						isCircularPrime = false;	// is not circularly prime
						break;
					}

					stringValue = stringValue.substring(1,stringValue.length()) + stringValue.substring(0,1);	// move first number to end
				}
			} else {	// if the original number is composite
				isCircularPrime = false;
			}
		}

		return isCircularPrime;
	}

	public static void main(String[] args) {
		int count = 4;	// including 2, 3, 5, 7 automatically

		for(long i = 9; i < 1000000; i+=2) {	// iterate from 9...<1000000 by 2s (all odd numbers)
			if(isCircularPrime(i)) {	// if i is circularly prime
				count++;	// add one to count
			}
		}

		System.out.println("The number of circular primes below one million is: " + count);
	}
}