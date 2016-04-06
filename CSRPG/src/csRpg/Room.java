package csRpg;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Room extends BasicGameState{

	private Image background;
	private int roomID;
	
	private boolean playing;
	
	// play minigame button
	private int[] mini_button = new int[2];
	private int[] buis_button = new int[2];
	private int[] button_size = new int[2];
	
	private int[] close_button = new int[4];
	
	// Hud on right side 
	private MainWindow hud = new MainWindow();
	
	private Button_Smash button_smash = new Button_Smash();
	private mathMiniGame mathMnGm = new mathMiniGame();

	private BeerMinigame beerMG = new BeerMinigame();
	
	private BuisnessGame buisGame = new BuisnessGame();
	

	private Library_Adventure lib_adv = new Library_Adventure();
	private String miniGame;
	private GameContainer container;
	private StateBasedGame game;
	
	private Image minigamebutton;
	private Image buisnessstuff;
	private Image closebutton;
	
	private int[] player_pos = new int[2];
	
	public Room(String image, int ID, String miniGame, int player_x, int player_y) throws SlickException {
		// TODO Auto-generated constructor stub
		
		this.background = new Image(image);
		this.roomID = ID;
		this.miniGame = miniGame;
		
		this.player_pos[0] = player_x;
		this.player_pos[1] = player_y;
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
		this.buisnessstuff = new Image("assets/Buisness_Stuff.png");
		this.closebutton = new Image("assets/close.png");
		
		hud.init(container, game);
		
		playing = false;
		
		mini_button[0] = 10; // x
		mini_button[1] = 10; // y
		
		buis_button[0] = 10; // x
		buis_button[1] = 70; // y
		
		button_size[0] = 200; // width
		button_size[1] = 50; // height
		
		close_button[0] = container.getWidth() - 335;
		close_button[1] = 15;
		close_button[2] = 100;
		close_button[3] = 70;
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		this.background.draw(0,0,container.getWidth()-215,container.getHeight());
		
		Game_Controller.player.getSprite().draw(this.player_pos[0]-50,this.player_pos[1]-50,100,100);
		
		if (this.roomID != 4) {
			minigamebutton.draw(mini_button[0], mini_button[1], button_size[0], button_size[1]);
		}
		if (this.roomID != 8) {
			if (Game_Controller.player.getBuis() && !Game_Controller.player.hasBuisnessed(this.roomID)) {
				buisnessstuff.draw(buis_button[0], buis_button[1], button_size[0], button_size[1]);
			}
		}
		
		hud.render(container,game,g);
		
		if (playing) {
			g.setColor(Color.black);
			g.fillRect(50,50,container.getWidth()-315,container.getHeight()-100);
			g.setColor(Color.gray);
			g.fillRect(75,75,container.getWidth()-365,container.getHeight()-150);
			showMiniGame(container,game,g);
			closebutton.draw(close_button[0],close_button[1],close_button[2],close_button[3]);
		}
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
		if (playing) {
			updateMiniGame(container,game,delta);
			//if (minigame.isfinished())
			//	getscore
		}
		
	}

	public void mousePressed(int button, int x, int y) {
		if (button == 0) { //left mouse was pressed
			if (playing) {
				clickMiniGame(x,  y);
			}
			if (this.roomID != 4) {
				if (x > mini_button[0] && x < mini_button[0] + button_size[0] && y > mini_button[1] && y < mini_button[1] + button_size[1]) {
					playing = !playing;
					try {
						initMiniGame();
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (this.roomID != 8) {
				if (!Game_Controller.player.hasBuisnessed(this.roomID) && 
						Game_Controller.player.getBuis() && x > buis_button[0] && 
						x < buis_button[0] + button_size[0] && y > buis_button[1] && 
						y < buis_button[1] + button_size[1]) {
					
					Game_Controller.player.doBuisnessed(this.roomID);
					
				}
			}
			if (x > close_button[0] && x < close_button[0] + close_button[2] && y > close_button[1] && y < close_button[1] + close_button[3]) {
				playing = false;
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
			if (Game_Controller.player.getCredits(1) == 1) { 
				mathMnGm.init(container, game, Game_Controller.player.getMathMiniGameScore());
				break;
			}
			mathMnGm.init(container, game);
			break;

		case "Beer_Minigame":
			beerMG.init(container, game);
			break;

		case "library_adventure":
			lib_adv.init(container,  game);
			break;
		
		case "buis_visit":
			buisGame.init(container, game);
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
		case "Beer_Minigame":
			beerMG.buttonPressed(x, y);
		case "library_adventure":
			lib_adv.buttonPressed(x, y);
			break;
		case "buis_visit":
			buisGame.buttonPressed(x,y);
			break;
		}
	}
	
	public void keyPressed(int key, char c) {
		switch(this.miniGame) {
		case "library_adventure":
			lib_adv.keyPressed(key, c);
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
		case "Beer_Minigame":
			beerMG.render(container, game, g);
			break;
			
		case "library_adventure":
			lib_adv.render(container, game, g);
			break;

		case "buis_visit":
			buisGame.render(container, game, g);
			break;
		}
	}
	
	private void updateMiniGame(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		switch(this.miniGame) {
		case "button_smash":
			button_smash.update(container, game, delta);
			break;
		case "mathGame":
			if (mathMnGm.isFinished())
			{
				Game_Controller.player.addCredit(1);
				Game_Controller.player.setMathMiniGameScore(mathMnGm.getScore());
			}
			mathMnGm.update(container, game, delta);
			break;
		case "Beer_Minigame":
			beerMG.update(container, game, delta);
		case "library_adventure":
			lib_adv.update(container, game, delta);
			break;
		case "buis_visit":
			buisGame.update(container, game, delta);
			break;
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub

		return this.roomID;

	}
}
