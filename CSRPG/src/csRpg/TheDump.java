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
import org.newdawn.slick.state.StateBasedGame;

public class TheDump {

			// variables to be used in the menu scene of the game
			private StateBasedGame game;
		
			// Text Fields
			private TextField name;
			private TextField intelligence;
			private TextField endurance;
			private TextField alcohol_tolerance;
			
			// Window Dimensions
			private int windowWidth;
			private int windowHeight;
			
			// Background Image
			private Image background;
			
			private Rectangle menu;
			
			private Font font;
			private UnicodeFont uni_font;
			
			// Colors
			private Color color;
			private Color white;
			
			public TheDump() {
				font = new Font("Time New Roman", Font.BOLD, 20);
				color = new Color(0, 0, 0);
				white = new Color(255, 255, 255);
			}
			
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
				
			}

			@Override
			public void render(GameContainer container, StateBasedGame game, Graphics g)
					throws SlickException {
				
				this.background.draw(0,0,this.windowWidth,this.windowHeight);
				
				this.name.render(container, g);
				this.intelligence.render(container, g);
				this.endurance.render(container, g);
				this.alcohol_tolerance.render(container, g);
				g.setFont(uni_font);
				
			}

			@Override
			public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
					throws SlickException {
				// TODO Auto-generated method stub
				uni_font.loadGlyphs();
				
			}

			
			@Override
			public int getID() {
				// TODO Auto-generated method stub
				return 20;
			}
			
}
