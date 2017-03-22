/*
In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
*/

import java.io.*;
import java.util.*;

class Coin_Sums {
	public static void main(String[] args) {
		long count = 0;	// variable holding number of solutions

		int sum = 200;	// we are attempting to create a value = 200

		for(int twoHundredPence = 0; twoHundredPence <= sum/200; twoHundredPence++) {	// loop for 200p
			for(int oneHundredPence = 0; oneHundredPence <= sum/100; oneHundredPence++) {	// loop for 100p
				for(int fiftyPence = 0; fiftyPence <= sum/50; fiftyPence++) {	// loop for 50p
					for(int twentyPence = 0; twentyPence <= sum/20; twentyPence++) {	// loop for 20p
						for(int tenPence = 0; tenPence <= sum/10; tenPence++) {	// loop for 10p
							for(int fivePence = 0; fivePence <= sum/5; fivePence++) {	// loop for 5p
								for(int twoPence = 0; twoPence <= sum/2; twoPence++) {	// loop for 2p
									if((twoHundredPence*200) + (oneHundredPence*100) + (fiftyPence*50) + (twentyPence*20) + (tenPence*10) + (fivePence*5) + (twoPence*2) <= sum) {
										// if the sum of all variables <= 200, we can make a combination of 2 pounds by filling the remainder with 1 pence.
										count++;
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println("The count of all of the different ways that 2 pounds can be made using any number of coins is: " + count);
	}
}