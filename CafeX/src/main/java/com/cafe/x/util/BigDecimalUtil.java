package com.cafe.x.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class BigDecimalUtil {
	
	private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

	public static BigDecimal percentage(BigDecimal amount, BigDecimal percentage){
	    return amount.multiply(percentage).divide(ONE_HUNDRED).setScale(2 , RoundingMode.HALF_EVEN);
	}
	
	public static BigDecimal percentage(BigDecimal amount, BigDecimal percentage, int scale){
	    return amount.multiply(percentage).divide(ONE_HUNDRED).setScale(scale , RoundingMode.HALF_EVEN);
	}

	
	
}
