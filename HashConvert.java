import java.io.*;
import java.util.*;


public class HashConvert{

private String str;

public void fileRead(int nof) throws FileNotFoundException,IOException{
	hashCalculate HC1 = new hashCalculate();
	
	for(int j=0;j<nof;j++){
		
		Scanner sc1 = new Scanner(new File("./File"+j+".txt"));
		str=sc1.nextLine();	
		HC1.hashPro(str);
		
	}
}


}