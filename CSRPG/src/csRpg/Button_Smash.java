package csRpg;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Button_Smash extends BasicGameState{

	private int x,y,width,height;
	private int score;
	
	private float timer;
	
	private Image down;
	private Image up;
	private boolean pressed;
	private boolean isFinished;
	
	private Font awtFont = new Font("", 1, 35);
    private TrueTypeFont font = new TrueTypeFont(awtFont, false);
	
	public Button_Smash() {
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
		// TODO Auto-generated method stub
		this.width = 200;
		this.height = 200;
		this.x = (container.getWidth() - 215 - this.width)/2;
		this.y = (container.getHeight() - this.height)/2;
		this.score = 0;
		this.timer = 10;
		this.isFinished = false;
		
		this.up = new Image("assets/Button_Up.png");
		this.down = new Image("assets/Button_Down.png");
		
		this.pressed = false;
	}
	
	public void init(GameContainer container, StateBasedGame game, int savedScore) throws SlickException {
		this.width = 200;
		this.height = 200;
		this.x = (container.getWidth() - 215 - this.width)/2;
		this.y = (container.getHeight() - this.height)/2;
		this.score = savedScore;
		this.timer = 0;
		this.isFinished = true;
		
		this.up = new Image("assets/Button_Up.png");
		this.down = new Image("assets/Button_Down.png");
		
		this.pressed = false;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		if (pressed) {
			down.draw(this.x,this.y,this.width,this.height);
			pressed = false;
		} else {
			up.draw(this.x,this.y,this.width,this.height);
		}
		
		g.setColor(Color.white);
		font.drawString(80,120,String.valueOf("Score: "+this.score));
		font.drawString(80,80,String.format("Time: %.1f", this.timer));
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
		timer -= delta/1000.0;
		
		if (timer <= 0) {
			timer = 0;
			
			//A+ = 60
			if (score >= 60)
				Game_Controller.player.calcGpa(1);
			
			//B = 50
			else if (score >= 50) {
				Game_Controller.player.calcGpa(0.75);
				Game_Controller.player.calcSanity(-10);
			}
			
			//C = 40
			else if (score >= 40) {
				Game_Controller.player.calcGpa(0.60);
				Game_Controller.player.calcSanity(-20);
			}
			
			//F = 30
			else {
				Game_Controller.player.calcGpa(0);
				Game_Controller.player.calcSanity(-30);
			}
			isFinished = true;
		}
		
	}

	public void buttonPressed(int x, int y) {
		if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height && timer > 0) {
			this.score++;
			this.pressed = true;
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 100;
	}
	
	public boolean isFinished()
	{
		return isFinished;
	}
	
	public int getScore()
	{
		return score;
	}

}
