
 import java.io.*;
 import java.net.*;
public class Server1
{
 
    private static Socket socket;
 
    public static void main(String[] args) throws Exception
    {
       // try
//        {
 
            int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");
			
 socket = serverSocket.accept();
	int nof=split.getnof();
for(int i=1;i<=nof;i++){	
		 byte[] mybytearray = new byte[4096];
    //ArrayList<byte> mybytearray = new ArrayList<byte>();
	InputStream is = socket.getInputStream();
    FileOutputStream fos = new FileOutputStream("./SFile"+i+".txt");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    int bytesRead = is.read(mybytearray, 0, mybytearray.length);
	//fos.write(mybytearray, 0, bytesRead);
   // bos.write("success");
	bos.write(mybytearray, 0, bytesRead);
    //bos.flush();
	bos.close();
	
	//bw.write("");
    System.out.println("File "+i+" is successful");
    //bw.flush();
          
}
		
	//}
	/*catch (Exception e)
        {
            e.printStackTrace();
        }
		socket.close();
      /*  finally
        {
            try
            {
                socket.close();
            }
            catch(Exception e){}
        }*/
    }
}