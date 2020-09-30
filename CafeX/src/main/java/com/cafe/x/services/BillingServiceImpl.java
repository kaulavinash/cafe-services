package com.cafe.x.services;

import java.math.BigDecimal;

import com.cafe.x.domain.entities.Bill;
import com.cafe.x.domain.entities.Order;

public class BillingServiceImpl implements BillingService {

	private static final BigDecimal TEN_PERCENT = BigDecimal.valueOf(10.00);
	private static final BigDecimal TWENTY_PERCENT = BigDecimal.valueOf(20.00);
	private static final BigDecimal SERVICE_CHARGE_LIMIT = BigDecimal.valueOf(20.00);

	public Bill generateBill(Order order) {
		Bill bill = new Bill(order);
		boolean containsFood = order.isContainsFood();
		boolean isHot = order.isContainsHotFood();
		if (containsFood && isHot) {
			bill.addServiceCharges(TWENTY_PERCENT);
			if(bill.getTotalServiceCharges().compareTo(SERVICE_CHARGE_LIMIT) > 0) {
				bill.setTotalServiceCharges(TWENTY_PERCENT);
			}
		} else if (containsFood && !isHot) {
			bill.addServiceCharges(TEN_PERCENT);
		}
		return bill;
	}

}
