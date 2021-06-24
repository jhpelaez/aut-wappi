package com.wolox.automation.wappi.user_interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class WappiHomePage {
	
	public static final Target PERSONAL_INFORMATION_BUTTON = Target.the("Option to go and see the user information").locatedBy("//body/app-root/app-home/app-nav-bar/nav/ul[@class='nav-bar-menu']/li/a[text()='Información personal']");
	public static final Target HOME_BUTTON = Target.the("Option to go and see the products").locatedBy("//*/ul[@class='nav-bar-menu']/li/a[text()='Inicio']");
	public static final Target MY_ORDERS_BUTTON = Target.the("Option to go and see my purchases").locatedBy("//*/ul[@class='nav-bar-menu']/li/a[text()='Mis pedidos']");
	public static final Target GET_COUPON_BUTTON = Target.the("Option to get a new coupon").located(By.id("welcome-coupon"));
	public static final Target CLOSE_COUPON_WINDOW_BUTTON = Target.the("Button to close the generated coupon code").locatedBy("//div[@id='coupon-modal']/div/span[1]");
	
	public static final Target COUPON_CODE_LABEL = Target.the("Label with the coupon code").located(By.id("coupon-code"));

}
