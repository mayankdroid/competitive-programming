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

    HashMap gifts = new HashMap();

    int numOfNames = Integer.parseInt(st.nextToken());

    String[] nameList = new String[numOfNames];

    String name = "";

    for(int i = 0; i < numOfNames; i++) {
      name = f.readLine();
      gifts.put(name, 0);
      nameList[i] = name;
    }

    String currentName = "";
    int payment = 0;
    int numOfPayees = 0;
    String payeeName = "";

    while((currentName = f.readLine()) != null) {
      st = new StringTokenizer(f.readLine());

      payment = Integer.parseInt(st.nextToken());
  
      numOfPayees = Integer.parseInt(st.nextToken());

      if(numOfPayees != 0) {
        payment = payment - (payment%numOfPayees);

        gifts.put(currentName, ((int)gifts.get(currentName) - payment));

        for(int i = 0; i < numOfPayees; i++) {
          payeeName = f.readLine();
          gifts.put(payeeName, ((int)gifts.get(payeeName) + (payment/numOfPayees)));
        }
      }
    };

    for(String eachName : nameList){
      out.println(eachName + " " + gifts.get(eachName));
    }

    out.close();
  }
}
