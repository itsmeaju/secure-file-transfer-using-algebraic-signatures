import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class Validate {
	public void fileRead() throws NoSuchAlgorithmException, IOException, InterruptedException {
	     File testfile = new File("src/test.txt");
	     RSA_2048 rsa1=new RSA_2048();
		 Scanner sc = new Scanner(testfile);
		 while(sc.hasNextLine()){
        	 
        	File opfile = new File("src/testsign.txt");     // Destination File Location
        	String strLine = sc.nextLine();
        	
        	FileWriter fstream = null;
    		BufferedWriter out = null;
    		try {
    			fstream = new FileWriter(opfile, true);
    			 out = new BufferedWriter(fstream);
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		
    		//append start
    			
    		try{
    			out.write(rsa1.convertString(strLine));
    			out.newLine();
    		}
    		catch(Exception e){	}
    		
     		try {
    			out.close();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
     		
        	//append end
        }	
		 
		System.out.print("Validating.");
		Thread.sleep(1000);
		System.out.print("..");
		Thread.sleep(1000);
		System.out.println("....");
		Thread.sleep(1000);
        String digest = CRCHash.getDigest("src/testsign.txt");
 		System.out.println("Total CRC before:" + digest);
 	
		
		String digest3 = CRCHash.getDigest("src/pcsfile.txt");
 		System.out.println("Total CRC After:"+ digest3);
 		//System.out.println("YAYY!");
 		sc.close();
	}
}
