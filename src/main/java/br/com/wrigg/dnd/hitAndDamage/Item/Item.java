package br.com.wrigg.dnd.hitAndDamage.Item;

import java.util.ArrayList;
import java.util.List;

import br.com.wrigg.dnd.hitAndDamage.character.Character;

public class Item {

	private String id;
	
	private String name;
	
	public Item() {
		
	}
	
	public Item(String id, String name) {
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
	public List<Item> values() {
		List<Item> items = new ArrayList<Item>();
		Item enlargePersonPotion = new Item("enlargePersonPotion", "Enlarge Person Potion");
		items.add(enlargePersonPotion);

		return items;
	}

	public void activate(Character character) {
		//FIXME tratar outros tipos de items
		character.increaseSize();
	}
	
	@Override
	public boolean equals(Object item) {
		Item itemToCompare = (Item) item;

		if((this.name == null && itemToCompare.getName() == null) || (this.name != null && this.name.equals(itemToCompare.getName())))
			if((this.id == null && itemToCompare.getId() == null) || (this.id != null && this.id.equals(itemToCompare.getId())))
				return true;
		
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}
}
