package csRpg;

public class Item {
	private String name;
	private int effect;
	
	public Item(String name, int effect)
	{
		this.setName(name);
		this.setEffect(effect);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}
	
	
}
