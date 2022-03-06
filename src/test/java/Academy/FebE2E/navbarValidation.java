package Academy.FebE2E;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;

public class navbarValidation extends base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		String url=URL();
		driver.get(url);
		Thread.sleep(5000);
	}

	@Test
	public void aboutValidation() throws IOException
	{
		LandingPage lp=new LandingPage(driver);
		//lp.getAbout().isDisplayed();
		Assert.assertTrue(lp.getAbout().isDisplayed());
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
