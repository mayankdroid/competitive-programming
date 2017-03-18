/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
*/

import java.io.*;
import java.util.*;

class Amicable_Numbers {
	public static void main(String[] args) {
		int sum = 0;	// total sum of all values

		for(int i = 1; i < 10000; i++) {
			int sumOfAmicableI = 0;	// amicable value
			int sumOfAmicableJ = 0;	// return of amicable value

			for(int j = 1; j < i; j++) {	// find amicable value
				if(i % j == 0) {
					sumOfAmicableI += j;
				}
			}

			for(int j = 1; j < sumOfAmicableI; j++) {	// find return of amicable value
				if(sumOfAmicableI % j == 0) {
					sumOfAmicableJ += j;
				}
			}

			if(sumOfAmicableJ == i && sumOfAmicableI != i) {	// if the return of amicable value == original, yet the amicable value != original
				sum += i;	// add original value to sum
				sum += sumOfAmicableI;	// add amicable value to sum
			}
		}

		sum /= 2;	// found/summed every pair of amicable numbers twice

		System.out.println("The total sum of all amicable numbers under 10000 is: " + sum);
	}
}