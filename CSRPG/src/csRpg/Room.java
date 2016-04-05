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
	
	// Hud on right side 
	private MainWindow hud = new MainWindow();
	
	private Button_Smash button_smash = new Button_Smash();
	private mathMiniGame mathMnGm = new mathMiniGame();
	private String miniGame;
	private GameContainer container;
	private StateBasedGame game;
	
	private Image minigamebutton;
	
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
		
		this.container = container;
		this.game = game;
		
		this.minigamebutton = new Image("assets/MiniGameButton.png");
		
		hud.init(container, game);
		
		playing = false;
		
		mini_button[0] = 10; // x
		mini_button[1] = 10; // y
		mini_button[2] = 200; // width
		mini_button[3] = 50; // height
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		this.background.draw(0,0,container.getWidth()-215,container.getHeight());
		
		minigamebutton.draw(mini_button[0], mini_button[1], mini_button[2], mini_button[3]);
		
		hud.render(container,game,g);
		
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
				clickMiniGame(x,  y);
			}
			if (x > mini_button[0] && x < mini_button[0] + mini_button[2] && y > mini_button[1] && y < mini_button[1] + mini_button[3]) {
				playing = !playing;
				try {
					initMiniGame();
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			hud.wPressed(x, y);
		}
	}
	
	private void initMiniGame() throws SlickException {
		switch(this.miniGame) {
		case "button_smash":
			button_smash.init(container, game);
			break;
		case "mathGame":
			mathMnGm.init(container, game);
			break;
			
		}
	}
	
	private void clickMiniGame(int x, int y) {
		switch(this.miniGame) {
		case "button_smash":
			button_smash.buttonPressed(x, y);
			break;
		case "mathGame":
			mathMnGm.buttonPressed(x, y);
			break;
			
		}
	}
	
	private void showMiniGame(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		switch(this.miniGame) {
		case "button_smash":
			button_smash.render(container, game, g);
			break;
		case "mathGame":
			mathMnGm.render(container, game, g);
			break;
			
		}
	}
	
	private void updateMiniGame(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		switch(this.miniGame) {
		case "button_smash":
			button_smash.update(container, game, delta);
			break;
		case "mathGame":
			mathMnGm.update(container, game, delta);
			break;
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub

		return this.roomID;

	}
}
