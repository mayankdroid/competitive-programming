/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
*/

class Number_Letter_Counts {
	public static void main(String[] args) {
		long letterCount = 0;

		int[] counts = new int[] {0,3,3,5,4,4,3,5,5,4,3,6,6,8,8,7,7,9,8,8};	// counts 0-19
		int[] tens = new int[] {0,0,6,6,5,5,5,7,6,6};	// counts 0,10,20...90
		int hundredAnd = 10;	// count of "...hundred and..."
		int oneThousand = 11;	// count of "one thousand"

		for(int i = 1; i <= 1000; i++) {
			String value = Integer.toString(i);

			if(value.length() == 1) {	// single digits
				letterCount += counts[i];	// add the count to letterCount
			} else if(value.length() == 2) {
				int tensDigit = Integer.parseInt(Character.toString(value.charAt(0)));

				if(tensDigit == 1) {	// if the 10s digit is 1
					letterCount += counts[i];	// add the count to letterCount
				} else {
					letterCount += tens[tensDigit];	// add the 10s digit to letterCount
					letterCount += counts[i-(tensDigit*10)];	// add the ones digit to letterCount
				}
			} else if(value.length() == 3) {
				int hundredsDigit = Integer.parseInt(Character.toString(value.charAt(0)));

				letterCount += counts[hundredsDigit];	// add hundreds digit
				letterCount += hundredAnd;	// add "...hundred and..."

				if(i % 100 == 0) {	// special case: 100,200,300...900 doesn't need the "and"
					letterCount -= 3;
				}

				int tensDigit = Integer.parseInt(Character.toString(value.charAt(1)));

				if(tensDigit == 1) {	// if the 10s digit is 1
					letterCount += counts[i-(hundredsDigit*100)];	// add the count to letterCount
				} else {
					letterCount += tens[tensDigit];	// add the 10s digit to letterCount
					letterCount += counts[i-(hundredsDigit*100)-(tensDigit*10)];	// add the ones digit to letterCount
				}
			} else if(value.length() == 4) {
				letterCount += oneThousand;	// add oneThousand count to letterCount
			} else {
				System.out.println("Error!");	// this should never occur
			}
		}

		System.out.println("The total letter count from one to one thousand is: " + letterCount);
	}
}