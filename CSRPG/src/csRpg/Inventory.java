package csRpg;

import java.util.ArrayList;

public class Inventory implements java.io.Serializable {
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
	public void defaultInventory(){
		// ------------------------------------
		Item i1 = new Item("Food", 0);
		Item i2 = new Item("Beer", 1);
		Item i3 = new Item("Beer", 1);
		
		items.add(i1);
		items.add(i2);
		items.add(i3);
		// -------------------------------------------------------------
	}
	
}
