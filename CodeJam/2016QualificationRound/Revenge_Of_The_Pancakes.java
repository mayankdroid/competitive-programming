import java.io.*;
import java.util.*;

class Revenge_Of_The_Pancakes {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int numOfCases = scan.nextInt();

		scan.nextLine();

		for(int currentCase = 0; currentCase < numOfCases; currentCase++) {
			String stack = scan.nextLine();

			char[] stackChars = stack.toCharArray();

			int numOfFlips = 0;

			for(int i = stack.length() - 1; i >= 0; i--) {
				if(stackChars[i] == '-') {	// need to flip
					numOfFlips++;

					for(int j = 0; j <= i; j++) {	// flip all values from beginning to i
						if(stackChars[j] == '+') {
							stackChars[j] = '-';
						} else {
							stackChars[j] = '+';
						}
					}
				}
			}

			System.out.println("Case #" + (currentCase + 1) + ": " + numOfFlips);
		}
	}
}