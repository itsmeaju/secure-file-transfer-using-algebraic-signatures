import java.io.*;
import java.net.*;
import java.util.*;
import java.security.NoSuchAlgorithmException;

public class Client1
{
 
    private static Socket socket;

    public static void main1()throws Exception
    {
       
	
			String host = "localhost";
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
			split.split1();
			int nof=split.getnof();
			File[] files = new File[nof];
			for(int i=1;i<=nof;i++){
					File myFile = new File("./File"+i+".txt");
					files[i-1]=myFile;
			}
			


			BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
			DataOutputStream dos = new DataOutputStream(bos);

			dos.writeInt(files.length);

			for(File file : files)
			{
				long length = file.length();
				dos.writeLong(length);

				String name = file.getName();
				dos.writeUTF(name);

				FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);

				int theByte = 0;
				while((theByte = bis.read()) != -1) bos.write(theByte);

				bis.close();
			}

			dos.close();
			
		}			

}
