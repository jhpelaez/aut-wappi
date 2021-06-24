package com.wolox.automation.wappi.user_interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class OffersPage {
	
	public static final Target OFFER_DESCRIPTION_LABEL = Target.the("name of the product in offer").locatedBy("//table[@class='app-table offers-table']/tbody/tr/td[2]");
	
	public static final Target OFFER_ACTION_BUTTON = Target.the("Button to request a product").locatedBy("//table[@class='app-table offers-table']/tbody/tr[{0}]/td[7]/button");
	public static final Target CONFIRM_ORDER_BUTTON = Target.the("Button to confirm the order").located(By.id("order-confirm"));
	
	public static final Target CLOSE_ORDER_MESSAGE_WINDOW = Target.the("Windows with the status of the order").locatedBy("//*[@id='confirmation-modal']/div/span[1]");
	
	public static final Target COUPON_FIELD = Target.the("Text field to put a coupon code").located(By.id("coupon"));
	
	public static final Target EXCESS_OF_USE_OF_THE_COUPON_MESSAGE = Target.the("Message for excess of use").located(By.id("e-coupon"));
	
}
