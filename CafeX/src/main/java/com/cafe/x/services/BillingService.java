package com.cafe.x.services;

import com.cafe.x.domain.entities.Bill;
import com.cafe.x.domain.entities.Order;

public interface BillingService {
	
	public Bill generateBill(Order order);

}
