/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
*/

import java.io.*;
import java.util.*;

class Names_Scores {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		long sumOfScores = 0;	// holds the total sum of all name scores

		String names = scan.nextLine();	// read in all the names

		names = names.substring(1, names.length()-1);	// removing outter quotation marks

		String[] splitNames = names.split("\",\"");	// split names by ","

		TreeSet<String> sortedNames = new TreeSet<String>();	// TreeSet to easily sort all values

		for(String name : splitNames) {	// iterating through all names in splitNames
			sortedNames.add(name);	// adding to TreeSet to sort
		}

		int index = 1;

		for(String name : sortedNames) {
			int nameScore = 0;

			for(int i = 0; i < name.length(); i++) {
				nameScore += (int)name.charAt(i) - 'A' + 1;	// getting ASCII value of each letter
			}

			sumOfScores += nameScore * index;	// add the product of nameScore and index to sumOfScores

			index++;	// iterate to next item on the list
		}

		System.out.println("The total sum of all of the name scores in the text file is: " + sumOfScores);
	}
}