/*
A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.

For example,

44 → 32 → 13 → 10 → 1 → 1
85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89

Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.

How many starting numbers below ten million will arrive at 89?
*/

import java.io.*;
import java.util.*;

class Square_Digit_Chains {
	public static boolean doesLoop(long number) {
		boolean doesLoop = true;	// boolean holding loop status

		Long chain = number;	// save number as chain

		while(chain != 1 && chain != 89) {	// loop until chain is either 1 or 89
			String value = Long.toString(chain);	// convert chain to string
			chain = 0L;	// reset chain to 0

			for(int i = 0; i < value.length(); i++) {	// iterate through all digits
				int digit = Integer.parseInt(Character.toString(value.charAt(i)));	// get digit value
				chain += (digit*digit);	// add the square to chain
			}
		}

		if(chain == 1) {	// if chain is stuck on loop of 1
			doesLoop = false;	// does not loop
		}

		return doesLoop;
	}

	public static void main(String[] args) {
		long numbers = 0;

		for(long i = 1; i < 10000000; i++) {	// iterate from 1...10000000
			if(doesLoop(i)) {	// if doesLoop
				numbers++;	// add one to numbers count
			}
		}

		System.out.println("The total number of square digit chains below ten million that arrive at 89 is: " + numbers);
	}
}