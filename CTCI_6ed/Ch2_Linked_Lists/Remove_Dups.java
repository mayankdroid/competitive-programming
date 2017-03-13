/*
 Write code to remove duplicates from an unsorted linked list.
 FOLLOW UP
 How would you solve this problem if a temporary buffer is not allowed?
*/

import java.io.*;
import java.util.*;

class Remove_Dups {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.add(5);
		list.add(6);
		list.add(1);
		list.add(3);
		list.add(7);
		list.add(6);
		list.add(4);
		list.add(0);
		list.add(6);
		list.add(5);
		list.add(1);
		list.add(2);

		System.out.println("LinkedList(Prior to Remove_Dups): " + list);
		// Finished generating LinkedList with duplicates

		for(int i=0; i < list.size(); i++) {
			Object item = list.get(i);

			while(list.indexOf(item) != list.lastIndexOf(item)) {	// iterates through LinkedList checking for matching index
				list.removeLastOccurrence(item);	// removes last occurence of item from LinkedList
			}
		}

		System.out.println("LinkedList(After Remove_Dups): " + list);
		// Finished removing duplicates from LinkedList
	}
}