package org.latamjugs.mastering.constantvalues.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

	@Test
	void shipOrder() {
		//Arrange
		Order myOrder = new Order();
		myOrder.setStatus( OrderConstants.STATUS_CONFIRMED );
		//Act
		OrderService orderService = new OrderService();
		orderService.shipOrder( myOrder );
		//Assert
		assertEquals(OrderConstants.STATUS_SHIPPED, myOrder.getStatus());
	}

	@Test
	void shipOrderAlreadyShipped() {//Status doesn't change
		//Arrange
		Order myOrder = new Order();
		myOrder.setStatus( OrderConstants.STATUS_SHIPPED );
		//Act
		OrderService orderService = new OrderService();
		orderService.shipOrder( myOrder );

		//Assert
		assertEquals(OrderConstants.STATUS_SHIPPED, myOrder.getStatus());
	}

	@Test
	void processOrderConfirmed() {
		//Arrange
		Order myOrder = new Order();
		myOrder.setStatus( OrderConstants.STATUS_CONFIRMED );
		//Act
		OrderService orderService = new OrderService();
		orderService.processOrder( myOrder );
		//Assert
		assertEquals(OrderConstants.STATUS_SHIPPED, myOrder.getStatus());
	}

	@Test
	void processOrderDelivered() {
		//Arrange
		Order myOrder = new Order();
		myOrder.setStatus( OrderConstants.STATUS_DELIVERED );
		//Act
		OrderService orderService = new OrderService();
		orderService.processOrder( myOrder );
		//Assert
		assertEquals(OrderConstants.STATUS_DELIVERED, myOrder.getStatus());
	}


}