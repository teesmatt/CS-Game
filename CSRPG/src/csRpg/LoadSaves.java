package csRpg;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;
import java.util.ArrayList;
public class LoadSaves extends BasicGameState {
	
	private StateBasedGame game;
	
	private Button back_title;
	
	private int windowWidth;
	private int windowHeight;
	
	// Hud on right side 
	private MainWindow hud = new MainWindow();
	
	private Image background;
	
	private Rectangle menu;
	private ArrayList<Character> chars;
	private GameList loadList; 
	
	private Button back_main;
	
	public LoadSaves(){
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = game;
		
		this.menu = new Rectangle(0,0,600,container.getHeight());
		
		this.windowWidth = container.getWidth();
		this.windowHeight = container.getHeight();
		
		// loads the image for the background of the menu
		this.background = new Image("/assets/Background.jpeg");
		
		Data d = Game_Controller.gameData;
		this.chars = d.getCharList();
		
		this.loadList = new GameList(container, "", Color.white, this.chars.size(), true);
		this.loadList.setLocation(100, 100);
		this.loadList.setLoadList(this.chars);
		
		this.back_main = new Button(container, "./Back_to_main_menu", Color.white, false);
		this.back_main.setLocation(50, container.getHeight() - 200);
//		hud.init(container, game);
				
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	
		this.background.draw(0,0,container.getWidth(),container.getHeight());
		
		// sets the color for the rectangles behind the buttons
		g.setColor(new Color(0,0,0,0.4f));
		
		// fills the rectangle behind the menu options
		g.fill(this.menu);
		
		
		g.setColor(Color.white);
		g.drawString("SELECT_A_GAME_TO_LOAD", 50, 50);
		
		this.loadList.render(container, g);
		this.back_main.render(container, g);
			
		// Renders the hud on the right
//		hud.render(container, game, g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg3) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(int button, int x, int y) {
		if (button == 0) {
			try {
				if (this.loadList.ButtonPressed(x, y)){
					System.out.println("Player name: " + Game_Controller.player.getName());
					game.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
				}
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (this.back_main.ButtonPressed(x, y)){
				game.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 69;
	}

}
