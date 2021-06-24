package com.wolox.automation.wappi.tasks;

import static com.wolox.automation.wappi.interactions.WaitFor.waitFor;
import static com.wolox.automation.wappi.utils.Constants.WITH_COUPON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;

import com.wolox.automation.wappi.user_interfaces.OffersPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

public class Select implements Task {
	
	private String product;
	private String withCoupon;
	
	public Select(String product, String withCoupon) {
		this.product = product;
		this.withCoupon = withCoupon;
	}

	public <T extends Actor> void performAs(T actor) {
		List<WebElementFacade> descriptionList = OffersPage.OFFER_DESCRIPTION_LABEL.resolveAllFor(actor);
		
		for(int i=0; i<descriptionList.size(); i++) {
			if (descriptionList.get(i).getText().equals(product)){
				actor.attemptsTo(Click.on(OffersPage.OFFER_ACTION_BUTTON.of((i+1)+"")));
				break;
			}
		}
		
		actor.attemptsTo(
				Check.whether(withCoupon.equals(WITH_COUPON.getValue()))
					.andIfSo(Enter.theValue(actor.recall("coupon")+"").into(OffersPage.COUPON_FIELD)),
				Click.on(OffersPage.CONFIRM_ORDER_BUTTON),
				waitFor(3),
				Click.on(OffersPage.CLOSE_ORDER_MESSAGE_WINDOW));
		

	}

	public static Select the(String product, String withCoupon) {
		return instrumented(Select.class, product, withCoupon);
	}

}
