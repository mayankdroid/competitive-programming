import java.io.*;
import java.util.*;

class Tidy_Numbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int cases = scan.nextInt();

		scan.nextLine();

		for(int i = 0; i < cases; i++) {
			String value = scan.nextLine();

			StringBuilder result = new StringBuilder();

			boolean found = false;

			for(int j = 0; j < value.length(); j++) {
				if(!found) {
					int currentInteger = Integer.parseInt(Character.toString(value.charAt(j)));

					if(value.length() > 1 && j < value.length() - 1) {
						int nextInteger = Integer.parseInt(Character.toString(value.charAt(j+1)));

						if(currentInteger > nextInteger) {
							if(j > 0 && currentInteger == Integer.parseInt(Character.toString(value.charAt(j-1)))) {
								int traceBack = j;

								while(traceBack > 0 && Integer.parseInt(Character.toString(value.charAt(traceBack-1))) == currentInteger) {
									traceBack--;
								}

								result.setCharAt(traceBack, Character.forDigit(Integer.parseInt(Character.toString(value.charAt(traceBack))) - 1, 10));

								for(int k = traceBack + 1; k < j; k++) {
									result.setCharAt(k, '9');
								}

								result.append("9");
							} else {
								result.append(currentInteger - 1);
							}
							
							found = true;
						} else {
							result.append(currentInteger);
						}
					} else {
						result.append(currentInteger);
					}
				} else {
					result.append("9");
				}
			}

			while(result.charAt(0) == '0') {
				result.deleteCharAt(0);
			}

			System.out.println("Case #" + (i + 1) + ": " + result);
		}
	}
}