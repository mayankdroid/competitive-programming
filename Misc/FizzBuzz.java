/*
ID: Wilson Ding
LANG: JAVA
PROG: FizzBuzz
*/

/*
 Write a program that prints the numbers from 1 to 100.
 But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
 For numbers which are multiples of both three and five print “FizzBuzz”.
*/

import java.io.*;
import java.util.*;

class FizzBuzz {
	public static void main(String[] args) {
		for(int i = 0; i <= 100; i++) {
			String output = "";
			if(i%3 == 0) {
				output += "Fizz";
			}
			if(i%5 == 0) {
				output += "Buzz";
			}
			if(output == "") {
				output = Integer.toString(i);
			}
			output += ", ";
			System.out.print(output);
		}
	}
}