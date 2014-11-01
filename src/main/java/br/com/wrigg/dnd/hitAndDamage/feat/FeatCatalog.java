package br.com.wrigg.dnd.hitAndDamage.feat;

import java.util.HashMap;
import java.util.Map;


public class FeatCatalog {
	private Map<String, Feat> feats = new HashMap<String, Feat>();  

	public FeatCatalog() {
		Feat divineMetamagic = new Feat("divineMetamagic", "Divine Metamagic", Feat.Type.FEATURE_DEPENDENT);
		Feat powerAttack = new Feat("powerAttack", "Power Attack", Feat.Type.VARIABLE_IMPUT);
		
		feats.put("Divine Metamagic", divineMetamagic);
		feats.put("Power Attack", powerAttack);
	}

	public Feat findFeatByName(String featName) {
		return feats.get(featName);
	}
}
