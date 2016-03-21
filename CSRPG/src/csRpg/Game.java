package csRpg;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Game extends BasicGameState{

	private static boolean PAUSED = false;
	private StateBasedGame game;

	public Game() {
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
		
		this.game = game;
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		g.setBackground(Color.white);
		g.setColor(Color.black);
		g.drawString("Game",50,10);
		
		if (PAUSED) {
			
			
			
		}
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2)
			throws SlickException {
		
		// Tests if the game is paused
		if (!PAUSED) {
			
			Input input = container.getInput(); // get input
			
			// Main game loop only updates if the game is not paused
			if (input.isKeyPressed(Input.KEY_ESCAPE)) {
				PAUSED = true; // paused the game
				return; // return from update
			}
		}
		
	}
	
	public void mousePressed(int button, int x, int y) {
		
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
