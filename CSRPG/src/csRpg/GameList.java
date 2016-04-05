package csRpg;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;


public class GameList extends AbstractComponent {
	
	private int X;
	private int Y;
	private int width;
	private int height;
	private String name;
	private Color color;
	private Boolean solid;
	private int numItems;
	
	// Specific boolean to tell to render list looking like the inventory
	private Boolean isInventory = false;
	private Inventory inventory;
	
	private Boolean isHighscore = false;
	
	public GameList(GUIContext container, String name, Color color, int num_items, Boolean solid){
		super(container);
		
		this.X = 0;
		this.Y = 0;
		this.width = name.length() * 10;
		this.height = 20 * num_items;
		this.numItems = num_items;
		this.name = name;
		this.color = color;
		this.solid = solid;
	}
	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.X;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.Y;
	}

	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		if (this.solid){

			// Adding to list
			if (isHighscore){
				g.setColor(Color.black);
				g.drawRect(this.X,this.Y,this.width,this.height);
				
				// Filling
				g.setColor(this.color);
				g.fillRect(this.X,this.Y,this.width,this.height);
				
				g.setColor(Color.black);
				
				for (int i = 0; i < numItems; i++) {
					g.drawString(this.name, this.X, this.Y + 20*i);
				}
				
			} else if (isInventory) {
				
				this.width = 40;
				
				g.setColor(Color.black);
				g.drawRect(this.X,this.Y,this.width,this.height);
				
				// Filling
				g.setColor(this.color);
				g.fillRect(this.X,this.Y,this.width,this.height);
				
				g.setColor(Color.black);
				
				for (int i = 0; i < inventory.numItems(); i++) {
					Item curItem = this.inventory.getItem(i);
					g.drawString(curItem.getName(), this.X, this.Y + 20*i);
				}
			}
		} else {
			// Adding to list
			g.setColor(this.color);
			for (int i = 0; i < numItems; i++) {
				g.drawString(this.name, this.X, this.Y + 20*i);
			}
		}

	}
	@Override
	public void setLocation(int x, int y) {
		this.X = x;
		this.Y = y;
		
	}
	public void setInventoryList(Inventory inventory){
		isInventory = true;
		this.inventory = inventory;
		
	}
	
}
