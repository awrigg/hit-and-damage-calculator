package br.com.wrigg.dnd.hitAndDamage.item;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitAndDamage.Item.Item;
import br.com.wrigg.dnd.hitAndDamage.character.Character;

public class ItemTest {
	@Test
	public void activateTest() {
		Character character = mock(Character.class);

		Item enlargePersonPotion = new Item();
		enlargePersonPotion.activate(character);
		
		verify(character).increaseSize();
	}

	@Test
	public void equalsTest() {
		Item item1 = new Item("enlargePersonPotion", "Enlarge Person Potion");
		
		Item item2 = new Item("enlargePersonPotion", "Enlarge Person Potion");
		
		assertEquals(item1, item2);
	}
}
