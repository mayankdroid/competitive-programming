/*
Consider all integer combinations of ab for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:

22=4, 23=8, 24=16, 25=32
32=9, 33=27, 34=81, 35=243
42=16, 43=64, 44=256, 45=1024
52=25, 53=125, 54=625, 55=3125
If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:

4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125

How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Distinct_Powers {
	public static void main(String[] args) {
		TreeSet<String> values = new TreeSet<String>();	// TreeSet to hold all values (automatically puts in order and removes duplicates)
		for(int a = 2; a <= 100; a++) {	// a value
			for(int b = 2; b <= 100; b++) {	// b value
				values.add(Double.toString(Math.pow(a,b)));	// add a^b to TreeSet
			}
		}

		System.out.println("The number of distinct terms generated in the sequence is: " + values.size());
	}
}