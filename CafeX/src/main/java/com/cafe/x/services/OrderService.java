package com.cafe.x.services;

import com.cafe.x.domain.entities.Item;
import com.cafe.x.domain.entities.Order;

public interface OrderService {
	
	public Order createOrder(Item item);
	
	public Order addItemOrder(Order order, Item item);

}
