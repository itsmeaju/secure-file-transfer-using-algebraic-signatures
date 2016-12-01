import java.io.*;
import java.net.*;
public class Server1
{
 
    private static Socket socket;
 
    public static void main(String[] args) throws Exception
    {
       

	int port = 25000;
    ServerSocket serverSocket = new ServerSocket(port);
	Socket socket = serverSocket.accept();

	BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
	DataInputStream dis = new DataInputStream(bis);

	int filesCount = dis.readInt();
	File[] files = new File[filesCount];

	for(int i = 0; i < filesCount; i++){
		long fileLength = dis.readLong();
		String fileName = dis.readUTF();
		files[i] = new File("Server1_copy" + "/" + fileName);
		FileOutputStream fos = new FileOutputStream(files[i]);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		for(int j = 0; j < fileLength; j++) bos.write(bis.read());
		bos.close();
	}

	dis.close();
	System.out.println("Summing the tags");
	System.out.println();
	MergerFiles mer=new MergerFiles();
	mer.merge(filesCount);
	System.out.println("Hash of the sum of tags....");
	System.out.println();
	CRCHash c=new CRCHash();
	System.out.println(c.getDigest("./pcsfile.txt"));
    }
}