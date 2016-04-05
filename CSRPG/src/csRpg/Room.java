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
	
	private boolean playing;
	
	// play minigame button
	private int[] mini_button = new int[4];
	
	private MainWindow inventory = new MainWindow();
	
	private Button_Smash button_smash = new Button_Smash();
	private String miniGame;
	
	public Room(String image, int ID, String miniGame) throws SlickException {
		// TODO Auto-generated constructor stub
		
		this.background = new Image(image);
		this.roomID = ID;
		this.miniGame = miniGame;
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
		
		playing = false;
		
		mini_button[0] = 10; // x
		mini_button[1] = 10; // y
		mini_button[2] = 30; // width
		mini_button[3] = 30; // height
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		this.background.draw(0,0,container.getWidth()-215,container.getHeight());
		
		g.fillRect(mini_button[0], mini_button[1], mini_button[2], mini_button[3]);
		
		inventory.render(container,game,g);
		
		if (playing) {
			showMiniGame(container,game,g);
		}
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if (playing) {
			updateMiniGame(container,game,delta);
		}
		
	}

	public void mousePressed(int button, int x, int y) {
		if (button == 0) { //left mouse was pressed
			if (playing) {
				button_smash.buttonPressed(x, y);
			}
			if (x > mini_button[0] && x < mini_button[0] + mini_button[2] && y > mini_button[1] && y < mini_button[1] + mini_button[3]) {
				playing = !playing;
			}
		}
	}
	
	private void showMiniGame(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		switch(this.miniGame) {
		case "button_smash":
			button_smash.render(container, game, g);
			break;
		}
	}
	
	private void updateMiniGame(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		switch(this.miniGame) {
		case "button_smash":
			button_smash.update(container, game, delta);
			break;
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub

		return this.roomID;

	}
}
