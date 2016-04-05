package csRpg;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Map extends BasicGameState{

	private StateBasedGame game;
	
	private Image background;
	private int[] Pub = new int[4];
	private int[] Library = new int[4];
	private int[] Math = new int[4];
	private int[] Bussiness = new int[4];
	private int[] Classroom = new int[4];
	private int[] Lounge = new int[4];
	
	private MainWindow inventory = new MainWindow();
	
	public Map() {
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
		
		inventory.init(container, game);
		
		this.game = game;
		
		this.background = new Image("/assets/map.png");
		
		// the clickable areas
		Pub[0] = 540;Pub[1] = 90;Pub[2] = 210;Pub[3] = 250;
		
		Library[0] = 840;Library[1] = 125;Library[2] = 200;Library[3] = 300;
		
		Math[0] = 700;Math[1] = 500;Math[2] = 375;Math[3] = 230;
		
		Bussiness[0] = 150;Bussiness[1] = 520;Bussiness[2] = 300;Bussiness[3] = 150;
		
		Classroom[0] = 150;Classroom[1] = 100;Classroom[2] = 185;Classroom[3] = 150;
		
		Lounge[0] = 150;Lounge[1] = 255;Lounge[2] = 185;Lounge[3] = 150;
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		this.background.draw(0,0,container.getWidth()-215,container.getHeight());
		
		inventory.render(container,game,g);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(int button, int x, int y) {
		
		if (button == 0) { //left mouse was pressed
			
			if (x > Pub[0] && x < Pub[0] + Pub[2] && y > Pub[1] && y < Pub[1] + Pub[3]) {
				game.enterState(5, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			} else if (x > Library[0] && x < Library[0] + Library[2] && y > Library[1] && y < Library[1] + Library[3]) {
				game.enterState(7, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			} else if (x > Math[0] && x < Math[0] + Math[2] && y > Math[1] && y < Math[1] + Math[3]) {
				game.enterState(8, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			} else if (x > Bussiness[0] && x < Bussiness[0] + Bussiness[2] && y > Bussiness[1] && y < Bussiness[1] + Bussiness[3]) {
				game.enterState(6, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			} else if (x > Classroom[0] && x < Classroom[0] + Classroom[2] && y > Classroom[1] && y < Classroom[1] + Classroom[3]) {
				game.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			} else if (x > Lounge[0] && x < Lounge[0] + Lounge[2] && y > Lounge[1] && y < Lounge[1] + Lounge[3]) {
				game.enterState(4, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
			
		}
		
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
