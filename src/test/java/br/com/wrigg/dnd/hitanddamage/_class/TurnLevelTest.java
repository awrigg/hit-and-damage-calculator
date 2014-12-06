package br.com.wrigg.dnd.hitanddamage._class;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitanddamage._class.TurnLevel;

public class TurnLevelTest {
	
	@Test
	public void classFeatureEqualsTest() {
		TurnLevel turnLevel1 = new TurnLevel(5);

		TurnLevel turnLevel2 = new TurnLevel(5);

		assertEquals(turnLevel1, turnLevel2);
	}	
}
