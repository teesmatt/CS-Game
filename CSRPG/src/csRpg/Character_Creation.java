package csRpg;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Character_Creation extends BasicGameState {

	private StateBasedGame game;
	
	// buttons
	private Button gender;
	private Button submit;
	private Button back;
	
	// text fields
	private TextField name;
	private TextField intelligence;
	private TextField endurance;
	private TextField alcohol_tolerance;
	
	private Font font;
	
	private int windowWidth;
	private int windowHeight;
	
	private Image background;
	private Image character;
	
	private Rectangle menu;
	
	int sprite_state;
	
	public Character_Creation() {
		// TODO Auto-generated constructor stub
		sprite_state = 1;
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
		this.game = game;
		
		this.windowWidth = container.getWidth();
		this.windowHeight= container.getHeight();
		
		this.menu = new Rectangle(0,0,250,container.getHeight());
		this.font = new Font("Time New Roman", Font.BOLD, 20);
		
		this.background = new Image("/assets/Background.jpeg");
		
		this.name = new TextField(container, null, 50, 100, 25, 25);
		this.name.setText("Name");
		
		this.intelligence = new TextField(container, null, 50, 150, 25, 25);
		this.intelligence.setText("Intelligence");
		
		this.endurance = new TextField(container, null, 50, 200, 25, 25);
		this.endurance.setText("Endurance");
		
		this.alcohol_tolerance = new TextField(container, null, 50, 250, 25, 25);
		this.endurance.setText("Alcohol Tolerance");
		
		this.gender = new Button(container, "Change Sprite", Color.white, false);
		this.gender.setLocation(50, 300);
		
		this.submit = new Button(container, "Change Sprite", Color.white, false);
		this.submit.setLocation(50, 350);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		this.background.draw(0,0,this.windowWidth,this.windowHeight);
		
		this.name.render(container, g);
		this.gender.render(container, g);
		this.intelligence.render(container, g);
		this.endurance.render(container, g);
		this.alcohol_tolerance.render(container, g);
		this.submit.render(container, g);
		
		
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(int button, int x, int y) {
		if (button == 0) { // if the left mouse button is pressed
			if (gender.ButtonPressed(x, y)) {
				// Male Case
				if (sprite_state == 1)
				{
					sprite_state = 2;
					// Image = female image
				}
				// Female Case
				else
				{
					sprite_state = 1;
					// image = male image
				}
			} else if (submit.ButtonPressed(x, y)) {
				// Check to see if stats are aight
			} 
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
