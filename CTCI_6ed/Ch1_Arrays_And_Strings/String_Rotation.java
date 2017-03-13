/*
 Assume you have a method isSubstring which checks if one word is a substring of another.
 Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring.
 (e.g., "waterbottle" is a rotation of "erbottlewat")
*/

import java.io.*;
import java.util.*;

class String_Rotation {
	public static boolean isSubstring(String s1, String s2) {
		String doubledString = s1 + s1;

		return(doubledString.indexOf(s2) != -1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the first string: ");
		String s1 = scan.nextLine();

		System.out.print("Please enter the second string: ");
		String s2 = scan.nextLine();

		System.out.println(isSubstring(s1, s2));
	}
}