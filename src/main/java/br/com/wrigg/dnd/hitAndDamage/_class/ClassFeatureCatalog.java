package br.com.wrigg.dnd.hitAndDamage._class;

import java.util.HashMap;
import java.util.Map;

import br.com.wrigg.dnd.hitAndDamage.Type;

public class ClassFeatureCatalog {

	private Map<String, ClassFeature> classFeatures = new HashMap<String, ClassFeature>();  

	public ClassFeatureCatalog() {
		ClassFeature smite = new ClassFeature("smite", "Smite", Type.FEATURE_DEPENDENT);
		
		classFeatures.put("smite", smite);
	}
	
	public ClassFeature findClassFeatureById(String classFeatureId) {
		return classFeatures.get(classFeatureId);
	}
}
