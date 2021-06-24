package com.wolox.automation.wappi.user_interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PersonalInformationPage {
	
	public static final Target NAME_FIELD = Target.the("Text field to set a new user name").located(By.id("name"));
	public static final Target LAST_NAME_FIELD = Target.the("Text field to set a new user last name").located(By.id("lastName"));
	public static final Target BIRTH_DATE_FIELD = Target.the("Text field to set a new user birth day").located(By.id("bornDate"));
	
	public static final Target COUNTRY_SELECT = Target.the("Text field to set a new user country").located(By.id("country"));
	
	public static final Target MALE_CHECK = Target.the("Check option to select a male sex").located(By.id("M"));
	public static final Target FEMALE_CHECK = Target.the("Check option to select a female sex").located(By.id("F"));
	
	public static final Target IMAGE_BUTTON = Target.the("Button to select an image to upload").locatedBy("//input[@id='image']");
	public static final Target SAVE_BUTTON = Target.the("Button to save the information").located(By.id("save-profile"));
	
	public static final Target CONFIRM_UPDATE_INFORMATION_MESSAGE = Target.the("Information message after update profile information").locatedBy("//*[text()='Tu información se guardó correctamente']");
	
}
