package br.com.wrigg.dnd.hitAndDamage.feat;

import java.util.HashMap;
import java.util.Map;


public class FeatCatalog {
	private Map<String, Feat> feats = new HashMap<String, Feat>();  

	public FeatCatalog() {
		Feat divineMetamagic = new Feat("divineMetamagic", "Divine Metamagic", Feat.Type.FEATURE_DEPENDENT);
		Feat powerAttack = new Feat("powerAttack", "Power Attack", Feat.Type.VARIABLE_IMPUT);
		Feat knowledgeDevotion = new Feat("knowledgeDevotion", "Knowledge Devotion", Feat.Type.VARIABLE_IMPUT);
		
		feats.put("divineMetamagic", divineMetamagic);
		feats.put("powerAttack", powerAttack);
		feats.put("knowledgeDevotion", knowledgeDevotion);
	}

	public Feat findFeatById(String featId) {
		return feats.get(featId);
	}
}