package test.adidas.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage extends PageObject {
	public static Target addToCart = Target.the("add to card button").located(By.xpath("//a[text()='Add to cart']"));
	public static Target productPrice = Target.the("product price").located(By.xpath("//h3"));

}
