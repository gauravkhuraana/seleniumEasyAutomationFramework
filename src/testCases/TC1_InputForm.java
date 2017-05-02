package testCases;


import utility.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.InputForms;
import pageObjects.InputForms.BootstrapAlertMessages;
import pageObjects.InputForms.TwoInputFields;
import pageObjects.InputForms.singleInputField;
import pageObjects.progressBarAndSlider;
import pageObjects.progressBarAndSlider.bootstrapDownload;
import pageObjects.progressBarAndSlider.jQueryDownloadPbar;

public class TC1_InputForm {

	WebDriver drv ;
	@BeforeTest
	public void initial()
	{
		//System.setProperty("webdriver.gecko.driver", "H:\\software\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		//DesiredCapabilities cap = DesiredCapabilities.firefox();
		//drv = new FirefoxDriver(cap);
		
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver_win32\\chromedriver.exe");
		drv=new ChromeDriver();
	}
	
	@Test(enabled=false)
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
	
	@Test(enabled=false)
	public void bootstrapAlertMessage() throws InterruptedException
	{
		drv.get(constants.urlSecondForm);
		
		// second test on the page to check if buttons are working fine

		BootstrapAlertMessages.autoclosable_btn_success(drv).click();
		
        String actualResults=drv.findElement(By.xpath("//*[@class='col-md-6']/div[1]")).getText();
        String expectedResults="I'm an autocloseable success message. I will hide in 5 seconds.";
 
      
        Assert.assertEquals(actualResults, expectedResults);
        System.out.println("Testing system behaviour after 5 seconds");
        Thread.sleep(6000);
        actualResults=drv.findElement(By.xpath("//*[@class='col-md-6']/div[1]")).getText();
        Assert.assertNotEquals(actualResults, expectedResults);
        

		// Normal success Message open and close 
		BootstrapAlertMessages.normal_btn_success(drv).click();
		BootstrapAlertMessages.normal_smsg_close(drv).click();
		
		
		
		BootstrapAlertMessages.autoclosable_btn_warning(drv).click();
		actualResults=drv.findElement(By.xpath("//*[@class='col-md-6']/div[3]")).getText();
		expectedResults="I'm an autocloseable warning message. I will hide in 3 seconds.";
		Assert.assertEquals(actualResults, expectedResults);
	    System.out.println("Testing system behaviour after 4 seconds");
	    Thread.sleep(4000);
	    actualResults=drv.findElement(By.xpath("//*[@class='col-md-6']/div[3]")).getText();
	    Assert.assertNotEquals(actualResults, expectedResults);
		
		BootstrapAlertMessages.normal_btn_warning(drv).click();
		
		BootstrapAlertMessages.autoclosable_btn_danger(drv).click();
		
		
		
		BootstrapAlertMessages.normal_btn_danger(drv).click();
		BootstrapAlertMessages.autoclosable_btn_info(drv).click();
		BootstrapAlertMessages.normal_btn_info(drv).click();
		
		
	    
	}
	
	
	// to download file completely , First click on download button and then close button
	@Test(enabled=false)
	public void testSuucessfulDownload()
	{
		
		drv.navigate().to(utility.constants.queryDownloadProgressBarURL);
		
		//Click on download button
		jQueryDownloadPbar.downloadButton(drv).click();
		
		WebDriverWait wait = new WebDriverWait(drv,10);
		
		// wait for 10 seconds and keep on checking if close button appears  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Close']")));
		
		jQueryDownloadPbar.closeButton(drv).click();
		
	}
	
	// to cancel the download in between
	@Test(enabled=false)
	public void testCancelDownload()
	{
		drv.navigate().to(utility.constants.queryDownloadProgressBarURL);
		
		jQueryDownloadPbar.downloadButton(drv).click();
		
		WebDriverWait wait = new WebDriverWait(drv,3);
		
		drv.switchTo().activeElement();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Cancel Download']")));
		
		jQueryDownloadPbar.cancelDownload(drv).click();
		
	}
	
	
	// to check the progress bar reaches 100%
	@Test(enabled=true)
	public void testProgressBarDownload()
	{
		drv.navigate().to(utility.constants.downloadProgressBarURL);
		
	    bootstrapDownload.downloadButton(drv).click();
		
		WebDriverWait wait = new WebDriverWait(drv,27);
		System.out.println("value is " + bootstrapDownload.percenttext(drv).getText());	
				
		wait.until(ExpectedConditions.textToBePresentInElement( bootstrapDownload.percenttext(drv),"100%"));
	//	wait.until(ExpectedConditions.
    }
	
	@AfterTest
	public void aftersetup()
	{
		//drv.quit();
	}
}
