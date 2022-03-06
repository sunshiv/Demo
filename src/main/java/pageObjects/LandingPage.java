package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin=By.xpath("//span[normalize-space()='Login']");
	By title=By.xpath("//h3[normalize-space()='An Academy to learn Everything about Testing']");
	By about=By.xpath("//a[normalize-space()='About']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	public WebElement getTittle()
	{
		return driver.findElement(title);
	}
	public WebElement getAbout()
	{
		return driver.findElement(about);
	}
}
