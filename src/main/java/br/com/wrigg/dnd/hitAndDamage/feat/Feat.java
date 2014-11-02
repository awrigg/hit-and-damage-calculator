package br.com.wrigg.dnd.hitAndDamage.feat;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import br.com.wrigg.dnd.hitAndDamage.damage.DamageBonus;

public class Feat implements Observer {
	public enum Type {
		VARIABLE_IMPUT, FEATURE_DEPENDENT 
	}
	
	private String id;

	private String name;
	
	private Type type;

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

	public Feat(String id, String name, Type featureDependent) {
		this.id = id;
		this.name = name;
		this.type = featureDependent;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public DamageBonus getDamageBonus() {
		return damageBonus;
	}

	public void setDamageBonus(DamageBonus damageBonus) {
		this.damageBonus = damageBonus;
	}
	
	//FIXME apenas para os testes iniciais
	public List<Feat> values() {
		List<Feat> feats = new ArrayList<Feat>();
		Feat divineMetamagic = new Feat("divineMetamagic", "Divine Metamagic");
		divineMetamagic.setType(Type.FEATURE_DEPENDENT);
		feats.add(divineMetamagic);

		Feat powerAttack = new Feat("powerAttack", "Power Attack");
		powerAttack.setType(Type.VARIABLE_IMPUT);
		feats.add(powerAttack);
		
		Feat knowledgeDevotion = new Feat("knowledgeDevotion", "Knowledge Devotion");
		knowledgeDevotion.setType(Type.VARIABLE_IMPUT);
		feats.add(knowledgeDevotion);
		
		return feats;
	}

	public String printDamageBonus() {
		if(damageBonus != null)
			return damageBonus.printDamageBonus();
		return "";
	}

	@Override
	public void update(Observable character, Object feature) {
		//TODO pensar num pattern para deixar mais bonito [factoryMethod]
		if(Feat.Type.FEATURE_DEPENDENT.equals(type)) {
			if(feature != null) {
				if(damageBonus != null)
					damageBonus.update(feature);
				else {
					damageBonus = new DamageBonus();
					damageBonus.update(feature);
				}
			}
		}
	}
	
	@Override
	public boolean equals(Object feat) {
		Feat featToCompare = (Feat) feat;
		if((this.name == null && featToCompare.getName() == null) || (this.name != null && this.name.equals(featToCompare.getName()))) {
			if((this.id == null && featToCompare.getId() == null) || this.id.equals(featToCompare.getId()))
				if((this.type == null && featToCompare.getType() == null) || this.type.equals(featToCompare.getType()))
					if((this.damageBonus == null && featToCompare.getDamageBonus() == null) || (this.damageBonus != null && this.damageBonus.equals(featToCompare.getDamageBonus())))
						return true;
		}
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return Feat.class.hashCode();
	}
}
