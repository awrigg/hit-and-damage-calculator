package br.com.wrigg.dnd.hitAndDamage._class;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitAndDamage.Type;

public class ClassFeatureCatalogTest {

	@Test
	public void findClassFeatureByIdTest() {
		ClassFeature classFeature = new ClassFeature("smite", "Smite", Type.FEATURE_DEPENDENT);

		ClassFeatureCatalog classFeatureCatalog = new ClassFeatureCatalog();
		ClassFeature classFeatureFound = classFeatureCatalog.findClassFeatureById("smite");
		assertEquals(classFeature, classFeatureFound);
	}
}