package csRpg;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game_Controller extends StateBasedGame {

	public static final int windowWidth = 800;
	public static final int windowHeight = 600;
	public static boolean fullScreen = false;
	
	public Game_Controller(String name) {
		
		super(name);
		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
	
		this.addState(new Title_Menu());
		this.addState(new Game());

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
