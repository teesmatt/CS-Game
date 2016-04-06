package csRpg;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOver extends BasicGameState{

	private Font awtFont = new Font("", 1, 50);
    private TrueTypeFont font = new TrueTypeFont(awtFont, false);
	
    private Image background;
    
    private Rectangle box;
    
	public GameOver() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		
		// loads the image for the background of the menu
		this.background = new Image("/assets/Background.jpeg");
		
		this.box = new Rectangle(50,50,container.getWidth()-100,container.getHeight()-100);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		// draws the background image
		this.background.draw(0,0,container.getWidth(),container.getHeight());
		g.setColor(Color.white);
		
		// sets the color for the rectangle
		g.setColor(new Color(0,0,0,0.4f));
		g.fill(this.box);
		
		font.drawString(100,100,"Game Over!");
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 666;
	}

}
