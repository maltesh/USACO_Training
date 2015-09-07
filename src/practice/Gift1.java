/*
ID: zizou5m1
LANG: JAVA
TASK: gift1
*/
package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class Gift1 {
    private static final String filePath = "C:\\Users\\sg1852\\Documents\\NetBeansProjects\\files\\gift.in";
    private static HashMap<String,Integer> giftGiven = new HashMap<String,Integer>();
    private static HashMap<String,Integer> giftsReceived = new HashMap<String,Integer>();
    private static HashMap<String,Integer> balanceLeftOver = new HashMap<String,Integer>();
    public static void main(String[] args) {
        List<String> allMembers  = new ArrayList<String>();
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
                System.out.println(name.split(",").length);
                if(name.split(",").length <= 1)
                {
                    
                    String nextLine       = file.readLine();
                    String [] nos         = nextLine.split(" ");
                    int totalPplReceiving = Integer.parseInt ( nos[1] );
                    int totalAmount       = Integer.parseInt(nos[0]);
                    giftGiven.put(name, totalAmount);
                    int amountReceived    =  (totalPplReceiving>0)?totalAmount/totalPplReceiving:0;
                    System.out.println(amountReceived);
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
            System.out.println(giftGiven);
            System.out.println(giftsReceived);
            System.out.println(balanceLeftOver);
            
            for(String str :allMembers)
            {
                int gvn  = ( giftGiven.containsKey(str) )? giftGiven.get(str):0;
                int rcvd = ( giftsReceived.containsKey(str) )? giftsReceived.get(str):0;
                int blnc = ( balanceLeftOver.containsKey(str) )? balanceLeftOver.get(str):0;
                int leftOver = rcvd+blnc-gvn;
                System.out.println(str + " " + leftOver );
            }
            System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println(" Exception");
            System.out.println(e.getMessage());
        }
        
    }
}
