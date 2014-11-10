package br.com.wrigg.dnd.hitAndDamage.item;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitAndDamage.Item.Item;
import br.com.wrigg.dnd.hitAndDamage.Item.ItemCatalog;

public class ItemCatalogTest {

	@Test
	public void findItemByIdTest() {
		Item enlargePersonPotion = new Item("enlargePersonPotion", "Enlarge Person Potion");

		ItemCatalog itemCatalog = new ItemCatalog();
		Item enlargePersonPotionDTO = itemCatalog.findItemById("enlargePersonPotion");
		assertEquals(enlargePersonPotion, enlargePersonPotionDTO);
	}
}