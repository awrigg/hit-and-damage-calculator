package br.com.wrigg.dnd.hitAndDamage.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import br.com.wrigg.dnd.hitAndDamage._class.ClassFeature;
import br.com.wrigg.dnd.hitAndDamage._class.TurnLevel;
import br.com.wrigg.dnd.hitAndDamage.arsenal.Weapon;
import br.com.wrigg.dnd.hitAndDamage.feat.Feat;
import br.com.wrigg.dnd.hitAndDamage.spell.CasterLevel;
import br.com.wrigg.dnd.hitAndDamage.spell.Spell;

public class Character extends Observable {
	
	private Attribute strength;
	private Attribute charisma;
	
	private CasterLevel casterLevel;

	private Weapon weapon;
	
	private List<Feat> feats = new ArrayList<Feat>();
	
	private List<Spell> spells = new ArrayList<Spell>();
	
	private List<ClassFeature> classFeatures = new ArrayList<ClassFeature>();

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
	}
	
	public void castSpell(Spell spell) {
		if(spell != null) {
			spells.add(spell);
			this.addObserver(spell);
		}
	}
	
	public void activateClassFeature(ClassFeature classFeature) {
		if(classFeature != null) {
			classFeatures.add(classFeature);
			this.addObserver(classFeature);
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
        notifyObservers(casterLevel);
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
        notifyObservers(turnLevel);
	}

	public TurnLevel getTurnLevel() {
		return turnLevel;
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
										return true;
		}
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}

}
