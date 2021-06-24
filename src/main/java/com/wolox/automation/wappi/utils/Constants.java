package com.wolox.automation.wappi.utils;

public enum Constants {
	USER("Pepito"),
	PASSWORD("pepito123"),
	MALE_SEX("masculino"),
	FEMALE_SEX("femenino"),
	WITH_COUPON("withCoupon"),
	WITOUT_COUPON("withoutCoupon"), 
	INVALID_COUPON("Cupón inválido");
	
	private String value;
	
	private Constants(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
