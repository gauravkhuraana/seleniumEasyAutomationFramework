package testCases;


import utility.constants;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
import pageObjects.alertsAndModals;
import pageObjects.alertsAndModals.bootstrapModalDemo;
import pageObjects.listBox;
import pageObjects.others;
import pageObjects.progressBarAndSlider;
import pageObjects.progressBarAndSlider.bootstrapDownload;
import pageObjects.progressBarAndSlider.dragAndDropRangeSlider;
import pageObjects.progressBarAndSlider.jQueryDownloadPbar;

public class TC1_InputForm {

	WebDriver drv ;
	
	@Parameters("browser")
	
	@BeforeTest
	public void initial(String browser)
	{
		//System.setProperty("webdriver.gecko.driver", "H:\\software\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		//DesiredCapabilities cap = DesiredCapabilities.firefox();
		//drv = new FirefoxDriver(cap);
		
		

		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", ".\\src\\executables\\chromedriver.exe");
		drv=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", ".\\src\\executables\\chromedriver.exe");
            drv = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.ff.driver", ".\\src\\executables\\chromedriver.exe");
			drv = new FirefoxDriver();
		}
			
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
	@Test(enabled=false)
	public void testProgressBarDownload()
	{
		drv.navigate().to(utility.constants.downloadProgressBarURL);
		
	    bootstrapDownload.downloadButton(drv).click();
		
		WebDriverWait wait = new WebDriverWait(drv,27);
						
		wait.until(ExpectedConditions.textToBePresentInElement( bootstrapDownload.percenttext(drv),"100%"));

    }
	
	@Test(enabled=false)
	public void testDragAndDropRangeSliders()
	{
		drv.navigate().to(utility.constants.dragDropRangeSlider);
		
		// Testing default value
		String defaultvalue = dragAndDropRangeSlider.rangeValue(drv).getText();
		Assert.assertEquals(defaultvalue, "10");
		
		Dimension dim = dragAndDropRangeSlider.rangeSlider(drv).getSize();
		System.out.println(" Dimnesion of the range is " + dim.width + "height = " + dim.getHeight() +"height by another way = " + dim.height);
		
		dragAndDropRangeSlider.rangeSlider(drv).click();
		
	}
	
    @Test(priority=-1,enabled=false)
    public void testlaunhingSingleMultipleModal() throws InterruptedException
	{
		drv.navigate().to(constants.bootstrapModal);
		drv.manage().window().maximize();
		WebDriverWait expWait = new WebDriverWait(drv,4);
		
		// Testing default value, printing all the text thats there on the modal box
        bootstrapModalDemo.singleModal(drv).click();
        drv.switchTo().activeElement();
		 expWait.until(ExpectedConditions.visibilityOf(bootstrapModalDemo.modalTitle(drv)));  
		String temp=bootstrapModalDemo.modalTitle(drv).getText();
		Assert.assertEquals(temp, "Modal Title");
		
		temp=bootstrapModalDemo.modalBody(drv).getText();
		Assert.assertEquals(temp, "This is the place where the content for the modal dialog displays");
		
		bootstrapModalDemo.close(drv).click();
        //Thread.sleep(2000);
		expWait.until(ExpectedConditions.visibilityOf(bootstrapModalDemo.singleModal(drv)));

        bootstrapModalDemo.singleModal(drv).click();
        drv.switchTo().activeElement();
	    expWait.until(ExpectedConditions.visibilityOf(bootstrapModalDemo.saveChanges(drv)));
		bootstrapModalDemo.saveChanges(drv).click();

		
		
		
	}
    
    @Test(priority=-15,enabled=false)
    public void dynamicDataLoading() throws InterruptedException, ClientProtocolException, IOException
	{
		drv.navigate().to(constants.dynamicDataLoading);
		drv.manage().window().maximize();
		WebDriverWait expWait = new WebDriverWait(drv,15);
		
		
		// Click on Get New User  
		others.dynamicDataLoading.getNewUser(drv).click();
		
		Thread.sleep(5000);
		expWait.until(ExpectedConditions.visibilityOf(others.dynamicDataLoading.dataDetails(drv)));
		
		String imagesource = others.dynamicDataLoading.imageDetails(drv).getAttribute("src");
		System.out.println("Image URL = " + imagesource);
		
		System.out.println("Image URL = " + others.dynamicDataLoading.dataDetails(drv).getTagName());
		System.out.println("Image URL = " + others.dynamicDataLoading.dataDetails(drv).getText());
		
				
		// Test if image is correctly loaded
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request =   new HttpGet(imagesource);
		HttpResponse response = client.execute(request);
		
		Assert.assertEquals(response.getStatusLine().getStatusCode(),200);
		
		System.out.println("Image loaded successfully");
	
		
	}
    
    @Test(priority=-16,enabled=true)
    public void dataListFilter() throws InterruptedException, ClientProtocolException, IOException
	{
		drv.navigate().to(constants.datalistFilter);
		drv.manage().window().maximize();
        
		//WebElement el1  = listBox.dataListFilter.totalItems(drv);
		
		//List<WebElement> el2 = drv.findElements(By.xpath("//div[@class='searchable-container']/div"));
		//List<WebElement> el3 = el1.findElements(By.xpath("div"));
        
		List<WebElement> el4 = listBox.dataListFilter.totalItems(drv);
		System.out.println("Total elements are " + el4.size());
	
	}
    
	
	
	@AfterTest
	public void aftersetup()
	{
		//drv.quit();
	}
}
