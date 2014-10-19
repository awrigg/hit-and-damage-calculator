package br.com.wrigg.dnd.hitAndDamage;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import br.com.wrigg.dnd.hitAndDamage.damage.DamageBonus;

public class Feat implements Observer {
	
	private String id;

	private String name;

	private DamageBonus damageBonus;
	
	public Feat() {
		
	}

	public Feat(String name) {
		this.name = name;
	}

	public Feat(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		feats.add(new Feat("divineMetamagic", "Divine Metamagic"));
		
		return feats;
	}

	public String printDamageBonus() {		
		return damageBonus.printDamageBonus();
	}

	@Override
	public void update(Observable character, Object feature) {
		if(damageBonus != null) 
			damageBonus.update(feature);
		else {
			damageBonus = new DamageBonus();
			damageBonus.update(feature);
		}
	}
}
