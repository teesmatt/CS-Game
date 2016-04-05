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


public class MainWindow extends BasicGameState {
	// variables to be used in the menu scene of the game
	private StateBasedGame game;
	// buttons
	
	private Button quit;
	private Button save;
	private Button options;
	private Button map;
	private Button back;
	
	private GameList list;
	
	private Rectangle menu;
	private Rectangle optionWindow;
	
	private int windowWidth;
	private int windowHeight;
	
	private Font font;
	private boolean optionsDisplay;
	
	private Image background;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		
		int menu_right_margin = container.getWidth() - 215;
		
		this.game = game;
		
		this.menu = new Rectangle(container.getWidth() - 225, 0, container.getWidth() - 225, container.getHeight());
		
		// font to be used in the menu
		this.font = new Font("Time New Roman", Font.BOLD, 14);
		
		// loads the image for the background of the menu
		this.background = new Image("/assets/Background.jpeg");
				
		// ./load_saved_game button
		this.save = new Button(container, "./Save", Color.white, false);
		this.save.setLocation(menu_right_margin, container.getHeight() - 125);
		
		this.map = new Button(container, "./View_Map", Color.white, false);
		this.map.setLocation(menu_right_margin, container.getHeight() - 100);
			
		// ./options button
		this.options = new Button(container, "./Options", Color.white, false);
		this.options.setLocation(menu_right_margin, container.getHeight() - 75);
		
		// ./quit button
		this.quit = new Button(container, "./Quit", Color.white, false);
		this.quit.setLocation(menu_right_margin, container.getHeight() - 50);
		
		
		// DEBUG CODE FOR INVENTORY ------------------------------------
		Item i1 = new Item("Food", 0);
		Item i2 = new Item("Beer", 1);
		
		Inventory inven = new Inventory();
		inven.addItem(i1);
		inven.addItem(i2);
		// -------------------------------------------------------------
		
		
		this.list = new GameList(container, "ListItem", Color.white, 3, true);
		this.list.setLocation(menu_right_margin + 10, 325);
		this.list.setInventoryList(inven);
//		this.list.setLocation(0, 0);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// draws the background image
		this.background.draw(0,0,container.getWidth(),container.getHeight());
		
		int menu_right_margin = container.getWidth() - 215;
		
		// sets the color for the rectangles behind the buttons
		g.setColor(new Color(0,0,0,0.2f));
		
		
		// fills the rectangle behind the menu options
		g.fill(this.menu);
		
		// sets the color to white and renders all the buttons on the screen
		g.setColor(Color.white);
		g.drawString("CS_RPG", menu_right_margin , 25);

		
		g.drawString("Attributes:", menu_right_margin, 75);
		g.drawString("HP:", menu_right_margin + 10, 95);
		g.drawString("Programming:", menu_right_margin + 10, 115);
		g.drawString("Business:", menu_right_margin + 10, 135);
		g.drawString("Beer-tolerance:", menu_right_margin + 10, 155);
				
		g.drawString("Vitals", menu_right_margin, 195);
		g.drawString("Health:", menu_right_margin + 10, 220);
		g.drawString("Sanity", menu_right_margin + 10, 245);
		
		g.drawString("Inventory:", menu_right_margin , 305);
		
		this.save.render(container, g);
		this.options.render(container, g);
		this.quit.render(container, g);
		this.map.render(container, g);
		this.list.render(container, g);
		
	}
	public void mousePressed(int button, int x, int y) {
		if (button == 0) { //left mouse was pressed
			if (this.save.ButtonPressed(x, y)) {
				
			} else if (this.options.ButtonPressed(x, y)) {
				
			} else if (this.quit.ButtonPressed(x, y)) {
				System.exit(0);
			} else if (this.map.ButtonPressed(x, y)) {
				
			} else if (this.back.ButtonPressed(x, y)){
				
			}
		}
	}
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 10;
	}

}
