package com.cafe.x.domain.entities;

import java.math.BigDecimal;

import com.cafe.x.util.BigDecimalUtil;

/**
 * @author avinashkaul
 *
 */
@lombok.Data
@lombok.RequiredArgsConstructor
public class Bill {

	@lombok.NonNull
	private Order order;

	private BigDecimal totalServiceCharges = BigDecimal.ZERO;

	public BigDecimal getTotalCharges() {
		return order.getTotalAmount().add(totalServiceCharges);
	}

	public void addServiceCharges(BigDecimal percentage) {
		this.totalServiceCharges = BigDecimalUtil.percentage(order.getTotalAmount(), percentage);
	}

}
