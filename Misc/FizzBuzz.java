/*
ID: Wilson Ding
LANG: JAVA
PROG: FizzBuzz
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