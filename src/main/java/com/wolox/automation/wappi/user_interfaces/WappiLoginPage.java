package com.wolox.automation.wappi.user_interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automation-wappi.vercel.app/")
public class WappiLoginPage extends PageObject {
	
	public static final Target USER_FIELD = Target.the("Text field to type the username").located(By.id("username"));
	public static final Target PASSWORD_FIELD = Target.the("Text field to type the user password").located(By.id("password"));
	public static final Target LOGIN_BUTTON = Target.the("Button to login the page").located(By.id("button-login"));
}
