/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/

import java.io.*;
import java.util.*;

class Largest_Prime_Factor {
	public static void main(String[] args) {
		long factorizeNumber = 600851475143L;	// added L to specify 64-bit long

		for(long currentFactor = 2; currentFactor <= factorizeNumber; currentFactor++) {	// iterating through all possible factors
			while(factorizeNumber%currentFactor == 0) {	// if divisible, divide
				factorizeNumber = factorizeNumber/currentFactor;
			}

			if(factorizeNumber == 1) {	// if the number is one, we have found our largest prime divisor
				System.out.println("The largest prime factor is " + currentFactor);
			}
		}
	}
}