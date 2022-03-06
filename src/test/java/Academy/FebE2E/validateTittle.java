package Academy.FebE2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;

public class validateTittle extends base {
	public WebDriver driver;
	@Test
	public void basepageValidation() throws IOException
	{
		driver=initializeDriver();
		driver.get("https://qaclickacademy.com");
		LandingPage lp=new LandingPage(driver);
		//lp.getTittle().getText();
		Assert.assertEquals(lp.getTittle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING123");
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
