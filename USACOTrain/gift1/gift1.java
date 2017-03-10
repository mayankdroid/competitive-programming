/*
ID: Wilson Ding
LANG: JAVA
PROG: gift1
*/

import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());

    LinkedHashMap gifts = new LinkedHashMap();  // LinkedHashMap to store Key/Value pairs in order

    int numOfNames = Integer.parseInt(st.nextToken());  // get number of names

    for(int i = 0; i < numOfNames; i++) { // iterate through all names and add to LinkedHashMap
      gifts.put(f.readLine(), 0);
    }

    String currentName = "";
    int payment = 0;
    int numOfPayees = 0;
    String payeeName = "";

    while((currentName = f.readLine()) != null) { // if there is another set of data, set currentName to payer
      st = new StringTokenizer(f.readLine());

      payment = Integer.parseInt(st.nextToken()); // get payment ammount
  
      numOfPayees = Integer.parseInt(st.nextToken()); // get number of payees

      if(numOfPayees != 0) {  // check for 0 payees
        payment = payment - (payment%numOfPayees);  // remove the remainder from the payment

        gifts.put(currentName, ((int)gifts.get(currentName) - payment)); // subtract payment from currentName

        for(int i = 0; i < numOfPayees; i++) {
          payeeName = f.readLine(); // iterate through the number of payees and get name
          gifts.put(payeeName, ((int)gifts.get(payeeName) + (payment/numOfPayees))); // add payment/numOfPayees to payee
        }
      }
    };

    Set<String> namesInGifts = gifts.keySet();  // get all Keys from gifts

    for(String name : namesInGifts){
      out.println(name + " " + gifts.get(name)); // iterate through each name and output to file
    }

    out.close();
  }
}
