import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AppleOrange {

    public static void main(String[] args) {
    	String file = "C:/Users/Pritpal/Desktop/b.txt";
    	try{
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String[] ss = in.readLine().split("\\s+");
	        int s = Integer.parseInt(ss[0]);
	        int t = Integer.parseInt(ss[1]);
	        
	        ss = in.readLine().split("\\s+");
	        int a = Integer.parseInt(ss[0]);
	        int b = Integer.parseInt(ss[1]);

	        ss = in.readLine().split("\\s+");
	        int m = Integer.parseInt(ss[0]);
	        int n = Integer.parseInt(ss[1]);
	        
	        int[] apple = new int[m];
	        for(int apple_i=0; apple_i < m; apple_i++){
	            apple[apple_i] = in.read();
	        }
	        int[] orange = new int[n];
	        for(int orange_i=0; orange_i < n; orange_i++){
	            orange[orange_i] = in.read();
	        }
	        int appleCount = 0;
	        for(int i : apple){
	            int d = i + a;
	            if(d >= s && d<= t){
	                appleCount++;
	            }
	        }
	        System.out.println(appleCount);
	        int orangeCount = 0;
	        for(int i : orange){
	            int d = i + a;
	            if(d >= s && d<= t){
	                orangeCount++;
	            }
	        }
	        System.out.println(orangeCount);
    	}
    	catch(Exception ex){
    		System.out.println(ex.getMessage());
    	}
    }
    
    static <T extends Comparable<T>> void print(T msg){
    	System.out.println(msg);
    }
}
