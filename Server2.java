import java.io.*;
import java.net.*;
public class Server2
{
 
    private static Socket socket1;
 
    public static void main(String[] args) throws Exception{
 
int port = 2500;
            ServerSocket serverSocket1 = new ServerSocket(port);
Socket socket1 = serverSocket1.accept();

BufferedInputStream bis1 = new BufferedInputStream(socket1.getInputStream());
DataInputStream dis1 = new DataInputStream(bis1);

//int filesCount = dis1.readInt();
File[] files = new File[1];

for(int i = 0; i < 1; i++)
{
    long fileLength = dis1.readLong();
    String fileName = dis1.readUTF();

    files[i] = new File("Server2_copy" + "/" + fileName);
//files[i] = new File(fileName);
    FileOutputStream fos1 = new FileOutputStream(files[i]);
    BufferedOutputStream bos1 = new BufferedOutputStream(fos1);

    for(int j = 0; j < fileLength; j++) bos1.write(bis1.read());

    bos1.close();
}

dis1.close();
System.out.println("Hash of the main tag...");
CRCHash c1=new CRCHash();
System.out.println(c1.getDigest("testsign1.txt"));
    }



	}