package br.com.wrigg.dnd.hitAndDamage._class;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TurnLevelTest {
	
	@Test
	public void classFeatureEqualsTest() {
		TurnLevel turnLevel1 = new TurnLevel(5);

		TurnLevel turnLevel2 = new TurnLevel(5);

		assertEquals(turnLevel1, turnLevel2);
	}	
}
