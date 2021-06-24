package com.wolox.automation.wappi.questions;

import java.util.List;

import com.wolox.automation.wappi.user_interfaces.OrdersPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheProductIs implements Question<Boolean> {
	
	private String product;

	public TheProductIs(String product) {
		this.product = product;
	}

	public Boolean answeredBy(Actor actor) {
		List<WebElementFacade> productInList = OrdersPage.ORDER_DESCRIPTION_LABEL.resolveAllFor(actor);
		for (int i=0; i<productInList.size(); i++) {
			if (productInList.get(i).getText().equals(product)) {
				actor.remember("orderedProductIndex", i+1);
				return true;
			}
		}
		return false;
	}

	public static TheProductIs inList(String product) {
		return new TheProductIs(product);
	}

}
