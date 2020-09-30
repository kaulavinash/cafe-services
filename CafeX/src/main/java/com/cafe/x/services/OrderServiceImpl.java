package com.cafe.x.services;

import com.cafe.x.domain.entities.Item;
import com.cafe.x.domain.entities.Order;

public class OrderServiceImpl implements OrderService {

	@Override
	public Order createOrder(Item item) {
		Order order = new Order(item);
		return order;
	}

	@Override
	public Order addItemOrder(Order order, Item item) {
		order.addItem(item);
		return order;
	}

}
