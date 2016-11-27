import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class split {


public static void main(String args[]) throws IOException 

{	int nof=0;
BufferedWriter out = null;
 try{

 							 // Reading file and getting no. of files to be generated
  String inputfile = "src/test.txt";			 //  Source File Name.
  double nol = 5.0;					 //  No. of lines to be split and saved in each output file.
  File file = new File(inputfile);
  Scanner scanner = new Scanner(file);
  int count = 0;
  while (scanner.hasNextLine()) 
  {
   scanner.nextLine();
   count++;
  }
  System.out.println("Lines in the file: " + count);     // Displays no. of lines in the input file.

  double temp = (count/nol);
  int temp1=(int)temp;
  
  if(temp1==temp)
  {
   nof=temp1;
  }
  else
  {
   nof=temp1+1;
  }
  System.out.println("No. of files to be generated :"+nof); // Displays no. of files to be generated.
 
  //---------------------------------------------------------------------------------------------------------

  // Actual splitting of file into smaller files

  FileInputStream fstream = new FileInputStream(inputfile);

  DataInputStream in = new DataInputStream(fstream);

  BufferedReader br = new BufferedReader(new InputStreamReader(in)); 

  String strLine;
	
RSA_2048 rsa1=new RSA_2048();
 
  for (int j=1;j<=nof;j++)
  {


   FileWriter fstream1 = new FileWriter("src/File"+j+".txt");     // Destination File Location
 
    out = new BufferedWriter(fstream1); 
 
   for (int i=1;i<=nol;i++)
   {
    strLine = br.readLine(); 


//*********************ENCRYPTION SHOULD BE DONE HERE****************************************************************************//




    if (!strLine.trim().isEmpty())
    {	
	
     out.write(rsa1.convertString(strLine)); 
     if(i!=nol)
     {
      out.newLine();
     }
    }
   }
   out.close();
  }

  in.close();
  
  

 }
 
 catch (Exception e)
 {
	 out.close();
  System.err.println("Error: " + e.getMessage());
e.printStackTrace();


 }
 
 
 finally{
	 try{
	 HashConvert hashc1 = new HashConvert();
	 hashc1.fileRead(nof);
	 MergerFiles merge=new MergerFiles();
	 merge.merge(nof);
	 xorHex xor=new xorHex();
	 xor.fileXor(nof);
	 }
	 catch(Exception g){ System.out.println("Probliem in calling fileRead"); g.printStackTrace();}
 }

}

} 
