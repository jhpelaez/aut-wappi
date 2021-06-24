package com.wolox.automation.wappi.tasks;

import static com.wolox.automation.wappi.interactions.WaitFor.waitFor;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;

import com.wolox.automation.wappi.user_interfaces.OffersPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class TryToSelect implements Task {
	
	private String product1;
	private String product2;
	private String product3;
	
	public TryToSelect(String product1, String product2, String product3) {
		this.product1 = product1;
		this.product2 = product2;
		this.product3 = product3;
	}

	public <T extends Actor> void performAs(T actor) {
		List<WebElementFacade> descriptionList = OffersPage.OFFER_DESCRIPTION_LABEL.resolveAllFor(actor);
		
		actor.attemptsTo(
				Click.on(OffersPage.OFFER_ACTION_BUTTON.of( findProductIndex(descriptionList, product1))),
				Enter.theValue(actor.recall("coupon")+"").into(OffersPage.COUPON_FIELD),
				Click.on(OffersPage.CONFIRM_ORDER_BUTTON),
				waitFor(3),
				Click.on(OffersPage.CLOSE_ORDER_MESSAGE_WINDOW),
				
				Click.on(OffersPage.OFFER_ACTION_BUTTON.of( findProductIndex(descriptionList, product2))),
				Enter.theValue(actor.recall("coupon")+"").into(OffersPage.COUPON_FIELD),
				Click.on(OffersPage.CONFIRM_ORDER_BUTTON),
				waitFor(3),
				Click.on(OffersPage.CLOSE_ORDER_MESSAGE_WINDOW),
				
				Click.on(OffersPage.OFFER_ACTION_BUTTON.of( findProductIndex(descriptionList, product3))),
				Enter.theValue(actor.recall("coupon")+"").into(OffersPage.COUPON_FIELD),
				Click.on(OffersPage.CONFIRM_ORDER_BUTTON),
				waitFor(3));
	}

	
	private String findProductIndex(List<WebElementFacade> descriptionList, String product) {
		for(int i=0; i<descriptionList.size(); i++) {
			if (descriptionList.get(i).getText().equals(product)){
				return (i+1) + "";
			}
		}
		return "0";
		
	}
	

	public static TryToSelect threeProducts(String product1, String product2, String product3) {
		return instrumented(TryToSelect.class, product1, product2, product3);
	}

}
