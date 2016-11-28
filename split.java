import java.io.*;
import java.util.Scanner;


public class split {

static int nof;

public static void split1() throws IOException 

{	
BufferedWriter out = null;
 try{

 		nof=0;					 // Reading file and getting no. of files to be generated
  String inputfile = "./test.txt";			 //  Source File Name.
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


   FileWriter fstream1 = new FileWriter("./File"+j+".txt");     // Destination File Location
 
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
  
  scanner.close();

 }
 
 
 catch (Exception e){ out.close(); System.out.println("File-split successful"); }
 
 
 /*finally{
	 try{
	 MergerFiles merge=new MergerFiles();
	 merge.merge(nof);
	 Validate v1 = new Validate();
	 v1.fileRead();
	
	 }
	 catch(Exception g){ System.out.println("Problem in calling fileRead"); g.printStackTrace();}
 }*/

}
public static int getnof(){
	return nof;
}
} 
