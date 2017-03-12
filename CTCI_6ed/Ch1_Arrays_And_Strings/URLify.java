/*
 Write a method to replace all spaces in a string with'%20'. You may assume that
 the string has sufficient space at the end of the string to hold the additional
 characters, and that you are given the "true" length of the string. (Note: if
 implementing in Java, please use a character array so that you can perform this
 operation in place.)
 EXAMPLE
 Input:  "Mr John Smith    "
 Output: "Mr%20John%20Smith"
*/

import java.io.*;
import java.util.*;

class URLify {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input string: ");
		String inputString = scan.nextLine();

		System.out.print("Please input length of input string: ");
		int length = Integer.parseInt(scan.nextLine());

		char[] urlString = inputString.toCharArray();	// convert inputString to a char array

		int currentWriteLocation = inputString.length() - 1;	// set the location to write to at the very end.

		for(int i = length - 1; i >= 0; i--) {	// iterate backwards through the char array
			if(urlString[i] != ' ') {	// if we find a nonempty character
				urlString[currentWriteLocation] = urlString[i]; // move character to the currentWriteLocation
				currentWriteLocation--;	// move currentWriteLocation back one space
			} else {	// if we find an empty space, write %20
				urlString[currentWriteLocation] = '0';
				urlString[currentWriteLocation - 1] = '2';
				urlString[currentWriteLocation - 2] = '%';
				currentWriteLocation -= 3;	// move currentWriteLocation before the start of %20
			}
			System.out.println(urlString);
		}
	}
}