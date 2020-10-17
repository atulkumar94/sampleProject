package test.adidas.com.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import test.adidas.com.pages.CartPage;
import test.adidas.com.pages.HomePage;
import test.adidas.com.pages.ProductPage;
import test.adidas.com.tasks.AddToCart;
import test.adidas.com.tasks.NavigateToCategory;
import test.adidas.com.tasks.PlaceOrderFormFill;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class StoreStepDef {
	HomePage homepage;

	@Managed
	WebDriver hisBrowser;

	public static int expectedPrices;

	@Before
	public void setTheStage() {
		OnStage.setTheStage(new OnlineCast());
	}

	@Given("the {string} is on homepage")
	public void the_is_on_homepage(String string) {
		theActorCalled("User").can(BrowseTheWeb.with(hisBrowser));
		homepage.open();
	}

	@When("user navigates to category {string}")
	public void user_navigates_to_category(String string) {
		if (string.split(",").length > 1) {
			for (int i = 0; i < string.split(",").length; i++) {
				theActorInTheSpotlight().attemptsTo(new NavigateToCategory(string.split(",")[i].trim()));
			}
		} else {
			theActorInTheSpotlight().attemptsTo(new NavigateToCategory(string.trim()));
		}

	}

	@When("user adds {string} to cart")
	public void user_adds_to_cart(String string) {
		theActorInTheSpotlight().attemptsTo(new AddToCart(string));
		expectedPrices += Integer.parseInt(
				ProductPage.productPrice.resolveFor(theActorInTheSpotlight()).getText().replaceAll("[^\\d]", ""));
		homepage.open();
	}

	@When("user navigates to cart page")
	public void user_navigates_to() {
		theActorInTheSpotlight().attemptsTo(new NavigateToCategory("Cart"));
	}

	@When("user clicks on place order in cart page")
	public void user_clicks_on() {
		theActorInTheSpotlight().attemptsTo(WaitUntil.the(CartPage.placeOrder, isVisible()),
				Click.on(CartPage.placeOrder));
	}

	@When("user fills the web form")
	public void user_fills_the_web_form() {
		theActorInTheSpotlight().attemptsTo(new PlaceOrderFormFill());
	}

	@When("user clicks on purchase button")
	public void user_clicks_on_purchase_button() {
		theActorInTheSpotlight().attemptsTo(Click.on(CartPage.purchase));
	}

	@And("^user should see purchase confirmation$")
	public void userShouldSeePurchaseConfirmation() {
		theActorInTheSpotlight().attemptsTo(WaitUntil.the(CartPage.confirmationDialog, isVisible()));
	}

	@And("^user validates the final price$")
	public void userValidatesTheFinalPrice() {
		String orderDetails = CartPage.orderDetails.resolveFor(theActorInTheSpotlight()).getText();
		String orderPrice = orderDetails.substring(orderDetails.indexOf("Amount"), orderDetails.indexOf("USD"))
				.replaceAll("[^\\d]", "");
		Assert.assertTrue("Price not matching", expectedPrices == Integer.parseInt(orderPrice));
		theActorInTheSpotlight().attemptsTo(Click.on(CartPage.okButton));
	}

}
