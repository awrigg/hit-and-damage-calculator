package br.com.wrigg.dnd.hitanddamage.feat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitanddamage.Type;
import br.com.wrigg.dnd.hitanddamage.feat.Feat;
import br.com.wrigg.dnd.hitanddamage.feat.FeatCatalog;

public class FeatCatalogTest {

	@Test
	public void findFeatByIdTest() {
		Feat feat = new Feat("divineMetamagic", "Divine Metamagic", Type.FEATURE_DEPENDENT);

		FeatCatalog featCatalog = new FeatCatalog();
		Feat featDTO = featCatalog.findFeatById("divineMetamagic");
		assertEquals(feat, featDTO);

		feat = new Feat("powerAttack", "Power Attack", Type.VARIABLE_IMPUT);

		featCatalog = new FeatCatalog();
		featDTO = featCatalog.findFeatById("powerAttack");
		assertEquals(feat, featDTO);
	}
}