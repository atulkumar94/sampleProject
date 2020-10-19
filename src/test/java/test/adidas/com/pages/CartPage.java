package test.adidas.com.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage extends PageObject {
	public static Target placeOrder = Target.the("place order button")
			.located(By.xpath("//button[text()='Place Order']"));

	public static Target placeOrderForm = Target.the("place order form")
			.located(By.xpath("//h5[text()='Place order']"));

	public static Target deleteItem(String name) {
		return Target.the("delete item " + name).locatedBy("//td[text()='" + name + "']/following-sibling::td/a");

	}
	
	public static Target itemPrice = Target.the("item price").located(By.xpath("//a[text()='Delete']/../preceding-sibling::td[1]"));

	public static Target formNameField = Target.the("field name").located(By.id("name"));

	public static Target formCountryField = Target.the("field country").located(By.id("country"));

	public static Target formCityField = Target.the("field city").located(By.id("city"));

	public static Target formCreditCardField = Target.the("field credit card").located(By.id("card"));

	public static Target formMonthField = Target.the("field month").located(By.id("month"));

	public static Target formYearField = Target.the("field year").located(By.id("year"));

	public static Target purchase = Target.the("purchase button").located(By.xpath("//button[text()='Purchase']"));

	public static Target confirmationDialog = Target.the("order confirmation dialog")
			.located(By.xpath("//h2[text()='Thank you for your purchase!']"));

	public static Target orderPrice = Target.the("order price")
			.located(By.xpath("//h2[text()='Thank you for your purchase!']"));

	public static Target orderDetails = Target.the("order details").located(By.xpath("//p[@class='lead text-muted ']"));

	public static Target okButton = Target.the("OK").located(By.xpath("//button[text()='OK']"));

}
