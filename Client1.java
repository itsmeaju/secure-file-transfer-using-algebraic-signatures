/*working client program*/

/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
*/
import java.io.*;
import java.net.*;


public class Client1
{
 
    private static Socket socket;
 
    public static void main(String args[])
    {
       
	try
        {
            String host = "localhost";
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
			split.split1();
			int nof=split.getnof();
			for(int i=1;i<=nof;i++){
				File myFile = new File("./File"+i+".txt");
			while (true) {
      
				byte[] mybytearray = new byte[4096];
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
				bis.read(mybytearray, 0, mybytearray.length);
				OutputStream os = socket.getOutputStream();
				os.write(mybytearray, 0, mybytearray.length);
				os.flush();
     // socket.close();
			}
		}
		
        //}
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
		
		
        finally
        {
            //Closing the socket
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}