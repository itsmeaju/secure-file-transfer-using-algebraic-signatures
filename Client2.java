import java.io.*;
import java.net.*;
import java.util.*;
import java.security.NoSuchAlgorithmException;
public class Client2{

    private static Socket socket1;
	
	public static void main2()throws Exception{
	 int port1 = 2500;
	 			String host = "localhost";

            InetAddress address1 = InetAddress.getByName(host);
            socket1 = new Socket(address1, port1);	
			fileRead();
			File myFile1 = new File("./testsign1.txt");
			
			
			BufferedOutputStream bos1 = new BufferedOutputStream(socket1.getOutputStream());
			DataOutputStream dos1 = new DataOutputStream(bos1);

			long length = myFile1.length();
			dos1.writeLong(length);
		
			String name = myFile1.getName();
			dos1.writeUTF(name);

			FileInputStream fis1 = new FileInputStream(myFile1);
			BufferedInputStream bis1 = new BufferedInputStream(fis1);

			int theByte = 0;
			while((theByte = bis1.read()) != -1) bos1.write(theByte);

			bis1.close();


			dos1.close();
		}

	public static void fileRead() throws NoSuchAlgorithmException, IOException, InterruptedException {
			File testfile = new File("./test.txt");
			RSA_2048 rsa1=new RSA_2048();
			Scanner sc = new Scanner(testfile);
			while(sc.hasNextLine()){
        	 
					File opfile = new File("./testsign1.txt");     // Destination File Location
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
		 
			
		}
}		