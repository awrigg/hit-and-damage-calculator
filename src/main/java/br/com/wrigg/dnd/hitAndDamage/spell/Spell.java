package br.com.wrigg.dnd.hitAndDamage.spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import br.com.wrigg.dnd.hitAndDamage.Type;
import br.com.wrigg.dnd.hitAndDamage.damage.DamageBonus;

public class Spell implements Observer {
	private String id;

	private String name;
	
	private Type type;
	
	private DamageBonus damageBonus;

	public Spell() {
		
	}
	
	public Spell(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Spell(String id, String name, Type type) {
		this.id = id;
		this.name = name;
		this.type = type;
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
	public List<Spell> values() {
		List<Spell> spells = new ArrayList<Spell>();
		Spell divineFavor = new Spell("divineFavor", "Divine Favor", Type.FEATURE_DEPENDENT);
		spells.add(divineFavor);

		return spells;
	}

	public String printDamageBonus() {
		if(damageBonus != null)
			return damageBonus.printDamageBonus();
		return "";
	}
	
	@Override
	public boolean equals(Object spell) {
		Spell spellToCompare = (Spell) spell;
		if((this.name == null && spellToCompare.getName() == null) || (this.name != null && this.name.equals(spellToCompare.getName()))) {
			if((this.id == null && spellToCompare.getId() == null) || this.id.equals(spellToCompare.getId()))
				return true;
		}
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return Spell.class.hashCode();
	}

	public void update(Observable character, Object feature) {
		//TODO pensar num pattern para deixar mais bonito [factoryMethod]
		if(Type.FEATURE_DEPENDENT.equals(type)) {
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
}
