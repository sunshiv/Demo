package Academy.FebE2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;
import pageObjects.loginPage;

public class HomePage extends base{
	
	public WebDriver driver;
	@Test(dataProvider="getData")
	public void basepageNavigation(String username,String password) throws IOException
	{
		driver=initializeDriver();
		String url=URL();
		driver.get(url);
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		loginPage lp=new loginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		//first user and pwd
		data[0][0]="priya";
		data[0][1]="jhdgfjhgfvhjerbf";
		//2nd user n pwd
		data[1][0]="vijayaa";
		data[1][1]="jdhfkjhf";
		return data;
	}
	
}
