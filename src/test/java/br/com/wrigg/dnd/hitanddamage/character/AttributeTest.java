package br.com.wrigg.dnd.hitanddamage.character;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.wrigg.dnd.hitanddamage.character.Attribute;

@RunWith(MockitoJUnitRunner.class)
public class AttributeTest {

	@Test
	public void printBonusTest() {
		Attribute str = new Attribute(18);
		
		assertEquals("+4", str.printBonus());
		
		str = new Attribute(16);
		
		assertEquals("+3", str.printBonus());
	}

	@Test
	public void printBonusShowldReturnEmptyWhenNoBonusAreSetTest() {
		Attribute str = new Attribute();
		
		assertEquals("", str.printBonus());
	}
	
	@Test
	public void attributeEqualsTest() {
		Attribute str1 = new Attribute(18);

		Attribute str2 = new Attribute(18);
		
		assertEquals(str1, str2);
	}
	
	@Test
	public void increaseByTwoShouldAddTwoToTheAttributeValueTest() {
		Attribute str = new Attribute(20);
		
		Attribute str2 = new Attribute(18);
		str2.add(2);
		
		assertEquals(str, str2);
	}	
}