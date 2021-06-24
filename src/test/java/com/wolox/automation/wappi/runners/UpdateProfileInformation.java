package com.wolox.automation.wappi.runners;

import static cucumber.api.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/update-profile-information.feature",
		glue = "com.wolox.automation.wappi.step_definitions",
		snippets = CAMELCASE,
		tags="@wappiTest"
)
public class UpdateProfileInformation {

}
