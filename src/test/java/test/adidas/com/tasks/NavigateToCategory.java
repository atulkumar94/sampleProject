package test.adidas.com.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import test.adidas.com.pages.HomePage;

public class NavigateToCategory implements Task {
	private String category;

	/**
	 * Instantiates a new NavigateToCategory.
	 *
	 * @param category the category
	 */
	public NavigateToCategory(String category) {
		this.category = category;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(HomePage.target(category)), WaitUntil.angularRequestsHaveFinished());
	}
}