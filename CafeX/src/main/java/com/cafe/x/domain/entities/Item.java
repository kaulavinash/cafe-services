package com.cafe.x.domain.entities;

import java.math.BigDecimal;

@lombok.Data
@lombok.ToString(onlyExplicitlyIncluded = true)
@lombok.RequiredArgsConstructor
public class Item {
	
	@lombok.NonNull
	@lombok.ToString.Include
	private String name;
	
	private String description;
	
	@lombok.NonNull
	@lombok.ToString.Include
	private TemperatureType temparatureType;
	
	@lombok.NonNull
	@lombok.ToString.Include
	private Boolean isBeverage;
	
	@lombok.NonNull
	private BigDecimal price;

}
