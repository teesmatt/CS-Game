package csRpg;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Room extends BasicGameState{

	private Image background;
	private int roomID;
	
	private MainWindow inventory = new MainWindow();
	
	private Button_Smash button_smash = new Button_Smash();
	
	public Room(String image, int ID) throws SlickException {
		// TODO Auto-generated constructor stub
		
		this.background = new Image(image);
		this.roomID = ID;
		
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
		
		inventory.init(container, game);
		button_smash.init(container, game);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		this.background.draw(0,0,container.getWidth()-215,container.getHeight());
		
		inventory.render(container,game,g);
		button_smash.render(container, game, g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(int button, int x, int y) {
		if (button == 0) { //left mouse was pressed
			button_smash.buttonPressed(x, y);
			
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub

		return this.roomID;

	}
}
