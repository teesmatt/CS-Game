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
	public static final int MathID = 6;
	public static final int LibraryID = 7;
	public static final int BussinessID = 8;
	
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


		// adds each room to the game
		this.addState(new LoadSaves());

		this.addState(new Room("/assets/ClassroomLounge.png",ClassID,"button_smash",container.getWidth()/2-100,200));
		this.addState(new Room("/assets/ClassroomLounge.png",LoungeID,"",container.getWidth()/2-100,500));
		this.addState(new Room("/assets/Pub.png",PubID,"Beer_Minigame",container.getWidth()/2-100,container.getHeight()/2));
		this.addState(new Room("/assets/Bussiness.png",BussinessID,"buis_visit",container.getWidth()/2-100,container.getHeight()/2));
		this.addState(new Room("/assets/Library.png",LibraryID,"library_adventure",container.getWidth()/2-100,container.getHeight()/2));
		this.addState(new Room("/assets/Math.png",MathID,"mathGame",container.getWidth()/2-100,container.getHeight()/2));

		this.addState(new Highscores());
		
		this.addState(new GameOver());
		
		
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
