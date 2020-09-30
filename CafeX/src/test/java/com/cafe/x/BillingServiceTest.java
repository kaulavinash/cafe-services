package com.cafe.x;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cafe.x.domain.entities.Bill;
import com.cafe.x.domain.entities.Item;
import com.cafe.x.domain.entities.Order;
import com.cafe.x.domain.entities.TemperatureType;
import com.cafe.x.services.BillingService;
import com.cafe.x.services.BillingServiceImpl;
import com.cafe.x.services.OrderService;
import com.cafe.x.services.OrderServiceImpl;

@RunWith(SpringRunner.class)
public class BillingServiceTest {

	OrderService orderService = new OrderServiceImpl();

	BillingService billingService = new BillingServiceImpl();

	private Order createOrderOnlyBeverage() {

		Item beverage = new Item("Cola", TemperatureType.COLD, true, BigDecimal.valueOf(0.50));
		Order orderOnlyBeverage = new Order(beverage);
		return orderOnlyBeverage;

	}
	
	private Order createOrderBeverageAndFood() {

		Item beverage = new Item("Cola", TemperatureType.COLD, true, BigDecimal.valueOf(0.50));
		Item food = new Item("Cheese Sandwich", TemperatureType.COLD, false, BigDecimal.valueOf(2.00));
		Order order = new Order(food);
		order.addItem(beverage);
		return order;

	}

	private Order createOrderOnlyFood() {

		Item food1 = new Item("Cheese Sandwich", TemperatureType.COLD, false, BigDecimal.valueOf(2.00));
		Item food2 = new Item("Cheese Sandwich", TemperatureType.COLD, false, BigDecimal.valueOf(2.00));
		Order order = new Order(food1);
		order.addItem(food2);
		return order;

	}
	
	private Order createOrderHotFood() {

		Item food1 = new Item("Steak Sandwich", TemperatureType.HOT, false, BigDecimal.valueOf(2.00));
		Item food2 = new Item("Steak Sandwich", TemperatureType.HOT, false, BigDecimal.valueOf(2.00));
		Order order = new Order(food1);
		order.addItem(food2);
		return order;

	}
	
	private Order createOrderHotFoodGreater20() {

		Item food1 = new Item("Steak Sandwich", TemperatureType.HOT, false, BigDecimal.valueOf(200.00));
		Item food2 = new Item("Steak Sandwich", TemperatureType.HOT, false, BigDecimal.valueOf(200.00));
		Order order = new Order(food1);
		order.addItem(food2);
		return order;

	}
	
	@Test
	void testWhenOnlyBeverage() {
		System.out.println("testWhenOnlyBeverage");
		Order order = createOrderOnlyBeverage();
		System.out.println("Order Total Amount : " + order.getTotalAmount());
		Bill bill = billingService.generateBill(order);
		System.out.println("Service Charges : " + bill.getTotalServiceCharges());
		System.out.println("Total Charges : " + bill.getTotalCharges());
		System.out.println();
	}

	@Test
	void testWhenBeverageAndFood() {
		System.out.println("testWhenBeverageAndFood");
		Order order = createOrderBeverageAndFood();
		System.out.println("Order Total Amount : " + order.getTotalAmount());
		Bill bill = billingService.generateBill(order);
		System.out.println("Service Charges : " + bill.getTotalServiceCharges());
		System.out.println("Total Charges : " + bill.getTotalCharges());
		System.out.println();
	}

	@Test
	void testWhenOnlyFood() {
		System.out.println("testWhenOnlyFood");
		Order order = createOrderOnlyFood();
		System.out.println("Order Total Amount : " + order.getTotalAmount());
		Bill bill = billingService.generateBill(order);
		System.out.println("Service Charges : " + bill.getTotalServiceCharges());
		System.out.println("Total Charges : " + bill.getTotalCharges());
		System.out.println();
	}

	@Test
	void testWhenHotFood() {
		System.out.println("testWhenHotFood");
		Order order = createOrderHotFood();
		System.out.println("Order Total Amount : " + order.getTotalAmount());
		Bill bill = billingService.generateBill(order);
		System.out.println("Service Charges : " + bill.getTotalServiceCharges());
		System.out.println("Total Charges : " + bill.getTotalCharges());
		System.out.println();
	}
	
	@Test
	void testWhenHotFoodChargeGreater20() {
		System.out.println("testWhenHotFoodChargeGreater20");
		Order order = createOrderHotFoodGreater20();
		System.out.println("Order Total Amount : " + order.getTotalAmount());
		Bill bill = billingService.generateBill(order);
		System.out.println("Service Charges : " + bill.getTotalServiceCharges());
		System.out.println("Total Charges : " + bill.getTotalCharges());
		System.out.println();
	}

}
