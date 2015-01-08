package br.com.wrigg.dnd.hitanddamage.feat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitanddamage.Type;
import br.com.wrigg.dnd.hitanddamage.character.Attribute;
import br.com.wrigg.dnd.hitanddamage.character.Character;
import br.com.wrigg.dnd.hitanddamage.damage.DamageBonus;
import br.com.wrigg.dnd.hitanddamage.feat.Feat;

public class FeatTest {

	@Test
	public void printDivineMetamagicDamageBonusTest() {
		Feat feat = new Feat("divineMetamagic", "Divine Metamagic", Type.FEATURE_DEPENDENT);

		Character character = new Character();
		character.activateFeat(feat);
		
		Attribute cha = new Attribute(21);
		character.setCharisma(cha);
				
		String featBonusDamage = feat.printDamageBonus();
		assertEquals("+5", featBonusDamage.toString());
		
		cha = new Attribute(16);
		character.setCharisma(cha);

		featBonusDamage = feat.printDamageBonus();
		assertEquals("+3", featBonusDamage.toString());
	}
	
	@Test
	public void settingCharismaBeforeDivineMetamagicShouldUpdateDamageBonusTest() {
		Feat feat = new Feat("divineMetamagic", "Divine Metamagic", Type.FEATURE_DEPENDENT);

		Character character = new Character();

		Attribute cha = new Attribute(18);
		character.setCharisma(cha);

		character.activateFeat(feat);
		
		String featBonusDamage = feat.printDamageBonus();
		assertEquals("+4", featBonusDamage.toString());
	}
	
	@Test
	public void powerAttackShowldNotChangeBonusValueWithChaChangesTest() {
		Feat feat = new Feat("powerAttack", "Power Attack");
		DamageBonus damageBonus = new DamageBonus(4);
		feat.setDamageBonus(damageBonus);

		Character character = new Character();
		character.activateFeat(feat);

		String featBonusDamage = feat.printDamageBonus();
		assertEquals("+4", featBonusDamage.toString());

		Attribute cha = new Attribute(21);
		character.setCharisma(cha);
				
		featBonusDamage = feat.printDamageBonus();
		assertEquals("+4", featBonusDamage.toString());
	}

	@Test
	public void featEqualsTest() {
		Feat feat1 = new Feat("divineMetamagic", "Divine Metamagic");

		Feat feat2 = new Feat("divineMetamagic", "Divine Metamagic");

		assertEquals(feat1, feat2);

		feat1 = new Feat("divineMetamagic", "Divine Metamagic");
		feat1.setDamageBonus(new DamageBonus(4));

		feat2 = new Feat("divineMetamagic", "Divine Metamagic");
		feat2.setDamageBonus(new DamageBonus(4));

		assertEquals(feat1, feat2);
	}
	
	@Test
	public void featEqualsShowldMatchTypeTest() {
		Feat feat1 = new Feat("divineMetamagic", "Divine Metamagic", Type.FEATURE_DEPENDENT);

		Feat feat2 = new Feat("divineMetamagic", "Divine Metamagic");

		assertNotEquals(feat1, feat2);

		feat1 = new Feat("divineMetamagic", "Divine Metamagic", Type.FEATURE_DEPENDENT);
		
		feat2 = new Feat("divineMetamagic", "Divine Metamagic", Type.FEATURE_DEPENDENT);

		assertEquals(feat1, feat2);
	}
}