package br.com.wrigg.dnd.hitanddamage.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import br.com.wrigg.dnd.hitanddamage.Type;
import br.com.wrigg.dnd.hitanddamage.Item.Item;
import br.com.wrigg.dnd.hitanddamage._class.ClassFeature;
import br.com.wrigg.dnd.hitanddamage._class.TurnLevel;
import br.com.wrigg.dnd.hitanddamage.arsenal.Weapon;
import br.com.wrigg.dnd.hitanddamage.feat.Feat;
import br.com.wrigg.dnd.hitanddamage.spell.CasterLevel;
import br.com.wrigg.dnd.hitanddamage.spell.Spell;

public class Character extends Observable {
	
	private Attribute strength;
	private Attribute charisma;
	
	private CasterLevel casterLevel;

	private Weapon weapon;
	
	private List<Feat> feats = new ArrayList<Feat>();
	
	private List<Spell> spells = new ArrayList<Spell>();
	
	private List<ClassFeature> classFeatures = new ArrayList<ClassFeature>();
	
	private List<Item> items = new ArrayList<Item>();

	private TurnLevel turnLevel;
	
	public void equip(Weapon weapon) {
		setWeapon(weapon);
	}

	public void setWeapon(Weapon weapon) {		
		this.weapon = weapon;
	}
	
	public Weapon getWeapon() {		
		return weapon;
	}

	public Attribute getStrength() {
		return strength;
	}

	public void setStrength(Attribute strength) {
		this.strength = strength;
	}

	public Attribute getCharisma() {
		return charisma;
	}

	public void setCharisma(Attribute charisma) {
		this.charisma = charisma;

		setChanged();
        notifyObservers(charisma);
	}
	
	public List<Feat> getFeats() {
		return feats;
	}

	public void setFeats(List<Feat> feats) {
		this.feats = feats;
	}
	
	public void activateFeat(Feat feat) {
		if(feat != null) {
			feats.add(feat);
			this.addObserver(feat);
		}
		
		if(Type.FEATURE_DEPENDENT.equals(feat.getType())) {
			if(charisma != null) {
				setChanged();
		        notifyObservers(charisma);
			}
		}
	}
	
	public void castSpell(Spell spell) {
		if(spell != null) {
			spells.add(spell);
			this.addObserver(spell);
		}
		
		if(Type.FEATURE_DEPENDENT.equals(spell.getType())) {
			if(casterLevel != null) {
				setChanged();
		        notifyObservers(casterLevel);
			}
		}
	}
	
	public void activateClassFeature(ClassFeature classFeature) {
		if(classFeature != null) {
			classFeatures.add(classFeature);
			this.addObserver(classFeature);
		}
		
		
		if(Type.FEATURE_DEPENDENT.equals(classFeature.getType())) {
			if(turnLevel != null) {
				setChanged();
		        notifyObservers(turnLevel);
			}
		}
	}
	
	public List<Spell> getSpells() {
		return spells;
	}

	public void setSpells(List<Spell> spells) {
		this.spells = spells;
	}
	
	public CasterLevel getCasterLevel() {
		return casterLevel;
	}

	public void setCasterLevel(CasterLevel casterLevel) {
		this.casterLevel = casterLevel;

		setChanged();

		if(casterLevel != null) {
	        notifyObservers(casterLevel);
		} else {
	        notifyObservers(new CasterLevel(0));
		}
	}

	
	public List<ClassFeature> getClassFeatures() {
		return classFeatures;
	}

	public void setClassFeatures(List<ClassFeature> classFeatures) {
		this.classFeatures = classFeatures;
	}
	
	public void setTurnLevel(TurnLevel turnLevel) {
		this.turnLevel = turnLevel;
		
		setChanged();
		
		if(turnLevel != null) {
			notifyObservers(turnLevel);
		} else {
	        notifyObservers(new TurnLevel(0));
		}
	}

	public TurnLevel getTurnLevel() {
		return turnLevel;
	}
		
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void activateItem(Item item) {
		this.items.add(item);
		
		item.activate(this);
	}
	
	public void increaseSize() {
		weapon.increaseSize();
	}
	
	@Override
	public boolean equals(Object character) {
		Character characterToCompare = (Character) character;
		if((this.weapon == null && characterToCompare.getWeapon() == null) || this.weapon.equals(characterToCompare.getWeapon())) {
			if((this.strength == null && characterToCompare.getStrength() == null) || this.strength.equals(characterToCompare.getStrength()))
				if((this.charisma == null && characterToCompare.getCharisma() == null) || this.charisma.equals(characterToCompare.getCharisma()))
					if((this.feats == null && characterToCompare.getFeats() == null) || this.feats.equals(characterToCompare.getFeats()))
						if((this.spells == null && characterToCompare.getSpells() == null) || this.spells.equals(characterToCompare.getSpells()))
							if((this.casterLevel == null && characterToCompare.getCasterLevel() == null) || (this.casterLevel != null && this.casterLevel.equals(characterToCompare.getCasterLevel())))
								if((this.turnLevel == null && characterToCompare.getTurnLevel() == null) || (this.turnLevel != null && this.turnLevel.equals(characterToCompare.getTurnLevel())))
									if((this.classFeatures == null && characterToCompare.getClassFeatures() == null) || (this.classFeatures != null && this.classFeatures.equals(characterToCompare.getClassFeatures())))
										if((this.items == null && characterToCompare.getItems() == null) || (this.items != null && this.items.equals(characterToCompare.getItems())))
											return true;
		}
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}

	public void deactivateFeat(Feat feat) {
		feats.remove(feat);		
	}

	public void cancelSpell(Spell spell) {
		spells.remove(spell);		
	}

	public void deactivateClassFeature(ClassFeature classFeature) {
		classFeatures.remove(classFeature);		
	}
}
