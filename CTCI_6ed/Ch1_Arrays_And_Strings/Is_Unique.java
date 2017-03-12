/*
 Implement an algorithm to determine if a string has all unique characters.
 What if you cannot use additional data structures? (Assume string is ASCII based.)
*/

import java.io.*;
import java.util.*;

class Is_Unique {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Please enter a string to check for unique characters: "); // Prompt user to enter string
		String inputString = scan.nextLine();

		boolean isUnique = true;

		if(inputString.length() > 26) { // only 26 unique characters
			isUnique = false;
		} else {
			for(int i = 0; i < inputString.length(); i++) {
				for(int j = i + 1; j < inputString.length(); j++) {
					if(inputString.charAt(i) == inputString.charAt(j)) { // Brute force through every possible combination
						isUnique = false;
					}
				}
			}
		}

		if(isUnique) {
			System.out.println("The string has all unique characters.");
		} else {
			System.out.println("The string has duplicates.");
		}
	}
}