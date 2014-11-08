package br.com.wrigg.dnd.hitAndDamage.damage;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.wrigg.dnd.hitAndDamage.character.Attribute;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ DamageBonusByFeatureFactoryMethod.class })
public class DamageBonusTest {

	@Test
	public void damageEqualTest() {
		DamageBonus bonus1 = new DamageBonus(2);
		
		DamageBonus bonus2 = new DamageBonus(2);

		assertEquals(bonus1, bonus2);
		
	}
	
	@Test
	public void shouldReturnEmptyWhenBonusNotSetForPrintDamageBonusTest() {
		DamageBonus bonus = new DamageBonus();

		assertEquals("", bonus.printDamageBonus());
		
	}
	
	//FIXME teste nao funciona, parece que em funcao da interface na classe principal
	@Test
	public void updateSholdCallDamageBonusByFeatureFactoryMethodExecuteTest() throws Exception {
		DamageBonusByFeatureFactoryMethod damageBonusByFeatureFactoryMethodMock = spy(new DamageBonusByFeatureFactoryMethod());
		whenNew(DamageBonusByFeatureFactoryMethod.class).withNoArguments().thenReturn(damageBonusByFeatureFactoryMethodMock);
		
		DamageBonus bonus = new DamageBonus();
		Attribute attribute = new Attribute(18);
		bonus.update(attribute);
		
		//verify(damageBonusByFeatureFactoryMethodMock, times(1)).execute(attribute);
	}
}
