package org.medellinjug.mastering.constantvalues.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	public void shipOrder(Order order){
		// If status is confirm (number 2) the order is shipped

		/*if ( order.getStatus() == 1 ) {//Not clear what are 1 and 2?
			order.setStatus( 2 );
		}*/

		if(order.getStatus()==OrderConstants.STATUS_CONFIRMED){//Much better, How can be sure   clear what are 1 and 2?
			order.setStatus( OrderConstants.STATUS_SHIPPED );
			logger.info( "Shipping order ... ");
		}

	}

	public void processOrder(Order order){
		// La orden se envia al siguiente estado, la secuencia de estados es: OPEN=1, CONFIRMED=2, SHIPPED=3, DELIVERED=4, CANCELLED=5

		//order.setStatus( order.getStatus() +1 ); // DELIVERED + 1 (4 + 1 = 5) Does it mean that all Orders are finally cancelled?

		if(order.getStatus()==OrderConstants.STATUS_OPEN){//Much better, but ...
			order.setStatus( OrderConstants.STATUS_SHIPPED );
		}else if(order.getStatus()==OrderConstants.STATUS_CONFIRMED){
			order.setStatus( OrderConstants.STATUS_SHIPPED );
		}else if(order.getStatus()==OrderConstants.STATUS_SHIPPED){
			order.setStatus( OrderConstants.STATUS_DELIVERED );
		}

	}
}
