package com.wolox.automation.wappi.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.wolox.automation.wappi.user_interfaces.WappiHomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class OpenTheOffers implements Task {

	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(WappiHomePage.HOME_BUTTON));
	}

	public static OpenTheOffers section() {
		return instrumented(OpenTheOffers.class);
	}

}
