package com.cafe.x.domain.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@lombok.Data
@lombok.ToString(onlyExplicitlyIncluded = true)
public class Order {

	private UUID id = UUID.randomUUID();

	@lombok.ToString.Include
	private List<Item> items = new ArrayList<Item>();

	@lombok.ToString.Include
	private BigDecimal totalAmount = BigDecimal.ZERO;

	@lombok.ToString.Include
	private boolean containsFood;

	@lombok.ToString.Include
	private boolean containsHotFood;

	public Order(Item item) {
		addItem(item);
	}

	public void addItem(Item item) {
		items.add(item);
		totalAmount = totalAmount.add(item.getPrice());
		if (!item.getIsBeverage()) {
			containsFood = true;
			if (item.getTemparatureType().equals(TemperatureType.HOT)) {
				containsHotFood = true;
			}
		}
	}

}
