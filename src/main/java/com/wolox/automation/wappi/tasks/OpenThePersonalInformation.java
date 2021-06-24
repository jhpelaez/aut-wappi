package com.wolox.automation.wappi.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.wolox.automation.wappi.user_interfaces.WappiHomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class OpenThePersonalInformation implements Task {

	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Click.on(WappiHomePage.PERSONAL_INFORMATION_BUTTON));

	}

	public static OpenThePersonalInformation section() {
		return instrumented(OpenThePersonalInformation.class);
	}

}
