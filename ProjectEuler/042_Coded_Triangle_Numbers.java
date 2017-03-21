/*
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
*/

import java.io.*;
import java.util.*;

class Coded_Triangle_Numbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		long numberOfTriangleWords = 0;	// holds the total count of triangle words

		String words = scan.nextLine();	// read in all the words

		words = words.substring(1, words.length()-1);	// removing outter quotation marks

		String[] splitWords = words.split("\",\"");	// split names by ","

		for(String word: splitWords) {	// iterate through each word
			int sum = 0;	// holds the sum of all the letters

			for(int i = 0; i < word.length(); i++) {	// iterates through each character
				sum += (int) word.charAt(i) - 'A' + 1;	// finds the sum of all characters
			}

			int triangleValue = 0;

			for(int addValue = 1; triangleValue < sum; addValue++) {	// iterate until triangleValue = or > sum
				triangleValue += addValue;	// find new triangleValue

				if(triangleValue == sum) {	// is a coded triangle word
					numberOfTriangleWords++;	// iterate count by one
				}
			}
		}

		System.out.println("Within the given text file, there are " + numberOfTriangleWords + " coded triangle words.");
	}
}