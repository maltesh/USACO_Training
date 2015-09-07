/*
ID: zizou5m1
LANG: JAVA
TASK: ride
*/
package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Ride {

    private final static String filePath = "C:\\Users\\sg1852\\Desktop\\input.in";

    public static void main(String[] args)  {
        List<Integer> ansList= new ArrayList<Integer>();
        try {
            BufferedReader f = new BufferedReader(new FileReader(filePath));
            PrintWriter out  = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\sg1852\\Desktop\\test.out")));
            String currentLine;
            while((currentLine =f.readLine())!=null)
            {
                int product=1;
                for(int i =0;i<currentLine.length();i++)
                {
                    char c = currentLine.charAt(i);
                    int temp = (int)c;
                    int temp_integer = 64;
                    if(temp <=90 && temp >=65)
                    {
                        product *=temp-temp_integer;
                    }
                }
                ansList.add(product%47);
            }
            System.out.println(ansList);
            if(ansList.get(0) == ansList.get(1))
            {
                out.println("GO");
            }
            else{
                out.println("STAY");
            }
            out.close();
//            System.exit(0);       
        }
        catch(Exception e)
        {}
        finally
        {}
        System.out.println("===============");
        Gift1 ft = new Gift1();
        
    }
    
}
