/*
ID: zizou5m1
LANG: JAVA
TASK: gift1
*/
package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class Gift1 {
    private static final String filePath = "C:\\Users\\sg1852\\Documents\\NetBeansProjects\\files\\gift.in";
    private static HashMap<String,Integer> giftGiven = new HashMap<String,Integer>();
    private static HashMap<String,Integer> giftsReceived = new HashMap<String,Integer>();
    private static HashMap<String,Integer> balanceLeftOver = new HashMap<String,Integer>();
    public static void main(String[] args) throws IOException {
        List<String> allMembers  = new ArrayList<String>();
        PrintWriter out  = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\sg1852\\Desktop\\test.out")));
        try
        {
            BufferedReader file = new BufferedReader(new FileReader(filePath));
            String currentLine="";
            //First Lines
            String fl = file.readLine();
            int count = Integer.parseInt(fl);
            for( int i =0 ;i<count ;i++)
            {
                allMembers.add(file.readLine());
            }
            while((currentLine=file.readLine())!=null)
            {
                String name = currentLine;
                if(name.split(",").length <= 1)
                {
                    String nextLine       = file.readLine();
                    String [] nos         = nextLine.split(" ");
                    int totalPplReceiving = Integer.parseInt ( nos[1] );
                    int totalAmount       = Integer.parseInt(nos[0]);
                    giftGiven.put(name, totalAmount);
                    int amountReceived    =  (totalPplReceiving>0)?totalAmount/totalPplReceiving:0;
                    balanceLeftOver.put(name, totalAmount-amountReceived*totalPplReceiving);
                    for(int j =0 ;j<totalPplReceiving ; j++)
                    {
                        String entry = file.readLine();
                        if(!giftsReceived.containsKey(entry))
                            giftsReceived.put(entry, amountReceived);
                        else {
                            giftsReceived.put(entry, giftsReceived.get(entry)+ amountReceived);
                        }
                    }
                }
            }
            for(String str :allMembers)
            {
                int gvn  = ( giftGiven.containsKey(str) )? giftGiven.get(str):0;
                int rcvd = ( giftsReceived.containsKey(str) )? giftsReceived.get(str):0;
                int blnc = ( balanceLeftOver.containsKey(str) )? balanceLeftOver.get(str):0;
                int leftOver = rcvd+blnc-gvn;
                out.println(leftOver);
            }
            out.close();
            System.exit(0);
        }
        catch(Exception e)
        {
        }
    }
}
