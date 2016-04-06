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
import org.newdawn.slick.state.transition.*;

public class Title_Menu extends BasicGameState {

	// variables to be used in the menu scene of the game
	private StateBasedGame game;
	// buttons
	private Button play;
	private Button quit;
	private Button load;
	private Button options;
	private Button highscores;
	
	// option buttons
	private Button options_close; // close the options window
	private Button options_fullToggle; // fullscreen toggle
	
	private Image background;
	
	private Rectangle menu;
	private Rectangle optionWindow;
	
	private Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
    private TrueTypeFont font = new TrueTypeFont(awtFont, false);
    
	private boolean optionsDisplay;

	public Title_Menu() {
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
		
		this.menu = new Rectangle(0,0,250,container.getHeight());
		
		// The options menu
		this.optionWindow = new Rectangle(300,container.getHeight()/2-125,125,250);
		this.optionsDisplay = false;
		
		// loads the image for the background of the menu
		this.background = new Image("/assets/Background.jpeg");
				
		// ./new_game button
		this.play = new Button(container, "./New_Game", Color.white, false);
		this.play.setLocation(50, 100);
		
		// ./load_saved_game button
		this.load = new Button(container, "./Load_Saved_Games", Color.white, false);
		this.load.setLocation(50, 150);
		
		// ./options button
		this.options = new Button(container, "./Options", Color.white, false);
		this.options.setLocation(50, 200);
		
		this.highscores = new Button(container, "./Highscores", Color.white, false);
		this.highscores.setLocation(50, 250);
		
		// ./quit button
		this.quit = new Button(container, "./Quit", Color.white, false);
		this.quit.setLocation(50, 300);
		
		// option controls
		// close button
		this.options_close = new Button(container, "./Close", Color.white, false);
		this.options_close.setLocation(300,container.getHeight()/2);
		
		// Fullscreen button
		this.options_fullToggle = new Button(container, "./FullScreen", Color.white, false);
		this.options_fullToggle.setLocation(300, container.getHeight()/2-100);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		 
		// draws the background image
		this.background.draw(0,0,container.getWidth(),container.getHeight());
		
		// sets the color for the rectangles behind the buttons
		g.setColor(new Color(0,0,0,0.4f));
		
		// fills the rectangle behind the menu options
		g.fill(this.menu);
		
		// sets the color to white and renders all the buttons on the screen
		g.setColor(Color.white);
		font.drawString(50,50,"CS_RPG");
		
		this.play.render(container, g);
		this.load.render(container, g);
		this.options.render(container, g);
		this.quit.render(container, g);
		this.highscores.render(container, g);
		
		// tests if the options should be displayed
		if (this.optionsDisplay) {
			g.setColor(new Color(0,0,0,0.2f));
			g.fill(this.optionWindow);
			g.setColor(Color.white);
			g.drawString("./Options",300,container.getHeight()/2-125);
			this.options_close.render(container, g);
			this.options_fullToggle.render(container, g);
		}
		
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2)
			throws SlickException {
		
	}

	
	// When the mouse is pressed this function will run
	public void mousePressed(int button, int x, int y) {
		if (button == 0) { // if the left mouse button is pressed
			if (play.ButtonPressed(x, y)) {
				
				game.enterState(20, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

			} else if (load.ButtonPressed(x, y)) {

				game.enterState(69, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

			} else if (options.ButtonPressed(x, y)) {
				
				optionsDisplay = true;
				
			} else if (quit.ButtonPressed(x, y)) {
				System.exit(0);
			} else if (this.highscores.ButtonPressed(x, y)) {
				game.enterState(11, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			} 
			
			
			// get the mouse input if the options are being displayed
			if (this.optionsDisplay) {
				
			}
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
