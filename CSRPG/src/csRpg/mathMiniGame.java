package csRpg;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class mathMiniGame extends BasicGameState {

	private float timer;
	private int score;
	private int currentProb;
	private Image prob4;
	
	private void drawMultipleChoices(String question, String answerA, 
			     String answerB, String answerC, String answerD, Graphics g)
	{
		g.setColor(Color.white);
		g.drawString(String.valueOf("Question " + this.currentProb + ": " +
				question), 350, 150);
		g.drawString(String.valueOf("A. " + answerA), 350, 190);
		g.drawString(String.valueOf("B. " + answerB), 350, 210);
		g.drawString(String.valueOf("C. " + answerC), 350, 230);
		g.drawString(String.valueOf("D. " + answerD), 350, 250);
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		this.timer = 30;
		this.score = 0;
		this.currentProb = 1;
		this.prob4 = new Image("/assets/mathMinigameProb4.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(50,50,container.getWidth()-315,container.getHeight()-100);
		g.setColor(Color.gray);
		g.fillRect(75,75,container.getWidth()-365,container.getHeight()-150);
		
		g.setColor(Color.white);
		g.drawString(String.valueOf("Score: "+this.score),80,80);
		g.drawString(String.valueOf("Time: "+this.timer),80,100);
		
		switch (this.currentProb)
		{
		case 1:
			this.drawMultipleChoices("1 + 1 = ?", "2", "3.14159", "1", "1.41421", g);
			break;
			
		case 2:
			this.drawMultipleChoices("2X + 4 = 10, X = ?", "1", "2", "3", "4", g);
			break;
			
		case 3:
			this.drawMultipleChoices("What is sin (PI / 2)?", "1", "2", "3", "4", g);
			break;
		
		case 4:
			this.drawMultipleChoices(" ", "1", "55 / 156", "0.45", "2PI", g);
			this.prob4.draw(450, 130);
			break;
		}
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int delta) throws SlickException {
		// TODO Auto-generated method stub
		timer -= delta/1000.0;
		
		if (timer <= 0) {
			timer = 0;
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 120;
	}

	public void buttonPressed(int x, int y) {
		// TODO Auto-generated method stub
		
		switch (currentProb) {
		case 1:
			if (y < 210 && y > 190 && timer > 0)
				this.score += 10;
			this.currentProb++;
			break;
			
		case 2:
			if (y < 250 && y > 230 && timer > 0)
				this.score += 10;
			this.currentProb++;
			break;
		
		case 3:
			if (y < 210 && y > 190 && timer > 0)
				this.score += 10;
			this.currentProb++;
			break;
			
		case 4:
			if (y < 230 && y > 210 && timer > 0)
				this.score += 10;
			this.currentProb++;
			break;
			
		}
	}

}
