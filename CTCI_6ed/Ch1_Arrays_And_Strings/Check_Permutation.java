/*
 Given two strings, write a method to decide if one is a permutation of the other.
*/

import java.io.*;
import java.util.*;

class Check_Permutation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Please enter the first string to check: ");
		String firstInputString = scan.nextLine(); // quering for first input string

		System.out.print("Please enter the second string to check: ");
		String secondInputString = scan.nextLine(); // querying for second input string

		boolean isPermutation = true;

		if(firstInputString.length() != secondInputString.length()) {	// permutations require the same length
			isPermutation = false;
		} else {
			// create StringBuilder for mutability
			StringBuilder secondString = new StringBuilder(secondInputString);

			for(int i = 0; i < firstInputString.length(); i++) {
				int indexOfChar = secondString.indexOf(Character.toString(firstInputString.charAt(i)));	// find index of char in secondString
				
				if(indexOfChar != -1) {	// checking to make sure char was found
					secondString.deleteCharAt(indexOfChar);	// remove char from secondString
				} else {
					isPermutation = false;
				}
			}

			if(!secondString.toString().equals("")) {	// secondString should be empty string after removal of firstIndexString chars
				isPermutation = false;
			}
		}

		if(isPermutation) {
			System.out.println("The two strings are a permutation of one another.");
		} else {
			System.out.println("The two strings are not a permutation of each other.");
		}
	}
}