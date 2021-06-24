package com.wolox.automation.wappi.step_definitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.openqa.selenium.WebDriver;

import com.wolox.automation.wappi.tasks.Log;
import com.wolox.automation.wappi.user_interfaces.WappiLoginPage;

import cucumber.api.java.Before;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;

public class SetUp extends PageObject {
	
	@Managed(driver = "chrome")
	private WebDriver hisBrowser;
	private WappiLoginPage theWappiLoginPage;
	
	@Before
	public void setup() {
		setTheStage(new OnlineCast());
		theActorCalled("user").can(BrowseTheWeb.with(hisBrowser));
		theActorInTheSpotlight().wasAbleTo(Open.browserOn(theWappiLoginPage),
				Log.in());
	}

}
