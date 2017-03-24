/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

import java.io.*;
import java.util.*;

class Multiples_of_3_and_5 {
	public static void main(String[] args) {
		int sum = 0;	// variable holding total sum

		for(int i = 3; i < 1000; i += 3) {	// iterate through each multiple of 3
			sum += i;	// add multiples to sum
		}

		for(int i = 5; i < 1000; i += 5) {	// iterate through each multiple of 5
			if(i % 3 != 0) {	// check if we already added it earlier
				sum += i;	// add multiples to sum
			}
		}

		System.out.println("The sum of all multiples of 3 or 5 below 1000 is: " + sum);
	}
}