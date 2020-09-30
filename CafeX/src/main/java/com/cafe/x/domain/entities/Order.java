package com.cafe.x.domain.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@lombok.Data
public class Order {

	private UUID id = UUID.randomUUID();

	private List<Item> items = new ArrayList<Item>();

	private BigDecimal totalAmount = BigDecimal.ZERO;

	private boolean containsFood;

	private boolean containsHotFood;

	public Order(Item item) {
		addItem(item);
	}

	public void addItem(Item item) {
		items.add(item);
		totalAmount = totalAmount.add(item.getPrice());
		if (!item.getIsBeverage()) {
			containsFood = true;
			if (!item.getTemparatureType().equals(TemperatureType.HOT)) {
				containsHotFood = true;
			}
		}
	}

}
