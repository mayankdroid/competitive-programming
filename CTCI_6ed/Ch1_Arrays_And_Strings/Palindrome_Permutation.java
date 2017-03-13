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

 		HashMap mapOfLetters = new HashMap(inputString.length());	// create hashmap to store all chars

 		for(int i = 0; i < inputString.length(); i++) {
 			char currentLetter = inputString.charAt(i);	// iterate through each char in string
 			if(mapOfLetters.containsKey(currentLetter)) {	// if char is already in hashmap, just add one
 				mapOfLetters.put(currentLetter, (int) mapOfLetters.get(currentLetter) + 1);
 			} else {
 				mapOfLetters.put(currentLetter, 1);	// otherwise add char to hashmap
 			}
 		}

 		Collection values = mapOfLetters.values();	// generate a collection of the values (from Key-Value pair)

 		int numOfOddCharacters = 0;	// keep a count of the leftover chars
 		
 		for(Object element : values) {
 			if(Integer.parseInt(element.toString())%2 == 1) {	// if odd number of letters, add one to count
 				numOfOddCharacters++;
 			}
 		}

 		System.out.println(numOfOddCharacters < 2); // impossible to create a palindrome if there is more than 1
 	}
 }