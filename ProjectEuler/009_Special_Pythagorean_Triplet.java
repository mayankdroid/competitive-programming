/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

import java.io.*;
import java.util.*;

class Special_Pythagorean_Triplet {
	public static void main(String[] args) {
		boolean valueFound = false;

		for(int a = 1; a < 1000; a++) {	// iterate through all values from 1...1000 for a
			if(valueFound) {
				break;
			}

			for(int b = 1; b < 1000; b++) { // iterate through all values from 1...1000 for a
				double c = Math.sqrt((a*a) + (b*b));	// find c given a and b
				if(c%1 == 0) {	// if c is a whole number
					if(a+b+c == 1000) {	// if a+b+c == 1000
						System.out.println("The answer is: " + a*b*c);	// find the product of a,b,c
						valueFound = true;
						break;
					}
				}
			}
		}
	}
}