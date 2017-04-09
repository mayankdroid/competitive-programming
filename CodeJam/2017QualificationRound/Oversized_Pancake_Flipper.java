import java.io.*;
import java.util.*;

class Oversized_Pancake_Flipper {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int value = scan.nextInt();

		scan.nextLine();

		for(int i = 0; i < value; i++) {
			String nextString = scan.nextLine();

			String[] tokens = nextString.split("\\s+");

			int flipSize = Integer.parseInt(tokens[1]);

			StringBuilder pancakeRow = new StringBuilder(tokens[0]);

			int count = 0;

			for(int j = 0; j <= pancakeRow.length() - flipSize; j++) {
				if(pancakeRow.charAt(j) == '-') {
					count++;

					for(int k = 0; k < flipSize; k++) {
						if(pancakeRow.charAt(j + k) == '-') {
							pancakeRow.setCharAt(j + k, '+');
						} else {
							pancakeRow.setCharAt(j + k, '-');
						}
					}
				}
			}

			boolean didFlip = true;

			for(int j = 0; j < pancakeRow.length(); j++) {
				if(pancakeRow.charAt(j) == '-') {
					didFlip = false;
					break;
				}
			}

			System.out.print("Case #" + (i + 1) + ": ");

			if(didFlip) {
				System.out.println(count);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
}