package csRpg;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public class Button extends AbstractComponent {

	private int X;
	private int Y;
	private int width;
	private int height;
	private String name;
	private Color color;
	private Boolean solid;
	
	public Button(GUIContext container, String name, Color color, Boolean solid) {
		super(container);
		
		this.X = 0;
		this.Y = 0;
		this.width = name.length() * 10;
		this.height = 20;
		this.name = name;
		this.color = color;
		this.solid = solid;
		
	}
	public String getName(){
		return this.name;
	}
	@Override
	public int getHeight() {
		
		return this.height;
		
	}

	@Override
	public int getWidth() {
		
		return this.width;
		
	}

	@Override
	public int getX() {
		
		return this.X;
		
	}

	@Override
	public int getY() {
		
		return this.Y;
		
	}
	
	@Override
	public void render(GUIContext context, Graphics g) throws SlickException {
		
		if (this.solid) {
			
			// Draws a rectangle around the text of the button, also serves as the bounding box
			g.setColor(Color.black);
			g.drawRect(this.X,this.Y,this.width,this.height);
			g.setColor(this.color);
			g.fillRect(this.X,this.Y,this.width,this.height);
			// Prints the string of the button
			g.setColor(Color.black);
			g.drawString(name,this.X,this.Y);
			
		} else {
		
			// Prints the string of the button
			g.setColor(this.color);
			g.drawString(name,this.X,this.Y);
			
		}
		
	}

	@Override
	public void setLocation(int x, int y) {
		
		this.X = x;
		this.Y = y;

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean ButtonPressed(int x, int y) {
		
		if (x > this.X && x < this.X + this.width && y > this.Y && y < this.Y + this.height) {
			return true;
		}
		return false;
		
	}

}
