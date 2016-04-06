package csRpg;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.Color;
import java.awt.Font;

public class Highscores extends BasicGameState {
	
	private StateBasedGame game;
	
	private GameList hscores;
	private Rectangle menu;
	
	private Button back;
	
	private int windowWidth;
	private int windowHeight;
	
	private Image background;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		this.game = game;
		
		this.windowWidth = container.getWidth();
		this.windowHeight = container.getHeight();
		
		this.menu = new Rectangle(0,0, this.windowWidth, this.windowHeight);
		
		// loads the image for the background of the menu
		this.background = new Image("/assets/Background.jpeg");
		
		this.back = new Button(container, "./Back_to_title_menu", Color.white, false);
		this.back.setLocation(0, this.windowHeight - 100);
		
		this.hscores = new GameList(container, "Highscore here", Color.white, 10, true);
		this.hscores.setLocation(50, 50);
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		// loads the image for the background of the menu
		this.background.draw(0,0,this.windowWidth, this.windowHeight);
		
		g.setColor(new Color(0,0,0,0.2f));
		
		g.fill(this.menu);
		
		g.setColor(Color.white);
		g.drawString("Highscores", 20, 20);
		
		this.back.render(container, g);
		this.hscores.render(container, g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 11;
	}
	
	public void mousePressed(int button, int x, int y) {
		if (this.back.ButtonPressed(x, y)) {
			game.enterState(0,new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		}
	}
	
	
}
