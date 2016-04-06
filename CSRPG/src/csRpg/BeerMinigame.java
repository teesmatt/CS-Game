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
	private int beersClicked;
	private int num_beers;
	private Boolean started;
	
	private Image beerImg;
	private ArrayList<XY> beer_points;
	// test image
	private Image background;
	private int score;
	private boolean isFinished;

	
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
		
		this.beersClicked = 0;
		this.num_beers = 25;
		this.timer = 15;
		this.started = false;
		this.isFinished = false;
		
		this.miniGameTopX = 75;
		this.miniGameTopY = 75;
		this.miniGameBotX = container.getWidth() - 365;
		this.miniGameBotY = container.getHeight() - 150;
		
		this.beerImg = new Image("/assets/beer.gif");
		this.background = new Image("/assets/Background.jpeg");
		
		this.beer_points = genBeerPoints(num_beers,
				new XY(miniGameTopX, miniGameTopY), 
				new XY(miniGameBotX - 20, miniGameBotY - 40));
			
	}
	
	public void init(GameContainer container, StateBasedGame game, boolean isFinished) throws SlickException {
		this.game = game;
		
		this.beersClicked = 25;
		this.num_beers = 25;
		this.timer = 0;
		this.started = false;
		this.isFinished = true;
		
		/*
		this.miniGameTopX = 75;
		this.miniGameTopY = 75;
		this.miniGameBotX = container.getWidth() - 365;
		this.miniGameBotY = container.getHeight() - 150;
		
		this.beerImg = new Image("/assets/beer.gif");
		this.background = new Image("/assets/Background.jpeg");
		
		this.beer_points = genBeerPoints(num_beers,
				new XY(miniGameTopX, miniGameTopY), 
				new XY(miniGameBotX - 20, miniGameBotY - 40));
		*/
	}
	
	

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(miniGameTopX - 25, miniGameTopY - 25, miniGameBotX + 50, miniGameBotY + 50);
		
		g.setColor(Color.gray);
		g.fillRect(miniGameTopX, miniGameTopY, miniGameBotX, miniGameBotY);
		
		for (XY bp: beer_points){
			this.beerImg.draw(bp.getX(), bp.getY(), this.beerSizeX, this.beerSizeY);
		}
		
		g.setColor(Color.white);
		g.drawString(String.valueOf("Score: "+this.beersClicked),80,60);
		g.drawString(String.valueOf("Time: "+this.timer),200,60);
		
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		if (started == true)
		{
			if (!(beersClicked == num_beers))
				timer -= delta/1000.0;
			else {
				
				//A+ = 10 seconds
				if (timer > 10) {
					Game_Controller.player.calcGpa(4);
					Game_Controller.player.setMiniGameScore(2, 100);
				}

				
				//B = 20 seconds
				else if (timer > 7)
				{
					Game_Controller.player.calcGpa(3);
					Game_Controller.player.calcSanity(-10);
					Game_Controller.player.setMiniGameScore(2, 75);
				}
				//C = 30 seconds
				else if (timer > 5)
				{
					Game_Controller.player.calcGpa(2);
					Game_Controller.player.calcSanity(-20);
					Game_Controller.player.setMiniGameScore(2, 60);
				}
				//F = 40 seconds
				else
				{
					Game_Controller.player.calcGpa(0);
					Game_Controller.player.calcSanity(-30);
					Game_Controller.player.setMiniGameScore(2, 50);
				}
					
				Game_Controller.player.addCredit(2);
				Game_Controller.player.calcHealth(-10);
				this.isFinished = true;
				
			
			}
			
			if (timer <= 0) {
				timer = 0;
			}
		}
		
	}
	public void buttonPressed(int x, int y) {
		if (timer != 0) {
			for (XY bp: beer_points) {
				// x > Pub[0] && x < Pub[0] + Pub[2] && y > Pub[1] && y < Pub[1] + Pub[3]) 
				if (x > bp.getX() && x < bp.getX() + beerSizeX && y > bp.getY() && y < bp.getY() + beerSizeY){
					started = true;
					beer_points.remove(bp);
					beersClicked++;
					break;
				}
			}
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 420;
	}
	
	public boolean isFinished()
	{
		return isFinished;
	}
	
}
