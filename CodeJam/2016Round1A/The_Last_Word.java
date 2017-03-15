import java.io.*;
import java.util.*;

class The_Last_Word {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int numOfCases = scan.nextInt();	// find number of cases

		scan.nextLine();	// clear buffer

		for(int currentCase = 0; currentCase < numOfCases; currentCase++) {
			String line = scan.nextLine();	// read in the case

			StringBuilder lastWord = new StringBuilder();	// StringBuilder to store "lastWord"

			lastWord.append(line.charAt(0));	// add initial letter

			for(int index = 1; index < line.length(); index++) {	// iterate through remaining letters
				if((int)line.charAt(index) >= (int)lastWord.charAt(0)) {	// if the letter is bigger than current first letter
					lastWord.insert(0, line.charAt(index));	// add letter to front of string
				} else {
					lastWord.append(line.charAt(index));	// otherwise add letter to end of the string
				}
			}

			System.out.println("Case #" + (currentCase + 1) + ": " + lastWord);
		}
	}
}