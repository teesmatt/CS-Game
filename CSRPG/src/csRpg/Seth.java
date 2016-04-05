package csRpg;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Seth extends BasicGameState {

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
	
	private int windowWidth;
	private int windowHeight;
	
	private Image background;
	private Image character;
	
	private Rectangle menu;
	
	int sprite_state;
	
	// Fonts
	private Font font;
	private UnicodeFont uni_font;
	
	// Colors
	private Color black;
	private Color white;
	
	public Seth() {
		sprite_state = 1;
		font = new Font("Time New Roman", Font.BOLD, 20);
		black = new Color(0, 0, 0);
		white = new Color(255, 255, 255);
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
		
		this.windowWidth = container.getWidth();
		this.windowHeight= container.getHeight();
		
		this.menu = new Rectangle(0,0,250,container.getHeight());
	
		this.background = new Image("/assets/Background.jpeg");
		
		this.uni_font = new UnicodeFont(font);
		this.uni_font.addGlyphs("@");
		this.uni_font.getEffects().add(new ColorEffect(java.awt.Color.black));
		this.name = new TextField(container, uni_font, 50, 100, 75, 25);
		this.name.setText("Name");
		this.name.setMaxLength(10);
		
		this.intelligence = new TextField(container, uni_font, 50, 150, 75, 25);
		this.intelligence.setText("Intelligence");
		
		this.endurance = new TextField(container, uni_font, 50, 200, 75, 25);
		this.endurance.setText("Endurance");
		
		this.alcohol_tolerance = new TextField(container, uni_font, 50, 250, 75, 25);
		this.endurance.setText("Alcohol Tolerance");
		
		this.gender = new Button(container, "Change Sprite", Color.white, false);
		this.gender.setLocation(50, 300);
		
		this.submit = new Button(container, "SUBMIT", Color.white, false);
		this.submit.setLocation(50, 350);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		g.setFont(uni_font);
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
		uni_font.loadGlyphs();
		
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
				// Make sure all stats are numeric.
				
				
			} 
		}
	}
	
	
	// Source: http://stackoverflow.com/questions/14206768/how-to-check-if-a-string-is-numeric
	public boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 200;
	}

}
