package br.com.wrigg.dnd.hitanddamage.spell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitanddamage.spell.CasterLevel;

public class CasterLevelTest {
	
	@Test
	public void casterLevelEqualTest() {
		CasterLevel casterLevel1 = new CasterLevel(5);
		
		CasterLevel casterLevel2 = new CasterLevel(5);
		
		assertEquals(casterLevel1, casterLevel2);
	}
}
