import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import java.util.zip.CRC32;

public class CRCHash {
	

   public static long checksumInputStream(String filepath) throws IOException {
	   InputStream inputStreamn = new FileInputStream(filepath);
	   CRC32 crc = new CRC32();
	   int cnt;
	   while ((cnt = inputStreamn.read()) != -1) {
		   crc.update(cnt);
	   }
	   inputStreamn.close();
	   return crc.getValue();
   }
   
   public static long checksumBufferedInputStream(String filepath) throws IOException {
	   InputStream inputStream = new BufferedInputStream(new FileInputStream(filepath));
	   CRC32 crc = new CRC32();
	   int cnt;
	   while ((cnt = inputStream.read()) != -1) {
		   crc.update(cnt);
	   }
	   inputStream.close();
	   return crc.getValue();
   	}

   public static long checksumRandomAccessFile(String filepath) throws IOException {
	   RandomAccessFile randAccfile = new RandomAccessFile(filepath, "r");
	   long length = randAccfile.length();
	   CRC32 crc = new CRC32();
	   for (long i = 0; i < length; i++) {
		   randAccfile.seek(i);
		   int cnt = randAccfile.readByte();
		   crc.update(cnt);
	   }
	   randAccfile.close();
	   return crc.getValue();
   }
   public static long checksumMappedFile(String filepath) throws IOException {
	   FileInputStream inputStream = new FileInputStream(filepath);
	   FileChannel fileChannel = inputStream.getChannel();
	   int len = (int) fileChannel.size();
	   MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, len);
	   CRC32 crc = new CRC32();
	   for (int cnt = 0; cnt < len; cnt++) {
		   int i = buffer.get(cnt);
		   crc.update(i);

	   }
	   inputStream.close();
	   return crc.getValue();
   	}
   public static String getDigest(String is) throws IOException {
	   long crc = checksumInputStream(is);
	   return Long.toHexString(crc);
	}
}

