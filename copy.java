import java.io.*;
public class copy{

public void copyFile(InputStream in, OutputStream out) throws IOException{
	System.out.println("inside copy");
byte[] buf = new byte[8192];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }


}
}