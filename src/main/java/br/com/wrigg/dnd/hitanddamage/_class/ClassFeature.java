package br.com.wrigg.dnd.hitanddamage._class;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import br.com.wrigg.dnd.hitanddamage.Type;
import br.com.wrigg.dnd.hitanddamage.damage.DamageBonus;
import br.com.wrigg.dnd.hitanddamage.feat.Feat;

public class ClassFeature implements Observer{

	private String id;

	private String name;
	
	private DamageBonus damageBonus;
	
	private Type type;

	public ClassFeature() {
		
	}
	
	public ClassFeature(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public ClassFeature(String id, String name, Type type) {
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
	
	//FIXME tratar nulo
	public String printDamageBonus() {
		return damageBonus.printDamageBonus();
	}

	//FIXME criado para os testes iniciais
	public List<ClassFeature> values() {
		List<ClassFeature> classFeatures = new ArrayList<ClassFeature>();
		ClassFeature smite = new ClassFeature("smite", "Smite", Type.FEATURE_DEPENDENT);
		classFeatures.add(smite);
		
		return classFeatures;
	}

	public void update(Observable character, Object feature) {
		//TODO pensar num pattern para deixar mais bonito [factoryMethod]
		if(feature instanceof TurnLevel) {
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
	
	@Override
	public boolean equals(Object classFeature) {
		if(classFeature instanceof ClassFeature) {
			ClassFeature classFeatureToCompare = (ClassFeature) classFeature;
			if((this.name == null && classFeatureToCompare.getName() == null) || (this.name != null && this.name.equals(classFeatureToCompare.getName()))) {
				if((this.id == null && classFeatureToCompare.getId() == null) || this.id.equals(classFeatureToCompare.getId()))
					if((this.type == null && classFeatureToCompare.getType() == null) || this.type.equals(classFeatureToCompare.getType()))
						if((this.damageBonus == null && classFeatureToCompare.getDamageBonus() == null) || (this.damageBonus != null && this.damageBonus.equals(classFeatureToCompare.getDamageBonus())))
							return true;
			}
		}
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return Feat.class.hashCode();
	}
}
