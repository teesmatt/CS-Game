package csRpg;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import java.util.ArrayList;
import java.util.Random;

public class BeerMinigame extends BasicGameState {
	
	class XY {
		int x;
		int y;
		
		XY(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		int getX(){
			return this.x;
		}
		int getY(){
			return this.y;
		}
	}
	
	private StateBasedGame game;
	
	private float timer;
	
	private Image beerImg;
	private ArrayList<XY> beer_points;
	// test image
	private Image background;
	
	private final int beerSizeX = 66;
	private final int beerSizeY = 118;
	
	private int miniGameTopX;
	private int miniGameTopY;
	private int miniGameBotX;
	private int miniGameBotY;
	
	private ArrayList<XY> genBeerPoints(int num_beers, XY minXY, XY maxXY){
		ArrayList<XY> points = new ArrayList<XY>();
		Random rn = new Random();
		
		int x_range = maxXY.getX() - minXY.getX() + 1;
		int y_range = maxXY.getY() - minXY.getY() + 1;
		
		for (int i = 0; i < num_beers; i++) {
			int rand_x = rn.nextInt(x_range) + minXY.getX();
			int rand_y = rn.nextInt(y_range) + minXY.getY();
//			System.out.println("X: " + rand_x + "Y: " + rand_y);
			points.add(new XY(rand_x, rand_y));
		}
		
		return points;
		
	}
	
	public BeerMinigame() {
		
	}
	
	// TO DO 
	// Shrink beer to right size
	// Generate random locations for images to spawn
	// Timer
	// Remove image on click and increment counter
	
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = game;
		
		this.miniGameTopX = 75;
		this.miniGameTopY = 75;
		this.miniGameBotX = container.getWidth() - 365;
		this.miniGameBotY = container.getHeight() - 150;
		
		this.beerImg = new Image("/assets/beer.gif");
		this.background = new Image("/assets/background.jpeg");
		
		this.beer_points = genBeerPoints(20,
				new XY(miniGameTopX, miniGameTopY), 
				new XY(miniGameBotX - 20, miniGameBotY - 40));
			
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		
		// Debug to see frame
		this.background.draw(0,0, container.getWidth(), container.getHeight());
		// --------------------------
		
		
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(miniGameTopX - 25, miniGameTopY - 25, miniGameBotX + 50, miniGameBotY + 50);
		
		g.setColor(Color.gray);
		g.fillRect(miniGameTopX, miniGameTopY, miniGameBotX, miniGameBotY);
		
		for (XY bp: beer_points){
			this.beerImg.draw(bp.getX(), bp.getY(), this.beerSizeX, this.beerSizeY);
		}
		
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(int button, int x, int y) {
		for (XY bp: beer_points) {
			// x > Pub[0] && x < Pub[0] + Pub[2] && y > Pub[1] && y < Pub[1] + Pub[3]) 
			if (x > bp.getX() && x < bp.getX() + beerSizeX && y > bp.getY() && y < bp.getY() + beerSizeY){
				beer_points.remove(bp);
				break;
			}
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 420;
	}
	
}
