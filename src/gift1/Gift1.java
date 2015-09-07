/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gift1;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.stream.Stream;

public class Gift1 {
    private static final String filePath = "C:\\Users\\sg1852\\Documents\\NetBeansProjects\\files\\gift.in";
    public static void main(String[] args) {
        try
        {
            BufferedReader file = new BufferedReader(new FileReader(filePath));
            String currentLine="";
//            Stream<String> lines = file.lines() ;
//            Iterator it = lines.iterator();
//            while(it.hasNext())
//            {
               // System.out.println(it.next());
//            }
//            String np = file.readLine();
//            System.out.println(np);
            while((currentLine=file.readLine())!=null)
            {
                System.out.println(" ==== " + currentLine);
//                System.out.println(currentLine);
            }
        }
        catch(Exception e)
        {
            System.out.println(" Exception");
            System.out.println(e.getMessage());
        }
        
    }
}

