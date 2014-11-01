package br.com.wrigg.dnd.hitAndDamage.feat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FeatCatalogTest {

	@Test
	public void findFeatByNameTest() {
		Feat feat = new Feat("divineMetamagic", "Divine Metamagic", Feat.Type.FEATURE_DEPENDENT);

		FeatCatalog featCatalog = new FeatCatalog();
		Feat featDTO = featCatalog.findFeatByName("Divine Metamagic");
		assertEquals(feat, featDTO);

		feat = new Feat("powerAttack", "Power Attack", Feat.Type.VARIABLE_IMPUT);

		featCatalog = new FeatCatalog();
		featDTO = featCatalog.findFeatByName("Power Attack");
		assertEquals(feat, featDTO);
	}
}