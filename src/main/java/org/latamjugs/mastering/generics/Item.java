package org.latamjugs.mastering.generics;

/**
 * @author ecabrerar
 * @date Jun 3, 2020
 *
 */
public class Item {
	private String id;
	private int qty;
	private double price;
	private String name;	

	public Item(String id, int qty, double price, String name) {
		super();
		this.id = id;
		this.qty = qty;
		this.price = price;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public int getQty() {
		return qty;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	
}
