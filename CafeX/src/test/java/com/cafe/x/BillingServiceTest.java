package com.cafe.x;

import static org.junit.jupiter.api.Assertions.fail;

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
class BillingServiceTest {

	OrderService orderService = new OrderServiceImpl();

	BillingService billingService = new BillingServiceImpl();

	private Order createOrderOnlyBeverage() {

		Item beverage = new Item("Cola", TemperatureType.COLD, true, BigDecimal.valueOf(0.50));
		Order orderOnlyBeverage = new Order(beverage);
		return orderOnlyBeverage;

	}

	@Test
	void testWhenOnlyBeverage() {
		Order order = createOrderOnlyBeverage();
		Bill bill = billingService.generateBill(order);
		System.out.println("Service Charges : " + bill.getTotalServiceCharges());
		System.out.println("Total Charges : " + bill.getTotalCharges());
	}

	@Test
	void testWhenBeverageAndFood() {
		fail("Not yet implemented");
	}

	@Test
	void testWhenOnlyFood() {
		fail("Not yet implemented");
	}

	@Test
	void testWhenHotFood() {
		fail("Not yet implemented");
	}

}
