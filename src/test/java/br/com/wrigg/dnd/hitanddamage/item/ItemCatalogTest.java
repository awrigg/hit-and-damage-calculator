package br.com.wrigg.dnd.hitanddamage.item;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitanddamage.Item.Item;
import br.com.wrigg.dnd.hitanddamage.Item.ItemCatalog;

public class ItemCatalogTest {

	@Test
	public void findItemByIdTest() {
		Item enlargePersonPotion = new Item("enlargePersonPotion", "Enlarge Person Potion");

		ItemCatalog itemCatalog = new ItemCatalog();
		Item enlargePersonPotionDTO = itemCatalog.findItemById("enlargePersonPotion");
		assertEquals(enlargePersonPotion, enlargePersonPotionDTO);
	}
}