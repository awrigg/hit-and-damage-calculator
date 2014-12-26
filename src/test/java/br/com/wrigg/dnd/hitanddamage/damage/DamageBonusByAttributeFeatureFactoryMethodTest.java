package br.com.wrigg.dnd.hitanddamage.damage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.wrigg.dnd.hitanddamage.character.Attribute;
import br.com.wrigg.dnd.hitanddamage.damage.DamageBonusByAttributeFeatureFactoryMethod;

@RunWith(JUnit4.class)
public class DamageBonusByAttributeFeatureFactoryMethodTest {

	@Test
	public void executeDamageBonusByAttributeFeatureTest() {
		DamageBonusByAttributeFeatureFactoryMethod damageBonusByAttributeFeatureFactoryMethod = new DamageBonusByAttributeFeatureFactoryMethod();
		
		Attribute attribute = new Attribute(18);
		
		int damageBonus = damageBonusByAttributeFeatureFactoryMethod.execute(attribute);
		assertEquals(4, damageBonus);
		
		attribute = new Attribute(16);
		
		damageBonus = damageBonusByAttributeFeatureFactoryMethod.execute(attribute);
		assertEquals(3, damageBonus);
	}
}
