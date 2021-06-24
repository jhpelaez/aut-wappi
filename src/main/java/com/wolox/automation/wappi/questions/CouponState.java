package com.wolox.automation.wappi.questions;

import com.wolox.automation.wappi.user_interfaces.OrdersPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CouponState implements Question<Boolean> {
	
	private String state;
	
	public CouponState(String state) {
		this.state = state;
	}

	public Boolean answeredBy(Actor actor) {
		if (OrdersPage.WAS_COUPON_USED_LABEL.of(actor.recall("orderedProductIndex")+"").resolveFor(actor).getText().equals(state))
			return true;
		return false;
	}

	public static CouponState is(String state) {
		return new CouponState(state);
	}

}
