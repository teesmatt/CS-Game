package csRpg;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Input;

public class Library_Adventure extends BasicGameState {

	private int[][] library;
	private int loc_x, loc_y;
	
	private int x,y,width,height;
	
	public Library_Adventure() {
		
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		this.library = new int[10][10];
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				this.library[i][j] = 0;
			}
		}
		
		this.loc_x = 0;
		this.loc_y = 0;
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(50,50,container.getWidth()-315,container.getHeight()-100);
		g.setColor(Color.gray);
		g.fillRect(75,75,container.getWidth()-365,container.getHeight()-150);
		
		if (library[loc_x][loc_y] == 0) {
			g.drawString("There is nothing in this section of the Library." 
					+ "[" + loc_x + "][" + loc_y + "]", 50, 50);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void buttonPressed(int x, int y) {
		
	}
	
	 @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_UP) {
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
        } else if (key == Input.KEY_DOWN) {
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

}
