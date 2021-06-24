package com.wolox.automation.wappi.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class OrdersPage {
	
	public static final Target ORDER_DESCRIPTION_LABEL = Target.the("name of product ordered").locatedBy("//table[@class = 'app-table offers-table']/tbody/tr/td[2]");
	public static final Target WAS_COUPON_USED_LABEL = Target.the("Describe if a coupon was used in the order").locatedBy("//table[@class = 'app-table offers-table']/tbody/tr[{0}]/td[7]");
	
}
