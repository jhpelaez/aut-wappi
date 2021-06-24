package com.wolox.automation.wappi.tasks;

import static com.wolox.automation.wappi.utils.Constants.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.wolox.automation.wappi.user_interfaces.WappiLoginPage;
import com.wolox.automation.wappi.utils.Constants;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Log implements Task {
	
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(USER.getValue()).into(WappiLoginPage.USER_FIELD),
				Enter.theValue(Constants.PASSWORD.getValue()).into(WappiLoginPage.PASSWORD_FIELD),
				Click.on(WappiLoginPage.LOGIN_BUTTON));
	}

	public static Log in() {
		return instrumented(Log.class);
	}

}
