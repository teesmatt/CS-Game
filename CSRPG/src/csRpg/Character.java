package csRpg;

import org.newdawn.slick.SlickException;

public class Character extends Entity implements java.io.Serializable {
	
	private String name;
	private int intelligence;
	private int endurance;
	private int alcohol_tolerance;
	private Inventory inventory;
	private double gpa;
	private int health;
	private int sanity;
	private int[] credits;
	private int alignment;
	private String location;
	private boolean isBuis;
	private int[] miniGameScore;
	
	private String imgPath;

	// the time left in the game
	public float timer;
	
	
	// records where the player has gone once they have started the business game
	private int[] buisnessed;
	
	public Character(String name, 
			int intelligence, 
			int endurance, 
			int alcohol_tolerance, 
			int alignment, 
			String image, 
			Inventory inventory) throws SlickException {	
		super(image);
		
		this.inventory = inventory;
		this.imgPath = image;
		this.name = name;
		this.intelligence = intelligence;
		this.endurance = endurance;
		this.alcohol_tolerance = alcohol_tolerance;
		this.alignment = alignment;
		
		this.timer = 600; // 10 minutes
		
		this.health = 100;
		this.sanity = 100;
		this.gpa = 0;
		this.credits = new int[5];
		this.miniGameScore = new int[5];
		
		this.isBuis = false;
		
		this.buisnessed = new int[5];
		
		this.location = "Map";
	}
	public String getImagePath() {
		return imgPath;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		
		this.location = location;
		
	}
	
	public boolean hasBuisnessed(int roomID) {
		
		if (this.buisnessed[roomID - 3] == 1) {
			return true;
		}
		return false;
		
	}

	public void doBuisnessed(int roomID) {
		
		this.buisnessed[roomID - 3] = 1;
		this.timer -= 15;
		
	}
	
	public boolean doneBuisnessed() {
		
		for(int u : buisnessed) {
			if (u == 0) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public int getAlignment() {
		return alignment;
	}

	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

	public boolean hasCompleted() {
		for(int u : credits) {
			if (u == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int getCredits(int index) {
		return credits[index];
	}

	public void setCredits(int[] credits) {
		this.credits = credits;
	}
	
	public void addCredit(int credit) {
		if (credit < 5)
		{
			this.credits[credit] = 1;
		}
	}

	public int getSanity() {
		return sanity;
	}

	public void setSanity(int sanity) {
		this.sanity = sanity;
	}
	
	public int calcSanity(int sanity) {
		this.sanity += sanity + this.intelligence;
		return this.sanity;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public int calcHealth(int health) {
		this.health += health + this.endurance;
		return this.health;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public double calcGpa(double gpa) {
		this.gpa += gpa;
		return this.gpa + gpa;
	}
	
	public double finalGpa() {
		return this.gpa/5;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getAlcohol_tolerance() {
		return alcohol_tolerance;
	}

	public void setAlcohol_tolerance(int alcohol_tolerance) {
		this.alcohol_tolerance = alcohol_tolerance;
	}
	
	public void addItem(Item item) {
		inventory.addItem(item);
	}
	
	public void useItem(int index) {
		Item temp = inventory.getItem(index);
		int effect = temp.getEffect();
		
		// Add effect for each effect. See documentation.
		switch(effect) {
		// Effect 1 = Food Health Increase
		case 0: this.calcHealth(20);
				break;
		// Effect 2 = Beer Sanity Increase
		case 1: this.calcSanity(20 + this.alcohol_tolerance);
				break;
		
		}
		
//		inventory.removeItem(temp);
	}
	
	public boolean getBuis() {
		return this.isBuis;
	}
	
	public void setBuis(boolean buis) {
		this.isBuis = buis;
	}
	
	public void setMiniGameScore(int index, int score)
	{
		this.miniGameScore[index] = score;
	}
	
	public int getMiniGameScore(int index)
	{
		return this.miniGameScore[index];
	}
}
