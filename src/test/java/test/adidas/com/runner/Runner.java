package test.adidas.com.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import test.adidas.com.base.Base;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/", glue="test.adidas.com",tags = "@demo")
public class Runner extends Base{}
