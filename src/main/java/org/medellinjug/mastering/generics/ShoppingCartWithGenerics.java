package org.medellinjug.mastering.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ecabrerar
 * @date Jun 3, 2020
 *
 */
public class ShoppingCartWithGenerics {

	private List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public int totalItems() {
		return this.items.size();
	}
	
	public boolean isEmpty() {
	    return this.items.isEmpty();
	}
	
	public List<Item> getItems() {
		return this.items;
	}
	
	public void clear() {
		this.items.clear();
	}
}
