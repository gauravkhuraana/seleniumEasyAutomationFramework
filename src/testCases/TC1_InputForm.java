package testCases;


import utility.constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.InputForms;
import pageObjects.InputForms.SimpleFormDemo;

public class TC1_InputForm {

	WebDriver drv ;
	@BeforeTest
	public void initial()
	{
		//System.setProperty("webdriver.gecko.driver", "H:\\software\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		//DesiredCapabilities cap = DesiredCapabilities.firefox();
		//drv = new FirefoxDriver(cap);
		
		System.setProperty("webdriver.chrome.driver", "H:\\software\\chromedriver_win32\\chromedriver.exe");
		drv=new ChromeDriver();
	}
	
	@Test
	public void test()
	{
		drv.get(constants.urlFirstForm);
		
		// First test on the page to check if correct message is getting printed
		SimpleFormDemo.user_message(drv).sendKeys(constants.FirstFormMessage);
	    SimpleFormDemo.showMessage(drv).click();
	    String temp="";
	    temp=SimpleFormDemo.yourMessage(drv).getText();
	    Assert.assertEquals(constants.FirstFormMessage, temp);
	    		
	}
	
	@AfterTest
	public void aftersetup()
	{
		drv.quit();
	}
}
