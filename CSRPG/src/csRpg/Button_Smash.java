package csRpg;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Button_Smash extends BasicGameState{

	private int x,y,width,height;
	private int score;
	
	private float timer;
	
	private Image down;
	private Image up;
	private boolean pressed;
	
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
		
		this.up = new Image("assets/Button_Up.png");
		this.down = new Image("assets/Button_Down.png");
		
		this.pressed = false;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		g.setColor(Color.black);
		g.fillRect(50,50,container.getWidth()-315,container.getHeight()-100);
		g.setColor(Color.gray);
		g.fillRect(75,75,container.getWidth()-365,container.getHeight()-150);
		
		if (pressed) {
			down.draw(this.x,this.y,this.width,this.height);
			pressed = false;
		} else {
			up.draw(this.x,this.y,this.width,this.height);
		}
		
		g.setColor(Color.white);
		g.drawString(String.valueOf("Score: "+this.score),80,80);
		g.drawString(String.valueOf("Time: "+this.timer),200,100);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
		timer -= delta/1000.0;
		
		if (timer <= 0) {
			timer = 0;
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

}
