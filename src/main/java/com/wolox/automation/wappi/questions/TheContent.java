package com.wolox.automation.wappi.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TheContent implements Question<String> {
	
	private Target target;
	
	public TheContent(Target target) {
		this.target = target;
	}

	public String answeredBy(Actor actor) {
		return Text.of(target).viewedBy(actor).asString();
	}
	
	public static TheContent ofTarget(Target target) {
		return new TheContent(target);
	}

}
