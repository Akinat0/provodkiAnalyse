package refactored;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class FileManager {

	File file;
	
	
	public FileManager(String path) {
		file = new File(path);
		if(!file.exists() && file.isFile()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				Debug.log("There is a kind of problems linked with file " + file.getPath());
				e.printStackTrace();}
			}
	}
	
	
	
	public boolean edit() {
		try {
			//Opening file through the NotePad 
			ProcessBuilder pb = new ProcessBuilder("Notepad.exe", file.getPath());
			pb.start();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
