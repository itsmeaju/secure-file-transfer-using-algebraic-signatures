import java.util.*;
import java.io.*;

public class hashCalculate{
	private static int k;
	private static int j;
	
	public void hashPro(String Hello) throws IOException{
	
	HashMap h1 = new HashMap();
	
	
	h1.put(Hello, new Double(k++));
	
	Set set = h1.entrySet();
	
	Iterator it1 = set.iterator();
	 while(it1.hasNext()) {
        Map.Entry me = (Map.Entry)it1.next();
		FileWriter fstream = new FileWriter("./HashFile"+j+".txt");     // Destination File Location
		j++;
		BufferedWriter out = new BufferedWriter(fstream); 
		out.write(me.getKey().toString()); 
        // System.out.print(me.getKey() + ": ");
        // System.out.println(me.getValue());
      }
	
	}
}