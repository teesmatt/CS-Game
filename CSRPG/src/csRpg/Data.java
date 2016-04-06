package csRpg;

import java.util.ArrayList;
import java.io.*;


public class Data {
	private ArrayList<Character> chars; 
	public Data() {
		loadSaves();
	}
	private void loadSaves(){
		File f = new File("./Saves/save.ser");
	
		System.out.println(f.toString());
		if (f.exists()){
			try {
				System.out.println("found file trying to load");
				FileInputStream fileIn = new FileInputStream("./Saves/save.ser");
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
			System.out.println("no saves found");
			this.chars = new ArrayList<Character>();
		}
	}
	public void saveChar(Character c) {
		System.out.println("Saving ID: " + Game_Controller.cur_player);
		System.out.println("Cur size:" + chars.size());
		if (Game_Controller.cur_player < chars.size()){
			System.out.println("Replacing Save");
			chars.remove(Game_Controller.cur_player);
			chars.add(c);
		} else {
			System.out.println("New Save");
			chars.add(c);
		}
		
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
	public ArrayList<Character> getCharList(){
		return this.chars;
	}
	public void loadChar(int index){
		chars.get(index);
	}
	public int getNextIndex(){
		return chars.size();
	}
}
