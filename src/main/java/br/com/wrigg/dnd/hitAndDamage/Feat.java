package br.com.wrigg.dnd.hitAndDamage;

import java.util.ArrayList;
import java.util.List;

public class Feat {
	
	private String name;

	public Feat(String name) {
		this.name = name;
	}

	public Feat() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//FIXME apenas para os testes iniciais
	public List<Feat> values() {
		List<Feat> feats = new ArrayList<Feat>();
		feats.add(new Feat("Divine Metamagic"));
		
		return feats;
	}
}
