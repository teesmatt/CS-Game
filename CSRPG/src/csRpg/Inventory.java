package csRpg;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> items;

	public Inventory()
	{
		items = new ArrayList<Item>();
	}

	public void addItem(Item item)
	{
		items.add(item);
	}
	
	public void removeItem(Item item)
	{
		if(items.isEmpty())
			return;
		else
			items.remove(item);
	}
	
	public int numItems()
	{
		return items.size();
	}
	
	public Item getItem(int n)
	{
		return items.get(n);
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	
}
