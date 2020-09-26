package org.latamjugs.mastering.constantvalues.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	public void shipOrder(Order myOrder){
		// If status is confirm the order is shipped

		if(myOrder.getStatus().equals( Order.Status.CONFIRMED  )){
			myOrder.setStatus( Order.Status.SHIPPED );
			logger.info( "Shipping order #1 ... ");
		}

		if(myOrder.getStatus().compareTo( Order.Status.CONFIRMED)==0){
			myOrder.setStatus( Order.Status.SHIPPED );
			logger.info( "Shipping order # 2 ... ");
		}

	}

	public void processOrder(Order myOrder){
		// La orden se envia al siguiente estado, la secuencia de estados es: OPEN=1, CONFIRMED=2, SHIPPED=3, DELIVERED=4, CANCELLED=5

		//myOrder.setStatus( myOrder.getStatus() +1 ); // DELIVERED + 1 (4 + 1 = 5) Does it mean that all Orders are finally cancelled?

		if(myOrder.getStatus().equals( Order.Status.OPEN)){
			myOrder.setStatus( Order.Status.SHIPPED );
		}else if(myOrder.getStatus().equals(Order.Status.CONFIRMED)){
			myOrder.setStatus( Order.Status.SHIPPED );
		}else if(myOrder.getStatus().equals(Order.Status.SHIPPED)){
			myOrder.setStatus( Order.Status.DELIVERED );
		}

	}
}
