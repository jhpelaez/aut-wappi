package com.wolox.automation.wappi.tasks;

import static com.wolox.automation.wappi.interactions.WaitFor.waitFor;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.io.File;

import com.wolox.automation.wappi.models.Information;
import com.wolox.automation.wappi.user_interfaces.PersonalInformationPage;
import com.wolox.automation.wappi.utils.Constants;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.conditions.Check;

public class ModifyYourProfile implements Task {
	
	private Information information;
	private File image;
	private String imagePath;
	
	public ModifyYourProfile(Information information) {
		this.information = information;
		image = new File("src\\test\\resources\\images\\logo.png");
		imagePath = image.getAbsolutePath();
	}

	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(information.getName()).into(PersonalInformationPage.NAME_FIELD),
				Enter.theValue(information.getLastName()).into(PersonalInformationPage.LAST_NAME_FIELD),
				Enter.theValue(information.getBirthDate()).into(PersonalInformationPage.BIRTH_DATE_FIELD),
				Click.on(PersonalInformationPage.COUNTRY_SELECT),
				SelectFromOptions.byVisibleText(information.getCountry()).from(PersonalInformationPage.COUNTRY_SELECT),
				Check.whether(information.getSex().toLowerCase().equals(Constants.MALE_SEX.getValue()))
					.andIfSo(Click.on(PersonalInformationPage.MALE_CHECK)),
				Check.whether(information.getSex().toLowerCase().equals(Constants.FEMALE_SEX.getValue()))
					.andIfSo(Click.on(PersonalInformationPage.FEMALE_CHECK)),
				waitFor(1),
				Enter.keyValues(imagePath).into(PersonalInformationPage.IMAGE_BUTTON),
				waitFor(1),
				Click.on(PersonalInformationPage.SAVE_BUTTON));

	}

	public static ModifyYourProfile withThose(Information information) {
		return instrumented(ModifyYourProfile.class, information);
	}


}
