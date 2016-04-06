package csRpg;

import java.awt.Font;
import java.util.ArrayList;

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
	
	private Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
    private TrueTypeFont font = new TrueTypeFont(awtFont, false);
	
	
	public MainWindow() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		
		int menu_right_margin = container.getWidth() - 215;
		
		this.game = game;
		
		this.menu = new Rectangle(container.getWidth() - 225, 0, container.getWidth() - 225, container.getHeight());
		
		
		// back to maain menu
		this.back = new Button(container, "./Save", Color.white, false);
		this.back.setLocation(menu_right_margin, container.getHeight() - 150);
		
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
		
		Inventory inven;
		// DEBUG CODE FOR INVENTORY ------------------------------------
		if (Game_Controller.gameData.getNextIndex() == 0)
		{
			Item i1 = new Item("Food", 0);
			Item i2 = new Item("Beer", 1);
			Item i3 = new Item("Beer", 1);
			inven = new Inventory();
			inven.addItem(i1);
			inven.addItem(i2);
			inven.addItem(i3);
			this.list = new GameList(container, "ListItem", Color.white, inven.numItems(), true);
			this.list.setInventoryList(inven);
		} else {
			this.list = new GameList(container, "ListItem", Color.white, Game_Controller.player.getInventory().numItems(), true);
			this.list.setInventoryList(Game_Controller.player.getInventory());
		}
		// -------------------------------------------------------------
		this.list.setLocation(menu_right_margin + 10, 360);
		//		this.list.setLocation(0, 0);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		
		int menu_right_margin = container.getWidth() - 215;
		
		// sets the color for the rectangles behind the buttons
		g.setColor(new Color(0,0,0,0.2f));
		
		// fills the rectangle behind the menu options
		g.fill(this.menu);
		
		// sets the color to white and renders all the buttons on the screen
		g.setColor(Color.white);
		font.drawString(menu_right_margin, 25 , "CS_RPG");

		Character p = Game_Controller.player;

		g.drawString("Name: " + p.getName(), menu_right_margin, 55);
		
		g.drawString(String.format("Time: %.1f", p.timer), menu_right_margin, 500);
		g.drawString("Attributes:", menu_right_margin, 75);
		g.drawString("Intelligence: " + p.getIntelligence(), menu_right_margin + 10, 95);
		g.drawString("Endurance: " + p.getEndurance(), menu_right_margin + 10, 115);
		g.drawString("Alcohol Tolerance: " + p.getAlcohol_tolerance(), menu_right_margin + 10, 135);
		
				
		g.drawString("Vitals", menu_right_margin, 195);
		g.drawString("Health: " + p.getHealth(), menu_right_margin + 10, 220);
		g.drawString("Sanity: " + p.getSanity(), menu_right_margin + 10, 245);
		g.drawString("GPA: " + p.getGpa(), menu_right_margin + 10, 270);
		g.drawString("Inventory:", menu_right_margin , 300);
		
		this.save.render(container, g);
		this.options.render(container, g);
		this.quit.render(container, g);
		this.map.render(container, g);
		this.list.render(container, g);
		
	}
	public void wPressed(int x, int y) throws SlickException {
		if (this.save.ButtonPressed(x, y)) {
			Data d = new Data();
			d.saveChar(Game_Controller.player);
		} else if (this.options.ButtonPressed(x, y)) {
			
		} else if (this.quit.ButtonPressed(x, y)) {
			System.exit(0);
		} else if (this.map.ButtonPressed(x, y)) {
			game.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		} else if (this.back.ButtonPressed(x, y)){
			game.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		} else if (this.list.ButtonPressed(x, y)) {
			
		}
	}
	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2015;
	}

}
