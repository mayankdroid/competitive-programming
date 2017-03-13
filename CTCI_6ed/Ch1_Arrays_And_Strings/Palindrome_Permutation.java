/*
 Given a string, write a function to check if it is a permutation of a palindrome.
 A palindrome is a word of phrase that is the same forwards and backwards.
 A permutaiton is a rearrangement of letters.
 The palindrome does not need to be limited to just dictionary words.
*/

 import java.io.*;
 import java.util.*;

 class Palindrome_Permutation {
 	public static void main(String[] args) {
 		Scanner scan = new Scanner(System.in);
 		System.out.println("Please enter a string to check for palindrome permutations: ");
 		String inputString = scan.nextLine();

 		HashMap mapOfLetters = new HashMap(inputString.length());

 		for(int i = 0; i < inputString.length(); i++) {
 			char currentLetter = inputString.charAt(i);
 			if(mapOfLetters.containsKey(currentLetter)) {
 				mapOfLetters.put(currentLetter, (int) mapOfLetters.get(currentLetter) + 1);
 			} else {
 				mapOfLetters.put(currentLetter, 1);
 			}
 		}

 		Collection values = mapOfLetters.values();

 		int numOfOddCharacters = 0;
 		
 		for(Object element : values) {
 			if(Integer.parseInt(element.toString())%2 == 1) {
 				numOfOddCharacters++;
 			}
 		}

 		if(numOfOddCharacters > 1) {
 			System.out.println("False");
 		} else {
 			System.out.println("True");
 		}
 	}
 }