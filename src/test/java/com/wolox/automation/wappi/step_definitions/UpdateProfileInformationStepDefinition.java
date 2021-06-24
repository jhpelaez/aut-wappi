package com.wolox.automation.wappi.step_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

import com.wolox.automation.wappi.models.Information;
import com.wolox.automation.wappi.questions.TheContent;
import com.wolox.automation.wappi.tasks.ModifyYourProfile;
import com.wolox.automation.wappi.tasks.OpenThePersonalInformation;
import com.wolox.automation.wappi.user_interfaces.PersonalInformationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UpdateProfileInformationStepDefinition {
	
	@Given("^that the user is in personal information window$")
	public void thatTheUserIsInPersonalInformationWindow() {
		theActorInTheSpotlight().wasAbleTo(OpenThePersonalInformation.section());
	}


	@When("^the user update his information with the values '(.*)' '(.*)' '(.*)' '(.*)' '(.*)'$")
	public void theUserUpdateHisInformationWithTheValues(String name, String lastName, String birthDate, String country, String sex) {
		Information information = new Information(name, lastName, birthDate, country, sex);
		theActorInTheSpotlight().attemptsTo(ModifyYourProfile.withThose(information));
	}

	@Then("^the user should see the message '(.*)'$")
	public void theUserShouldSeeTheMessage(String message) {
		theActorInTheSpotlight().should(seeThat(TheContent.ofTarget(PersonalInformationPage.CONFIRM_UPDATE_INFORMATION_MESSAGE), containsString(message)));
	}

}
