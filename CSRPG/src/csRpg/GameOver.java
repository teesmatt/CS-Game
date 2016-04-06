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
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameOver extends BasicGameState{

	private Font awtFont = new Font("", 1, 50);
    private TrueTypeFont font = new TrueTypeFont(awtFont, false);
	
    private Image background;
    
    private Rectangle box;
    
    private Button back;
	private StateBasedGame game;
    
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

		this.game = game;
		
		// loads the image for the background of the menu
		this.background = new Image("/assets/Background.jpeg");
		
		this.box = new Rectangle(50,50,600,container.getHeight()-100);
		
		this.back = new Button(container, "./Main_Menu", Color.white, false);
		this.back.setLocation(100, container.getHeight()-50);
		
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		// draws the background image
		this.background.draw(0,0,container.getWidth(),container.getHeight());
		
		// sets the color for the rectangle
		g.setColor(new Color(0,0,0,0.4f));
		g.fill(this.box);
		
		g.setColor(Color.white);
		
		font.drawString(100,100,"Graduation!");
		
		g.drawString("Name: ",100,175);
		g.drawString(Game_Controller.player.getName(),400,175);
		
		g.drawString("Final GPA: ",100,225);
		g.drawString(String.format("%.2f",Game_Controller.player.finalGpa()),400,225);
		
		this.back.render(container, g);
	}

	public void mousePressed(int button, int x, int y) {
		if (button == 0) { // if the left mouse button is pressed
			if (back.ButtonPressed(x, y)) {
				
				game.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

			}
		}
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
