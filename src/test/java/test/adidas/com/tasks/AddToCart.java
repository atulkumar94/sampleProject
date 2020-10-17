package test.adidas.com.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import test.adidas.com.pages.HomePage;
import test.adidas.com.pages.ProductPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCart implements Task {
	private String category;

	/**
	 * Instantiates a new NavigateToCategory.
	 *
	 * @param category the category
	 */
	public AddToCart(String category) {
		this.category = category;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				WaitUntil.the(HomePage.target(category), isVisible()), 
				Click.on(HomePage.target(category)),
				WaitUntil.the(ProductPage.addToCart, isVisible()), 
				Click.on(ProductPage.addToCart),
				new WaitForAlertAndAccept());
		
	}
}