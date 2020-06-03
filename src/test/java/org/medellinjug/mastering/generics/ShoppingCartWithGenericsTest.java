package org.medellinjug.mastering.generics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShoppingCartWithGenericsTest {
	
	private static ShoppingCartWithGenerics cart = new ShoppingCartWithGenerics();

	@BeforeAll
	static void setUp() {
		cart.addItem(new Item("sku_123ABC", 1, 39.95, "T-Shirt"));
		cart.addItem(new Item("sku_567ZYX", 1, 9.95, "Coffee Mug"));
		cart.addItem(new Item("sku_965QRS", 1, 99.95, "Short Glass"));
	}

	@Test
	void testAddItem() {	
//		cart.addItem("Shirt"); This will give compilation error as :: The method addItem(Item) in the type ShoppingCartWithGenerics is not applicable for the arguments (String)
	}

	@Test
	void testTotalItems() {
		assertTrue(cart.totalItems() > 0);
	}

	@Test
	void testIsEmpty() {
		assertFalse(cart.isEmpty());
	}

	@Test
	void testGetItems() {
		for (Iterator<Item> i = cart.getItems().iterator(); i.hasNext();) {
			Item item = i.next();
		}
	}
	
	@AfterAll
	static void finish() {
		cart.clear();
	}

}
