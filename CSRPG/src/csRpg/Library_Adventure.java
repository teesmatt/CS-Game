package csRpg;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.Input;

import java.awt.Font;
import java.util.Random;

public class Library_Adventure extends BasicGameState {

	private int[][] library;
	private int books[];
	private int books_count;
	private int loc_x, loc_y;
	
	private int x,y,width,height;
	
	private Random gen;
	
	private float timer;
	
	private boolean isFinished;
	
	private Image grid;
	
	private Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
    private TrueTypeFont font = new TrueTypeFont(awtFont, false);
	
	public Library_Adventure() {
		
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		this.gen = new Random();
		this.books = new int[3];
		this.books_count = 0;
		this.timer = 0;
		
		this.library = new int[10][10];
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				this.library[i][j] = 0;
			}
		}
		
		// Put the books in the library!
		for (int i = 1; i < 4; i++)
		{
			this.library[gen.nextInt(10)][gen.nextInt(10)] = i;
		}
		
		this.loc_x = 0;
		this.loc_y = 0;
		
		this.grid = new Image("assets/Grid.png");
		
	}
	
	public void init(GameContainer container, StateBasedGame game, boolean isFinished) throws SlickException {
		
		this.books_count = 3;
		this.timer = 0;
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(50,50,container.getWidth()-315,container.getHeight()-100);
		g.setColor(Color.gray);
		g.fillRect(75,75,container.getWidth()-365,container.getHeight()-150);
		
		this.grid.draw(container.getWidth()/2-375,container.getHeight()/2-225,500,500);
		Game_Controller.player.getSprite().draw(this.loc_x*50+container.getWidth()/2-375,this.loc_y*50+container.getHeight()/2-225,50,50);
		
		if (library[loc_x][loc_y] == 0) {
			font.drawString(100 , 100, "There is nothing in this section of the Library");
		}
		else if(library[loc_x][loc_y] == 1)
		{
			font.drawString(100, 100, "You found the Science Book!");
			if (books[0] != 1) {
				books[0] = 1;
				this.books_count++;
			}
			
		}
		else if(library[loc_x][loc_y] == 2)
		{
			font.drawString(100, 100, "You found the Geology Book!");
			if (books[1] != 1) {
				books[1] = 1;
				this.books_count++;
			}
			
		}
		else if(library[loc_x][loc_y] == 3)
		{
			font.drawString(100, 100, "You found the CS Book!");
			if (books[2] != 1)
			{
				books[2] = 1;
				this.books_count++;
			}
			
		}
		
		font.drawString(700, 100,"Books: " + books_count);
		
		font.drawString(850, 100, String.format("Time: %.2f",timer));
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		if (this.books_count != 3)
		{
			timer += delta/1000.0;
			//
			
		}
		else {
			//A+ = 10 seconds
			if (timer < 30) { 
				Game_Controller.player.calcGpa(4);
				Game_Controller.player.setMiniGameScore(3, 100);
			}
			//B = 20 seconds
			else if (timer < 40)
			{
				Game_Controller.player.calcGpa(3);
				Game_Controller.player.calcSanity(-10);
				Game_Controller.player.setMiniGameScore(3, 75);
			}
			//C = 30 seconds
			else if (timer < 50)
			{
				Game_Controller.player.calcGpa(2);
				Game_Controller.player.calcSanity(-20);
				Game_Controller.player.setMiniGameScore(3, 60);
			}
			//F = 40 seconds
			else if (timer < 60)
			{
				Game_Controller.player.calcGpa(0);
				Game_Controller.player.calcSanity(-30);
				Game_Controller.player.setMiniGameScore(3, 50);
			}
				
			Game_Controller.player.addCredit(3);
			Game_Controller.player.calcHealth(-10);

			isFinished = true;

		}
	}
	
	public void buttonPressed(int x, int y) {
		
	}
	
	 @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_DOWN) {
        	if (this.loc_y != 9)
        		this.loc_y++;
        	else
        		this.loc_y = 0;
        } else if (key == Input.KEY_LEFT) {
        	if (this.loc_x != 0)
        		this.loc_x--;
        	else
        		this.loc_x = 9;
        } else if (key == Input.KEY_RIGHT) {
        	if (this.loc_x != 9)
        		this.loc_x++;
        	else
        		this.loc_x = 0;
        } else if (key == Input.KEY_UP) {
        	if (this.loc_y != 0)
        		this.loc_y--;
        	else
        		this.loc_y = 9;
        }
    }

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 21;
	}
	
	public boolean isFinished()
	{
		return isFinished;
	}

}
