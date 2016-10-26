/*
 * Execution: java Chopper <embl filename (without .embl)> <source directory>
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Chopper {
	public static void main(String[] args) {
		BufferedReader breader = null;
		File file;
		FileWriter fwriter;
		BufferedWriter bwriter;
		String sCurrentLine, piece;
		String name = args[0];
		String dir = args[1];
		try {
			file = new File(dir+"\\"+name);
			file.mkdirs();
			breader = new BufferedReader(new FileReader(dir + "\\"+name+".embl"));
			while ((sCurrentLine = breader.readLine()) != null) {
				if (sCurrentLine.charAt(0)=='I') {
					piece = sCurrentLine.substring(sCurrentLine.indexOf("P"), sCurrentLine.indexOf(";")-1);
					file = new File(dir+"\\"+name+"\\"+piece+".embl");
					file.createNewFile();
					fwriter = new FileWriter(file.getAbsoluteFile());
					bwriter = new BufferedWriter(fwriter);
					while (sCurrentLine.charAt(0)!='/') {
						bwriter.write(sCurrentLine);
						bwriter.newLine();
						sCurrentLine = breader.readLine();
					}
					bwriter.write(sCurrentLine);
					bwriter.close();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (breader != null) breader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

