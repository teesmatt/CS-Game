package csRpg;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game_Controller extends StateBasedGame {

	public static final int windowWidth = 1366;
	public static final int windowHeight = 768;
	public static boolean fullScreen = false;
	
	public static final int TitleId = 0;
	public static final int Character_CreationId = 1;
	public static final int RoomID = 2;
	public static final int MapID = 3;
	
	public Game_Controller(String name) {
		
		super(name);
		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
	
		this.addState(new Title_Menu());

		this.addState(new Game());
		this.addState(new Character_Creation());
		this.addState(new Room());
		this.addState(new Map());
		this.addState(new MainWindow());
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
