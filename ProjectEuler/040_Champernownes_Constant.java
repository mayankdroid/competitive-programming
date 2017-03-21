/*
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
*/

import java.io.*;
import java.util.*;

class Champernownes_Constant {
	public static void main(String[] args) {
		StringBuilder constant = new StringBuilder();	// create stringbuilder to create string

		int i = 1;	// variable to iterate through all numbers

		while(constant.length() < 1000000) {	// while we don't have a long enough string
			constant.append(Integer.toString(i));	// add i to the string
			i++;	// increase i
		}

		char[] constantArray = constant.toString().toCharArray();	// convert to a charArray for easy handling

		// find product
		int product = (Integer.parseInt(Character.toString(constantArray[0])) *
						Integer.parseInt(Character.toString(constantArray[9])) *
						Integer.parseInt(Character.toString(constantArray[99])) *
						Integer.parseInt(Character.toString(constantArray[999])) *
						Integer.parseInt(Character.toString(constantArray[9999])) *
						Integer.parseInt(Character.toString(constantArray[99999])) *
						Integer.parseInt(Character.toString(constantArray[999999])));

		System.out.println("The product of the values from Champernownes Constant is: " + product);
	}
}