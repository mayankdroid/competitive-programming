/*
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
*/

import java.io.*;
import java.util.*;

class Number_Spiral_Diagonals {
	public static void main(String[] args) {
		long sum = 0;	// total sum

		int currentValue = 0;	// value of the diagonals

		int additionalValue = 0;	// value to add for all 4 of the diagonals

		for(int sideLength = 1; sideLength <=1001; sideLength+=2) {	// side length increases +2 everytime
			if(sideLength == 1) {
				currentValue = 1;
				sum += currentValue;	// first iteration only has one number as the "diagonal"
			} else {
				additionalValue += 2;
				for(int i = 0; i < 4; i++) {
					currentValue += additionalValue;	// adding additionalValue to currentValue to get each of the 4 diagonals
					sum += currentValue;	// adding currentValue (diagonal) to sum
				}
			}
		}

		System.out.println("The sum of the numbers on the diagonals in a 1001x1001 spiral is: " + sum);
	}
}