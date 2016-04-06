package csRpg;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BuisnessGame extends BasicGameState {

	public boolean isFinished;
	
	private Font awtFont = new Font("", 1, 35);
    private TrueTypeFont font = new TrueTypeFont(awtFont, false);
	
	public BuisnessGame() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		Game_Controller.player.setBuis(true);
		this.isFinished = Game_Controller.player.doneBuisnessed();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		if (this.isFinished) {
			font.drawString(100,300,"Congratulations you are a true business person");
		} else {
			font.drawString(100,300,"Go and do business in all the other buildings");
		}
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void buttonPressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
