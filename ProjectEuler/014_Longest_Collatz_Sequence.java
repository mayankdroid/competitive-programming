/*
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/

import java.io.*;
import java.util.*;

class Longest_Collatz_Sequence {
	public static void main(String[] args) {
		long longestChain = 0;
		long longestNumber = 0;

		for(long currentNumber = 1; currentNumber < 1000000; currentNumber++) {
			long number = currentNumber;
			long chain = 0;

			while(number != 1) {
				if(number % 2 == 0) {	// if number is even
					number /= 2;
				} else {	// otherwise number is odd
					number = 3*number + 1;
				}

				chain++;
			}

			if(chain > longestChain) {	// if this chain is longer than the longestChain
				longestChain = chain;	// update the chain
				longestNumber = currentNumber;	// update the number
			}
		}

		System.out.println(longestNumber);
	}
}