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
import pageObjects.InputForms.BootstrapAlertMessages;
import pageObjects.InputForms.TwoInputFields;
import pageObjects.InputForms.singleInputField;

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
	
	//@Test
	public void basicFirstForm()
	{
		drv.get(constants.urlFirstForm);
		
		// First test on the page to check if correct message is getting printed
		singleInputField.user_message(drv).sendKeys(constants.FirstFormMessage);
		singleInputField.showMessage(drv).click();
	    String temp="";
	    temp=singleInputField.yourMessage(drv).getText();
	    Assert.assertEquals(constants.FirstFormMessage, temp);
	    
	    // Second Test to check if addition of number is correct 
	    TwoInputFields.aValue(drv).sendKeys("10");
	    TwoInputFields.bValue(drv).sendKeys("30");
	    TwoInputFields.getTotal(drv).click();
	    String sum=TwoInputFields.displayvalue(drv).getText();
	    Assert.assertEquals(sum, "40");
	    
	}
	
	@Test
	public void bootstrapAlertMessage() throws InterruptedException
	{
		drv.get(constants.urlSecondForm);
		
		// second test on the page to check if buttons are working fine

		BootstrapAlertMessages.autoclosable_btn_success(drv).click();
		Thread.sleep(3000);
		
		BootstrapAlertMessages.normal_btn_success(drv).click();
		BootstrapAlertMessages.autoclosable_btn_warning(drv).click();
		BootstrapAlertMessages.normal_btn_warning(drv).click();
		
		BootstrapAlertMessages.autoclosable_btn_danger(drv).click();
		BootstrapAlertMessages.normal_btn_danger(drv).click();
		BootstrapAlertMessages.autoclosable_btn_info(drv).click();
		BootstrapAlertMessages.normal_btn_info(drv).click();
		
		
	    
	}
	
	
	
	
	
	
	
	@AfterTest
	public void aftersetup()
	{
		drv.quit();
	}
}
