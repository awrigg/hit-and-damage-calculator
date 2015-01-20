package br.com.wrigg.dnd.hitanddamage._class;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitanddamage.Type;
import br.com.wrigg.dnd.hitanddamage._class.ClassFeature;
import br.com.wrigg.dnd.hitanddamage._class.TurnLevel;
import br.com.wrigg.dnd.hitanddamage.character.Character;

public class ClassFeatureTest {

	@Test
	public void printSmiteDamageBonusTest() {
		ClassFeature smite = new ClassFeature("smite", "Smite", Type.FEATURE_DEPENDENT);

		Character character = new Character();
		character.activateClassFeature(smite);
		
		character.setTurnLevel(new TurnLevel(5));

		String smiteDamageBonus = smite.printDamageBonus();
		assertEquals("+5", smiteDamageBonus.toString());
		
		character.setTurnLevel(new TurnLevel(3));

		smiteDamageBonus = smite.printDamageBonus();
		assertEquals("+3", smiteDamageBonus.toString());
	}
	
	@Test
	public void settingTurnLevelBeforeActivatingSmiteShouldShowDamageBonusTest() {
		ClassFeature smite = new ClassFeature("smite", "Smite", Type.FEATURE_DEPENDENT);

		Character character = new Character();
		character.setTurnLevel(new TurnLevel(5));

		character.activateClassFeature(smite);

		String smiteDamageBonus = smite.printDamageBonus();
		assertEquals("+5", smiteDamageBonus.toString());
	}
	
	@Test
	public void settingTurnLevelNullShouldShowNoSmiteDamageBonusTest() {
		ClassFeature smite = new ClassFeature("smite", "Smite", Type.FEATURE_DEPENDENT);

		Character character = new Character();
		character.setTurnLevel(new TurnLevel(5));

		character.activateClassFeature(smite);

		String smiteDamageBonus = smite.printDamageBonus();
		assertEquals("+5", smiteDamageBonus.toString());
		
		character.setTurnLevel(null);
		
		smiteDamageBonus = smite.printDamageBonus();
		assertEquals("+0", smiteDamageBonus.toString());
	}
	
	@Test
	public void classFeatureEqualsTest() {
		ClassFeature smite1 = new ClassFeature("smite", "Smite", Type.FEATURE_DEPENDENT);
		
		ClassFeature smite2 = new ClassFeature("smite", "Smite", Type.FEATURE_DEPENDENT);
		
		assertEquals(smite1, smite2);
	}	
}
