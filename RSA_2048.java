import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * Created by Baby on 8/27/2016.
 */


public class RSA_2048 {

        private BigInteger p;
        private BigInteger q;
        private BigInteger N;
        private BigInteger phi;
        private BigInteger e;
        private BigInteger d;
     
        public RSA_2048() throws FileNotFoundException {
            File pfile = new File("./p-file.txt");
            Scanner sc = new Scanner(pfile);
		     while(sc.hasNextLine()){
                p= new BigInteger(sc.nextLine());
            }
            File qfile = new File("./q-file.txt");
            Scanner sc2 = new Scanner(qfile);
            while(sc2.hasNextLine()){
                q= new BigInteger(sc2.nextLine());
            }
            N = p.multiply(q);
            phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
            //e = BigInteger.probablePrime(1024, r);
            Integer myint = new Integer(7);
            e =BigInteger.valueOf(myint.intValue());
            while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0 ) {
                e.add(BigInteger.ONE);
            }
            d = e.modInverse(phi);
            sc.close();
            sc2.close();
        }

      

        
	public String convertString(String str){

            //System.out.println("Encrypting String: " + str);
            // System.out.println("String in Bytes: " + bytesToString(str.getBytes()));

            // encrypt
            byte[] encrypted = this.encrypt(str.getBytes());
            return bytesToString(encrypted);

            // decrypt
            // byte[] decrypted = this.decrypt(encrypted);
            // System.out.println("Decrypted String in Bytes: " +  bytesToString(decrypted));
            //  System.out.println("Decrypted String: " + new String(decrypted));

		
		}

        private static String bytesToString(byte[] encrypted) {
            String test = "";
            for (byte b : encrypted) {
                test += Byte.toString(b);
            }
            return test;
        }

        //Encrypt message
        public byte[] encrypt(byte[] message) {
            return (new BigInteger(message)).modPow(e, N).toByteArray();
        }

        // Decrypt message
        public byte[] decrypt(byte[] message) {
            return (new BigInteger(message)).modPow(d, N).toByteArray();
        }
}