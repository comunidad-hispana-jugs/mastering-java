package org.medellinjug.mastering.generics.rawtypes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ecabrerar
 * @date Jun 3, 2020
 *
 */
public class ShoppingCart {
	private List items = new ArrayList();

	public void addItem(Object item) {
		this.items.add(item);
	}
	
	public int totalItems() {
		return this.items.size();
	}
	
	public boolean isEmpty() {
	    return this.items.isEmpty();
	}
	public List getItems() {
		return this.items;
	}
	
	public void clear() {
		this.items.clear();
	}
	
}
