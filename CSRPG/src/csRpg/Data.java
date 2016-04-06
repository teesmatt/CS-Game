package csRpg;

import java.util.ArrayList;
import java.io.*;


public class Data {
	private ArrayList<Character> chars; 
	public Data() {
		loadSaves();
	}
	private void loadSaves(){
		File f = new File("/Saves/saves.ser");
		if (f.exists()){
			try {
				FileInputStream fileIn = new FileInputStream("/Saves/save.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				chars = (ArrayList<Character>) in.readObject();
				
			} catch (IOException i){
				i.printStackTrace();
		        return;
			} catch(ClassNotFoundException c)
		      {
		         System.out.println("Saves not found");
		         c.printStackTrace();
		         return;
		      }
		} else {
			this.chars = new ArrayList<Character>();
		}
	}
	public void saveChar(Character c) {
		chars.add(c);
		try {
			FileOutputStream saves = new FileOutputStream("./Saves/save.ser");
			System.out.println(saves.toString());
			ObjectOutputStream out = new ObjectOutputStream(saves);
	        out.writeObject(chars);
	        out.close();
	        saves.close();
		} catch (IOException i){
			i.printStackTrace();
	        return;
		}
	}
	public void loadChar(int index){
		chars.get(index);
	}
}
