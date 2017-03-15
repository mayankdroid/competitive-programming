import java.io.*;
import java.util.*;

class Counting_Sheep {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int numOfCases = scan.nextInt();

		for(int currentCase = 0; currentCase < numOfCases; currentCase++) {
			int currentNumber = scan.nextInt();

			boolean[] hasSeen = new boolean[10];

			boolean done = false;

			int multiplier = 0;

			String value = "";

			if(currentNumber == 0) {
				value = "INSOMNIA";
				done = true;
			}

			while(!done) {
				multiplier++;

				value = Integer.toString(currentNumber*multiplier);

				for(int i = 0; i < value.length(); i++) {
					hasSeen[Integer.parseInt(Character.toString(value.charAt(i)))] = true;
				}

				done = true;

				for(boolean seen : hasSeen) {
					if(!seen) {
						done = false;
					}
				}
			}

			System.out.println("Case #" + (currentCase + 1) + ": " + value);
		}
	}
}