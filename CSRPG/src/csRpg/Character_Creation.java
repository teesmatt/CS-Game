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

public class Character_Creation extends BasicGameState {

	// variables to be used in the menu scene of the game
	private StateBasedGame game;

	// Text Fields
	private TextField name;
	private TextField intelligence;
	private TextField endurance;
	private TextField alcohol_tolerance;
	
	// Buttons
	private Button gender;
	private Button submit;
	private Button back;
	
	// Window Dimensions
	private int windowWidth;
	private int windowHeight;
	
	//  Image's
	private Image background;
	private Image char_sprite_1;
	private Image char_sprite_2;
	
	private Rectangle menu;
	private Rectangle sprite_container;
	
	private Font font;
	private UnicodeFont uni_font;
	
	// Colors
	private Color color;
	private Color white;	
	
	private int sprite_state;
	
	// Stats
	private int char_int;
	private int char_end;
	private int char_alc;
	
	// String references
	private String int_ref;
	private String end_ref;
	private String alc_ref;
	
	public Character_Creation() {
		// TODO Auto-generated constructor stub
		font = new Font("Time New Roman", Font.BOLD, 20);
		color = new Color(0, 0, 0);
		white = new Color(255, 255, 255);
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
		
		// Initializes the Menu and Font
		this.menu = new Rectangle(0,0,250,container.getHeight());
		this.uni_font = new UnicodeFont(font);
		this.uni_font.addGlyphs("@");
        this.uni_font.getEffects().add(new ColorEffect(java.awt.Color.black));
		
        // Initializes the Background
		this.background = new Image("/assets/Background.jpeg");
		
		// Adds Name Text Field
		this.name = new TextField(container, uni_font, 50, 100, 250, 50);
		this.name.setText("Name");
		this.name.setBackgroundColor(white);
		this.name.setBorderColor(color);
		
		// Adds the Intelligence Text Field
		this.intelligence = new TextField(container, uni_font, 50, 150, 250, 50);
		this.intelligence.setText("Intelligence");
		this.intelligence.setBackgroundColor(white);
		this.intelligence.setBorderColor(color);
		
		// Adds the Endurance Text Field
		this.endurance = new TextField(container, uni_font, 50, 200, 250, 50);
		this.endurance.setText("Endurance");
		this.endurance.setBackgroundColor(white);
		this.endurance.setBorderColor(color);
		
		// Add the Alcohol Tolerance Text Field
		this.alcohol_tolerance = new TextField(container, uni_font, 50, 250, 250, 50);
		this.alcohol_tolerance.setText("Alcohol Tolerance");
		this.alcohol_tolerance.setBackgroundColor(white);
		this.alcohol_tolerance.setBorderColor(color);
		
		// Make Character Sprite Area
		this.sprite_container = new Rectangle(300, 50, 250, container.getHeight());
		this.char_sprite_1 = new Image("/assets/male_playable_character_sprite.png");
		this.char_sprite_2 = new Image("/assets/female_playable_character_sprite.png");
		
		this.gender = new Button(container, "Change Sprite", Color.white, false);
		this.gender.setLocation(50, 300);
		
		this.submit = new Button(container, "SUBMIT", Color.white, false);
		this.submit.setLocation(50, 350);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		this.background.draw(0,0,this.windowWidth,this.windowHeight);
		
		if (sprite_state == 1) {
			this.char_sprite_1.draw(300, 50, 500, this.windowHeight);
		} else {
			this.char_sprite_2.draw(300, 50, 500, this.windowHeight);
		}

		
		this.name.render(container, g);
		this.intelligence.render(container, g);
		this.endurance.render(container, g);
		this.alcohol_tolerance.render(container, g);
		g.setFont(uni_font);
		
		this.gender.render(container, g);	
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
				int_ref = this.intelligence.getText();
				end_ref = this.endurance.getText();
				alc_ref = this.alcohol_tolerance.getText();
				
				if (isNumeric(int_ref) && isNumeric(end_ref) && isNumeric(alc_ref)) {
					char_int = Integer.parseInt(int_ref);
					char_end = Integer.parseInt(end_ref);
					char_alc = Integer.parseInt(alc_ref);
					
					if (sprite_state == 1)
						try {
							Game_Controller.player = new Character(this.name.getText(), char_int, char_end, char_alc, 1, "/assets/male_playable_character_sprite.png");
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					else
						try {
							Game_Controller.player = new Character(this.name.getText(), char_int, char_end, char_alc, 1, "/assets/female_playable_character_sprite.png");
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					game.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
				}
				
				
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
		return 20;
	}

}
