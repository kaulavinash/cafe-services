package com.cafe.x.domain.entities;

import java.math.BigDecimal;

@lombok.Data
@lombok.RequiredArgsConstructor
public class Item {
	
	@lombok.NonNull
	private String name;
	
	private String description;
	
	@lombok.NonNull
	private TemperatureType temparatureType;
	
	@lombok.NonNull
	private Boolean isBeverage;
	
	@lombok.NonNull
	private BigDecimal price;

}
