package org.latamjugs.mastering.constantvalues.enums;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

	@Test
	void shipOrder() {
		//Arrange
		Order myOrder = new Order();
		myOrder.setStatus( Order.Status.CONFIRMED );
		//Act
		OrderService orderService = new OrderService();
		orderService.shipOrder( myOrder );
		//Assert
		assertEquals(Order.Status.SHIPPED, myOrder.getStatus());
	}

	@Test
	void shipOrderAlreadyShipped() {//Status doesn't change
		//Arrange
		Order myOrder = new Order();
		myOrder.setStatus( Order.Status.SHIPPED );
		//Act
		OrderService orderService = new OrderService();
		orderService.shipOrder( myOrder );

		//Assert
		assertEquals(Order.Status.SHIPPED, myOrder.getStatus());
	}

	@Test
	void processOrderConfirmed() {
		//Arrange
		Order myOrder = new Order();
		myOrder.setStatus( Order.Status.CONFIRMED );
		//Act
		OrderService orderService = new OrderService();
		orderService.processOrder( myOrder );
		//Assert
		assertEquals(Order.Status.SHIPPED, myOrder.getStatus());
	}

	@Test
	void processOrderDelivered() {
		//Arrange
		Order myOrder = new Order();
		myOrder.setStatus( Order.Status.DELIVERED );
		//Act
		OrderService orderService = new OrderService();
		orderService.processOrder( myOrder );
		//Assert
		assertEquals(Order.Status.DELIVERED, myOrder.getStatus());
	}
}