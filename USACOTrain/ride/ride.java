/*
ID: Wilson Ding
LANG: JAVA
PROG: ride
*/

import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

    if(getTotalValueOf(f.readLine())%47 == getTotalValueOf(f.readLine())%47) { // if the two %47 are equal
      out.println("GO");
    } else {
      out.println("STAY");
    }

    out.close();  // close the output file
  }

  public static int getTotalValueOf(String line) {
    int totalValue = 1;

    for(int i = 0; i < line.length(); i++) { // iterating through each char in the string
      char c = line.charAt(i);
      int asciiValue = (int)c - 64; // converting char to ascii value (subtracting 64 as A starts at 65)
      totalValue *= asciiValue; // multiplying all ascii values together
    }

    System.out.println(totalValue);

    return totalValue;
  }
}
