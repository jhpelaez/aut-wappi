package com.wolox.automation.wappi.step_definitions;

import static com.wolox.automation.wappi.exceptions.OrderException.NO_COUPON_STATE;
import static com.wolox.automation.wappi.exceptions.OrderException.NO_PRODUCT_IN_ORDER;
import static com.wolox.automation.wappi.tasks.GetCoupon.getCoupon;
import static com.wolox.automation.wappi.utils.Constants.WITH_COUPON;
import static com.wolox.automation.wappi.utils.Constants.WITOUT_COUPON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

import com.wolox.automation.wappi.exceptions.OrderException;
import com.wolox.automation.wappi.questions.CouponState;
import com.wolox.automation.wappi.questions.TheContent;
import com.wolox.automation.wappi.questions.TheProductIs;
import com.wolox.automation.wappi.tasks.GoToOrders;
import com.wolox.automation.wappi.tasks.OpenTheOffers;
import com.wolox.automation.wappi.tasks.Select;
import com.wolox.automation.wappi.tasks.TryToSelect;
import com.wolox.automation.wappi.user_interfaces.OffersPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RequestAnOrderStepDefinition {
	
	@Given("^that the user is in the wappi home page$")
	public void thatTheUserIsInTheWappiHomePage() {
		theActorInTheSpotlight().wasAbleTo(OpenTheOffers.section());
	}

	@When("^the user do a request with the welcome coupon of the '(.*)'$")
	public void theUserDoARequestWithTheWelcomeCouponOfThe(String product) {
		theActorInTheSpotlight().wasAbleTo(
				getCoupon(),
				Select.the(product, WITH_COUPON.getValue()),
				GoToOrders.page());
		
	}
	
	@When("^the user do a request without the welcome coupon of the '(.*)'$")
	public void theUserDoARequestWithoutTheWelcomeCouponOfThe(String product) {
		theActorInTheSpotlight().wasAbleTo(
				Select.the(product, WITOUT_COUPON.getValue()),
				GoToOrders.page());
		
	}
	
	@When("^the user do three request with the same coupon of the products '(.*)' '(.*)' '(.*)'$")
	public void theUserDoThreeRequestWithTheSameCouponOfTheProducts(String product1, String product2, String product3) {
		theActorInTheSpotlight().wasAbleTo(
				getCoupon(),
				TryToSelect.threeProducts(product1, product2, product3));
	}

	@Then("^the user should see the '(.*)' in the order window$")
	public void theUserShouldSeeTheInTheOrderWindow(String product) {
		theActorInTheSpotlight().should(seeThat(TheProductIs.inList(product))
				.orComplainWith(OrderException.class, NO_PRODUCT_IN_ORDER));
	}

	@Then("^the user should see the coupon state in '(.*)'$")
	public void theUserShouldSeeTheCouponStateIn(String state) {
		theActorInTheSpotlight().should(seeThat(CouponState.is(state))
				.orComplainWith(OrderException.class, NO_COUPON_STATE));
	}
	
	@Then("^the user should see the error in the order window with the '(.*)'$")
	public void theUserShouldSeeTheErrorInTheOrderWindowWithThe(String message) {
		theActorInTheSpotlight().should(seeThat(TheContent.ofTarget(OffersPage.EXCESS_OF_USE_OF_THE_COUPON_MESSAGE), containsString(message)));
	}

}
