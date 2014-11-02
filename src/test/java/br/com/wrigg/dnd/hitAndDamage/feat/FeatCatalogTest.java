package br.com.wrigg.dnd.hitAndDamage.feat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FeatCatalogTest {

	@Test
	public void findFeatByIdTest() {
		Feat feat = new Feat("divineMetamagic", "Divine Metamagic", Feat.Type.FEATURE_DEPENDENT);

		FeatCatalog featCatalog = new FeatCatalog();
		Feat featDTO = featCatalog.findFeatById("divineMetamagic");
		assertEquals(feat, featDTO);

		feat = new Feat("powerAttack", "Power Attack", Feat.Type.VARIABLE_IMPUT);

		featCatalog = new FeatCatalog();
		featDTO = featCatalog.findFeatById("powerAttack");
		assertEquals(feat, featDTO);
	}
}