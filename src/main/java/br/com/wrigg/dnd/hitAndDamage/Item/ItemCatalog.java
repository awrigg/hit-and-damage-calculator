package br.com.wrigg.dnd.hitAndDamage.Item;

import java.util.HashMap;
import java.util.Map;


public class ItemCatalog {
	private Map<String, Item> items = new HashMap<String, Item>();  

	public ItemCatalog() {
		Item enlargePersonPotion = new Item("enlargePersonPotion", "Enlarge Person Potion");

		items.put("enlargePersonPotion", enlargePersonPotion);
	}

	public Item findItemById(String itemId) {
		return items.get(itemId);
	}
}
