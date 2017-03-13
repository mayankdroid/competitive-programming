/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

import java.io.*;
import java.util.*;

class Smallest_Multiple {
	public static void main(String[] args) {
		// divisible by 1 = divisible by 1
		// divisible by 12 = divisible by 2,3,4,6, 12
		// divisible by 20 = divisible by 5, 10, 20
		// divisible by 14 = divisible by 7, 14
		// divisible by 16 = divisible by 8, 16
		// divisible by 18 = divisible by 9, 18
		// divisible by 11 = divisible by 11
		// divisible by 13 = divisible by 13
		// divisible by 15 = divisible by 15
		// divisible by 17 - divisible by 17
		// divisible by 19 = divisible by 19
		// The numbers to the left of the equal sign cover all divisiblity rules

		for(long i = (3*5*7*11*13*17*19*10); i < (12*20*14*16*18*11*13*15*17*19); i+=10) {	// starting from product of primes * 10, and checking all values ending with 0 (divisibility by 10)
			boolean divisible = true;

			for(int divideValue = 2; divideValue <= 20; divideValue ++) {
				if(i%divideValue != 0) {
					divisible = false;
					break;
				}
			}

			if(divisible) {
				System.out.println("The smallest multiple is: " + i);
				break;
			}
		}
	}
}