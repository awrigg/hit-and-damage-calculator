package br.com.wrigg.dnd.hitAndDamage;

import static org.junit.Assert.*;
import br.com.wrigg.dnd.hitAndDamage.character.Attribute;
import br.com.wrigg.dnd.hitAndDamage.character.Character;

import org.junit.Test;

public class FeatTest {

	@Test
	public void printFeatDamageBonusTest() {
		Feat feat = new Feat("divineMetamagic", "Divine Metamagic");

		Character character = new Character();
		character.getFeats().add(feat);
		
		Attribute cha = new Attribute(21);
		character.setCharisma(cha);
				
		String featBonusDamage = feat.printDamageBonus();
		assertEquals("+5", featBonusDamage.toString());
		
		cha = new Attribute(16);
		character.setCharisma(cha);

		featBonusDamage = feat.printDamageBonus();
		assertEquals("+3", featBonusDamage.toString());
	}
}