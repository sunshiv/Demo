package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
	prop=new Properties();
	FileInputStream fis=new FileInputStream("E:\\FebE2E\\src\\main\\java\\Resources\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	
	if(browserName.equals("chrome"))
	{
		//execute chrome
		System.setProperty("WebDriver.chrome.driver", "E:\\New\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		//execute firefox
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	public String URL()
	{
		return prop.getProperty("url");
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver; 					//convert/cast driver object to screenshot object
		File source=ts.getScreenshotAs(OutputType.FILE); 				//get screenshot as output file
		//String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		String destinationFile= ".\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile)); 			//store virtually located screenshot to file with test name(@test method)
		return destinationFile;
	}
	
	

}
