package test.adidas.com.tasks;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class WaitForAlertAndAccept implements Task {
	@Override
	public <T extends Actor> void performAs(T actor) {
		WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), 5);
	    wait.until(ExpectedConditions.alertIsPresent());
	    BrowseTheWeb.as(actor).getAlert().accept();
	}
}