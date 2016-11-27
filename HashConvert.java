import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class HashConvert{

public void fileRead(int nof) throws FileNotFoundException,IOException,NoSuchAlgorithmException{
	
	System.out.println("I'm in fileRead");
	for(int j=1;j<=nof;j++){
		System.out.println("I'm j="+j);
		String file = "src\\File"+j+".txt";
		try{
		MessageDigest md = MessageDigest.getInstance("MD5");
		String digest = getDigest(new FileInputStream(file), md, 2048);

		System.out.println("MD5 Digest:" + digest);
		FileWriter fstream2 = new FileWriter("src/HashFile"+j+".txt");     // Destination File Location
		BufferedWriter out = new BufferedWriter(fstream2); 
		out.write(digest);
		out.close();
		}
		catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		catch(NoSuchAlgorithmException nsae){
			nsae.printStackTrace();
		}
		
	}
}
public static String getDigest(InputStream is, MessageDigest md, int byteArraySize)
			throws NoSuchAlgorithmException, IOException {
		System.out.println("I'm in getDigest");
		md.reset();
		byte[] bytes = new byte[byteArraySize];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			md.update(bytes, 0, numBytes);
		}
		byte[] digest = md.digest();
		String result =bytesToHex(digest);
		return result;
	}
	/*private static String bytesToString(byte[] encrypted) {
            String test = "";
            for (byte b : encrypted) {
                test += Byte.toString(b);
            }
            return test;
        }*/
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}


}


/*


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//import org.apache.commons.codec.binary.Hex;

public class MessageDigestForFile {

	public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException, IOException {

		String file = ".\\hello.txt";
		MessageDigest md = MessageDigest.getInstance("MD5");
		String digest = getDigest(new FileInputStream(file), md, 2048);

		System.out.println("MD5 Digest:" + digest);

	}

	public static byte[] getDigest(InputStream is, MessageDigest md, int byteArraySize)
			throws NoSuchAlgorithmException, IOException {

		md.reset();
		byte[] bytes = new byte[byteArraySize];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			md.update(bytes, 0, numBytes);
		}
		byte[] digest = md.digest();
		//String result = new String(Hex.encodeHex(digest));
		return digest;
	}

}
*/