package csRpg;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class LoadSaves extends BasicGameState {
	
	private StateBasedGame game;
	
	private Button back_title;
	
	private int windowWidth;
	private int windowHeight;
	
	// Hud on right side 
	private MainWindow hud = new MainWindow();
	
	private Image background;
	
	private Rectangle menu;
	
	public LoadSaves(){
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = game;
		
		this.windowWidth = container.getWidth();
		this.windowHeight = container.getHeight();
		
		// loads the image for the background of the menu
		this.background = new Image("/assets/Background.jpeg");
		
		hud.init(container, game);
				
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		
		this.background.draw(0,0,container.getWidth(),container.getHeight());
		
		
		// Renders the hud on the right
		hud.render(container, game, g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg3) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(int button, int x, int y) {
		if (button == 0) {
			hud.wPressed(x, y);
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 69;
	}

}
