package br.com.wrigg.dnd.hitanddamage._class;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitanddamage.Type;
import br.com.wrigg.dnd.hitanddamage._class.ClassFeature;
import br.com.wrigg.dnd.hitanddamage._class.ClassFeatureCatalog;

public class ClassFeatureCatalogTest {

	@Test
	public void findClassFeatureByIdTest() {
		ClassFeature classFeature = new ClassFeature("smite", "Smite", Type.FEATURE_DEPENDENT);

		ClassFeatureCatalog classFeatureCatalog = new ClassFeatureCatalog();
		ClassFeature classFeatureFound = classFeatureCatalog.findClassFeatureById("smite");
		assertEquals(classFeature, classFeatureFound);
	}
}