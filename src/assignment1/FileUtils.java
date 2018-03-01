package assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {
	
	private String fileName;
	private String path;
	
	public static void saveFileContents(File f, ArrayList<String> ar) throws IOException {
		   FileWriter writer = new FileWriter(f); // https://stackoverflow.com/questions/6548157/how-to-write-an-arraylist-of-strings-into-a-text-file
	    	for(String str: ar) {
	          writer.write(str);
	    	  writer.write(System.getProperty( "line.separator" ));}
	    	
	    	writer.close();
	   	}
	
	public static  ArrayList<String> getFileContentsASArrayList(File f) {
		Scanner s;
		ArrayList<String> input = new ArrayList<String>();
		try {
			s = new Scanner(f);
			while (s.hasNext()){
			    input.add(s.next());
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         // LAB - 6
		return input;
	}
	
	public static boolean fileExists(File f) {
		if(f.exists()&&f.isFile()) {
			return true;
		}
		return false;
	}
	
	public static boolean fileExists(String s) {
		return true;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setPath(String s) {
		this.path = s;
	}
	
	public void setFileName( String s) {
		this.fileName = s;
	}    
}
