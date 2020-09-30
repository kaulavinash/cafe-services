package com.cafe.x;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cafe.x.util.BigDecimalUtil;

@RunWith(SpringRunner.class)
public class BigDecimalUtilTest {

	@Test
	public void percentageValue1() {
		try {
			BigDecimal amount = BigDecimal.valueOf(444).setScale(2);
			BigDecimal percentage = BigDecimal.valueOf(10).setScale(2);
			BigDecimal value = BigDecimalUtil.percentage(amount, percentage);
			assertTrue(BigDecimal.valueOf(44.40).setScale(2).equals(value));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void percentageValue2() {
		try {
			BigDecimal amount = BigDecimal.valueOf(2.5).setScale(2);
			BigDecimal percentage = BigDecimal.valueOf(10.00).setScale(2);
			BigDecimal value = BigDecimalUtil.percentage(amount, percentage);
			assertTrue(BigDecimal.valueOf(0.25).setScale(2).equals(value));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
