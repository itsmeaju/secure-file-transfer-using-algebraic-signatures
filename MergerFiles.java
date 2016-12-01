import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class MergerFiles {
 
	public void merge(int nof) throws IOException {
	File[] files = new File[nof];
		for(int i=1;i<=nof;i++){
			String str="./File"+i+".txt";
			files[i-1]=new File(str);
		}
		String mergedFilePath = "./pcsfile.txt";
 		File mergedFile = new File(mergedFilePath);
 		mergeFiles(files, mergedFile);
 		
	}
 
	public void mergeFiles(File[] files, File mergedFile) {
 
		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			 out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
 
		for (File f : files) {
			//System.out.println("Merging: " + f.getName());
			//System.out.println();
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
				String aLine;
				while ((aLine = in.readLine()) != null) {
					out.write(aLine);
					out.newLine();
				}
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
}