package test.adidas.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {
	public static Target target(String name) {
		return Target.the(name).locatedBy("//a[text()='" + name + "']");

	}


}
