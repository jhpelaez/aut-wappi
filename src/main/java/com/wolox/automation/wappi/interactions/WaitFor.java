package com.wolox.automation.wappi.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class WaitFor implements Interaction {
	
	private int seconds;
	
	public WaitFor(int seconds) {
		this.seconds = seconds;
	}

	public <T extends Actor> void performAs(T actor) {
		new InternalSystemClock().pauseFor(seconds * 1000); 
	}
	
	public static WaitFor waitFor(int seconds) {
		return instrumented(WaitFor.class, seconds);
	}

}
