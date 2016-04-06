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

public class mathMiniGame extends BasicGameState {

	private float timer;
	private int score;
	private int currentProb;
	private Image prob4;
	private boolean isFinished;
	private Font awtFont = new Font("", 1, 20);
    private TrueTypeFont font = new TrueTypeFont(awtFont, false);
	
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
	
	private boolean isAnswerCorrect(int x, int y, char choice)
	{
		switch (choice)
		{
		case 'A':
			if (y < 210 && y > 190 && this.timer > 0)
				return true;
			break;
		case 'B':
			if (y < 230 && y > 210 && this.timer > 0)
				return true;
			break;
		case 'C':
			if (y < 250 && y > 230 && this.timer > 0)
				return true;
			break;
		case 'D': 
			if (y < 270 && y > 250 && this.timer > 0)
				return true;
			break;
		}
		return false;
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		this.timer = 30;
		this.score = 0;
		this.currentProb = 1;
		this.prob4 = new Image("/assets/mathMinigameProb4.png");
		this.isFinished = false;
	}
	
	public void init(GameContainer arg0, StateBasedGame arg1, int savedScore) throws SlickException {
		this.timer = 0;
		this.score = savedScore;
		this.currentProb = 5;
		this.isFinished = true;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(50,50,container.getWidth()-315,container.getHeight()-100);
		g.setColor(Color.gray);
		g.fillRect(75,75,container.getWidth()-365,container.getHeight()-150);
		
		g.setColor(Color.white);
		font.drawString(80, 80, String.valueOf("Score: "+this.score));
		font.drawString(80,100, String.valueOf("Time: "+this.timer));
		
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
		
		if (this.currentProb < 5)
		{
			timer -= delta/1000.0;
		}
		
		//timer -= delta/1000.0;
		if (timer <= 0) {
			timer = 0;
			this.isFinished = true;
			this.currentProb = 5;
		}
	}

	@Override
	public int getID() {
		return 120;
	}

	public void buttonPressed(int x, int y) {
		switch (currentProb) {
		case 1:
			if (this.isAnswerCorrect(x, y, 'A'))
				this.score += 20;
			this.currentProb++;
			break;
			
		case 2:
			if (this.isAnswerCorrect(x, y, 'C'))
				this.score += 20;
			this.currentProb++;
			break;
		
		case 3:
			if (this.isAnswerCorrect(x, y, 'A'))
				this.score += 20;
			this.currentProb++;
			break;
			
		case 4:
			if (this.isAnswerCorrect(x, y, 'B'))
				this.score += 40;
			this.currentProb++;
			this.isFinished = true;
			break;
			
		}
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public boolean isFinished()
	{
		return this.isFinished;
	}

}
