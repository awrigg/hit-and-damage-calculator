package br.com.wrigg.dnd.hitAndDamage.damage;

import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.wrigg.dnd.hitAndDamage.character.Attribute;
import br.com.wrigg.dnd.hitAndDamage.character.CasterLevel;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ DamageBonusByFeatureFactoryMethod.class })
public class DamageBonusByFeatureFactoryMethodTest {

	@Test
	public void DamageBonusByFeatureCreationTest() throws Exception {
		DamageBonusByCasterLevelFactoryMethod damageBonusByCasterLevelFactoryMethodMock = spy(new DamageBonusByCasterLevelFactoryMethod());
	    
		whenNew(DamageBonusByCasterLevelFactoryMethod.class).withNoArguments().thenReturn(damageBonusByCasterLevelFactoryMethodMock);
		
		CasterLevel casterLevelFeature = new CasterLevel(6);
		
		DamageBonusByFeature damageBonusByFeature = new DamageBonusByFeatureFactoryMethod();
		damageBonusByFeature.execute(casterLevelFeature);

		verifyPrivate(damageBonusByCasterLevelFactoryMethodMock, times(1)).invoke("execute", casterLevelFeature);

		DamageBonusByAttributeFeatureFactoryMethod damageBonusByAttributeFeatureFactoryMethodMock = spy(new DamageBonusByAttributeFeatureFactoryMethod());
	    
		whenNew(DamageBonusByAttributeFeatureFactoryMethod.class).withNoArguments().thenReturn(damageBonusByAttributeFeatureFactoryMethodMock);

		Attribute attributeFeature = new Attribute(18);
		
		damageBonusByFeature = new DamageBonusByFeatureFactoryMethod();
		damageBonusByFeature.execute(attributeFeature);

		verifyPrivate(damageBonusByAttributeFeatureFactoryMethodMock, times(1)).invoke("execute", attributeFeature);
	}
}
