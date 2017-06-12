package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class others {

	public static class dynamicDataLoading
	{
		public static WebElement getNewUser(WebDriver drv)
		{
			return drv.findElement(By.id("save"));
		}
		
		public static WebElement dataDetails(WebDriver drv)
		{
			return drv.findElement(By.id("loading"));
		}
		public static WebElement imageDetails(WebDriver drv)
		{
			return drv.findElement(By.cssSelector("div#loading img"));
		}
		
		
	}
	
}
