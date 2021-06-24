package com.wolox.automation.wappi.tasks;

import static com.wolox.automation.wappi.interactions.WaitFor.waitFor;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.wolox.automation.wappi.user_interfaces.WappiHomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class GetCoupon implements Task {

	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(WappiHomePage.GET_COUPON_BUTTON));
		actor.remember("coupon", WappiHomePage.COUPON_CODE_LABEL.resolveFor(actor).getTextValue());
		actor.attemptsTo(
				Click.on(WappiHomePage.CLOSE_COUPON_WINDOW_BUTTON),
				waitFor(2),
				Click.on(WappiHomePage.HOME_BUTTON));
	}

	public static GetCoupon getCoupon() {
		return instrumented(GetCoupon.class);
	}

}
