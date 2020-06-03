package org.medellinjug.mastering.generics.rawtypes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.medellinjug.mastering.generics.Item;

class ShoppingCartTest {
	private static ShoppingCart cart = new ShoppingCart();

	@BeforeAll
	static void setUp() {
		cart.addItem(new Item("sku_123ABC", 1, 39.95, "T-Shirt"));
		cart.addItem(new Item("sku_567ZYX", 1, 9.95, "Coffee Mug"));
		cart.addItem(new Item("sku_965QRS", 1, 99.95, "Short Glass"));
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
	void testDisplayItems() {

		for (Iterator i = cart.getItems().iterator(); i.hasNext();) {
			Item item = (Item) i.next();
		}
	}

	@Test
	void testExpectedException() {

		Assertions.assertThrows(ClassCastException.class, () -> {
			cart.addItem("Shirt"); //This will give ClassCastException

			for (Iterator i = cart.getItems().iterator(); i.hasNext();) {
				Item item = (Item) i.next();
			}
		});
	}
	
	@AfterAll
	static void finish() {
		cart.clear();
	}

}
