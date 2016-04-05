package csRpg;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game_Controller extends StateBasedGame {

	public static final int windowWidth = 1366;
	public static final int windowHeight = 768;
	public static boolean fullScreen = false;
	
	public static final int TitleId = 0;
	public static final int Character_CreationId = 1;
	public static final int MapID = 2;
	
	// The ID for each room in the map
	public static final int ClassID = 3;
	public static final int LoungeID = 4;
	public static final int PubID = 5;
	public static final int BussinessID = 6;
	public static final int LibraryID = 7;
	public static final int MathID = 8;
	
	public static final int LoadSavesID = 69;
	
	public static Character player;
	
	public Game_Controller(String name) {
		
		super(name);
		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
	
		this.addState(new Title_Menu());
		this.addState(new Character_Creation());
		this.addState(new Map());
<<<<<<< HEAD


		// adds each room to the game






		// adds each room to the game
		this.addState(new LoadSaves());

		this.addState(new Room("/assets/ClassroomLounge.png",ClassID,"button_smash"));

=======

		// adds each room to the game
		this.addState(new LoadSaves());

		this.addState(new Room("/assets/ClassroomLounge.png",ClassID,"button_smash"));
>>>>>>> 0a9e93a64999cd84840a192cd0ad6f06e9bda503
		this.addState(new Room("/assets/ClassroomLounge.png",LoungeID,""));
		this.addState(new Room("/assets/Pub.png",PubID,"Beer_Minigame"));
		this.addState(new Room("/assets/Bussiness.png",BussinessID,"buis_visit"));
		this.addState(new Room("/assets/Library.png",LibraryID,"library_adventure"));
<<<<<<< HEAD

=======
>>>>>>> 0a9e93a64999cd84840a192cd0ad6f06e9bda503
		this.addState(new Room("/assets/Math.png",MathID,"mathGame"));

		this.addState(new Highscores());
		
		
	}
	
	public int getWidth() {
		return windowWidth;
	}
	
	public int getHeight() {
		return windowHeight;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			AppGameContainer mainWindow = new AppGameContainer(new Game_Controller("CSRPG"));
			mainWindow.setDisplayMode(windowWidth, windowHeight, fullScreen);
			mainWindow.setTargetFrameRate(60);
			mainWindow.setShowFPS(false);
			mainWindow.start();
			
		} catch (SlickException e) {
			
			e.printStackTrace();
			
		}
		
	}
}
