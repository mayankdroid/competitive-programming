import java.io.*;
import java.util.*;
import java.math.*;

class Bathroom_Stalls {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int cases = scan.nextInt();

		for(int i = 0; i < cases; i++) {
			long numberOfStalls = scan.nextLong();
			long numberOfUsers = scan.nextLong();

			long x = 0;
			long y = 0;

			if(numberOfUsers != numberOfStalls) {
				int power = 0;
				long twoSum = 0;

				while(twoSum < numberOfUsers) {
					twoSum += Math.pow(2, power);
					power++;
				}

				power--;

				twoSum -= Math.pow(2, power);

				long leftover = numberOfUsers - twoSum;

				long largestSpace = numberOfStalls;

				long even;
				long odd;

				if(numberOfStalls % 2 == 0) {
					even = 1L;
					odd = 0L;
				} else {
					even = 0L;
					odd = 1L;					
				}

				for(long k = 0; k < power; k++) {
					long newOdd = even;
					long newEven = even;
					newEven += odd*2;

					even = newEven;
					odd = newOdd;

					if(largestSpace % 2 == 0) {
						largestSpace = largestSpace/2;
					} else {
						largestSpace = (largestSpace - 1)/2;
					}
				}

				if(largestSpace % 2 == 0) {
					if(even >= leftover) {
						if(largestSpace != 0) {
							x = largestSpace/2;
							y = (largestSpace/2) - 1;
						}
					} else {
						largestSpace--;
						x = (largestSpace - 1)/2;
						y = (largestSpace - 1)/2;
					}
				} else {
					if(odd >= leftover) {
						x = (largestSpace - 1)/2;
						y = (largestSpace - 1)/2;
					} else {
						largestSpace--;
						if(largestSpace != 0) {
							x = largestSpace/2;
							y = (largestSpace/2) - 1;
						}
					}
				}
			}

			System.out.println("Case #" + (i + 1) + ": " + x + " " + y);
		}
	}
}