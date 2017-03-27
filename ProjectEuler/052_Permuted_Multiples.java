/*
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
*/

import java.io.*;
import java.util.*;

class Permuted_Multiples {
	public static boolean[] findValues(long number) {
		boolean[] existingNumbers = new boolean[10];	// create boolean array for if a number exists. 0....9
		String value = Long.toString(number);	// convert long to string

		for(int i = 0; i < 10; i++) {	// set all values to false
			existingNumbers[i] = false;
		}

		for(int i = 0; i < value.length(); i++) {	// iterate through all characters, and set boolean array to true
			existingNumbers[Integer.parseInt(Character.toString(value.charAt(i)))] = true;
		}

		return existingNumbers;	// return boolean array
	}

	public static void main(String[] args) {
		boolean isPermuted = false;	// flag for running until we find a result
		long number = 1;	// long to store current number

		while(!isPermuted) {	// loop until found
			number++;	// increase number

			if(Arrays.equals(findValues(number),findValues(number*2)) && Arrays.equals(findValues(number),findValues(number*3)) && Arrays.equals(findValues(number),findValues(number*4)) && Arrays.equals(findValues(number),findValues(number*5)) && Arrays.equals(findValues(number),findValues(number*6))) {
				isPermuted = true;	// if the boolean arrays are equal, set isPerumted to true to stop loop
			}
		}

		System.out.println("The smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x contains the same digits is: " + number);
	}
}