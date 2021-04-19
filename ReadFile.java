import java.util.*;
import java.io.*;

public class ReadFile{

    public static void main(String args[]){

        try{
            //                                System.in                     
            Reader in = new InputStreamReader(new FileInputStream(new File("ReadFile.java")));

            //Scanner sc = new Scanner(in);
            //Scanner sc = new Scanner(new File("ReadFile.java"));

            BufferedReader bin = new BufferedReader(in);

            LineNumberReader lin = new LineNumberReader(bin);
            
            while(true){
                try{
                    // byte b[] = new byte[1];

                    // //returns the number of bytes read
                    // if(in.read(b) == 0) break;
                    // if(b[0] == 0) break;

                    // int radix = in.read();
                    // if(radix < 0) break;
                    // char c = Character.toChars(radix)[0];
                    // System.out.printf("%c ",c);

                    // if(!sc.hasNext()) break;
                    // String word = sc.next();
                    // System.out.printf("%s ", word);

                    String line = lin.readLine();
                    if(line == null) break;
                    System.out.println(""+lin.getLineNumber()+": "+line);
                    
                }catch(Exception e){ break;}
            }            
        }catch(Exception e){}

        System.out.println();
    }
}
